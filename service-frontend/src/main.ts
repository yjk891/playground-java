import Vue from 'vue'
import Router from 'vue-router'

import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import locale from 'element-ui/lib/locale/lang/en'
import 'vue-awesome/icons'


import App from '@/App.vue'
import routes from '@/router.ts'
import store from '@/store'
import '@/registerServiceWorker'
import {AuthAPI} from '@/common/auth.service.ts'
import {Failure} from '@/generated/swagger'

import Icon from 'vue-awesome/components/Icon.vue'
Vue.use(ElementUI, {locale})
Vue.component('v-icon', Icon)


const router = new Router({
  routes,
})

AuthAPI.whoiam({credentials: 'include'})
  .then((response) => {
    router.beforeEach((to: any, from: any, next: any) => {
      // if the page doesn't require authentication, move to the page
      if (!to.matched.some((record: any) => record.meta.requiresAuth)) {
        store.commit('changePath', to.path)
        return next()
      }

      // check user is authenticated
      const username = store.state.username
      if (!username) {
        if (to.name === 'login') {
          store.commit('changePath', '/login')
          return next('login')
        }

        // if not, redirect to the login page with flash message
        store.commit('setFlashMessage', `Please Login for '${to.path}'`)
        store.commit('changePath', '/login')
        return next('login')
      }

      next()
    })

    if (!response.username || response.username.trim() === '') {
      store.commit('logout')
      store.commit('changePath', '/login')
      router.push('/login')
      return
    }

    store.commit('login', response.username)
    store.commit('changePath', '/')
  })
  .catch((response) => {
    if (!response.json) {
      console.error("Unknown error occurred", response)

      return
    }
    response.json().then((parsed: Failure) => {
      router.push('/login')
    })
  })


Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: (h) => h(App),
}).$mount('#app')