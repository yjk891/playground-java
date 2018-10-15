package com.github.lambda.gateway.swagger.client.api;

import com.github.lambda.gateway.swagger.client.invoker.ApiClient;
import com.github.lambda.gateway.swagger.client.invoker.EncodingUtils;

import com.github.lambda.gateway.swagger.model.Failure;
import com.github.lambda.gateway.swagger.model.UserDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-10-15T14:42:53.778+09:00")
public interface AuthControllerApi extends ApiClient.Api {


  /**
   * 
   * 
   * @return UserDTO
   */
  @RequestLine("GET /auth/login")
  @Headers({
    "Accept: application/json",
  })
  UserDTO login();

  /**
   * 
   * 
   */
  @RequestLine("GET /auth/logout")
  @Headers({
    "Accept: application/json",
  })
  void logout();

  /**
   * 
   * 
    * @param body  (optional)
   * @return UserDTO
   */
  @RequestLine("POST /auth/register")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  UserDTO register(UserDTO body);

  /**
   * 
   * 
   * @return UserDTO
   */
  @RequestLine("GET /auth/whoiam")
  @Headers({
    "Accept: application/json",
  })
  UserDTO whoiam();
}