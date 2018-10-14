package com.github.lambda.playground.swagger.client.api;

import com.github.lambda.playground.swagger.client.invoker.ApiClient;
import com.github.lambda.playground.swagger.client.invoker.EncodingUtils;

import com.github.lambda.playground.swagger.model.CategoryListDTO;
import com.github.lambda.playground.swagger.model.Failure;
import com.github.lambda.playground.swagger.model.ProductDTO;
import com.github.lambda.playground.swagger.model.ProductListDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-10-14T21:41:39.221+09:00")
public interface CatalogControllerApi extends ApiClient.Api {


  /**
   * 
   * 
   * @return CategoryListDTO
   */
  @RequestLine("GET /catalog/categories")
  @Headers({
    "Accept: application/json",
  })
  CategoryListDTO findAllCategories();

  /**
   * 
   * 
    * @param productId  (required)
   * @return ProductDTO
   */
  @RequestLine("GET /catalog/product/{productID}")
  @Headers({
    "Accept: application/json",
  })
  ProductDTO findOneProduct(@Param("productId") Long productId);

  /**
   * 
   * 
    * @param productId  (required)
    * @param page  (required)
    * @param count  (required)
   * @return ProductListDTO
   */
  @RequestLine("GET /catalog/products")
  @Headers({
    "Accept: application/json",
  })
  ProductListDTO findPaginatedProducts(@Param("productId") Long productId, @Param("page") Long page, @Param("count") Long count);
}
