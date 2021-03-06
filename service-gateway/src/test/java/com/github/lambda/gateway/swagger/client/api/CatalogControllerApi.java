package com.github.lambda.gateway.swagger.client.api;

import com.github.lambda.gateway.swagger.client.invoker.ApiClient;
import com.github.lambda.gateway.swagger.client.invoker.EncodingUtils;

import com.github.lambda.gateway.swagger.model.CategoryListDTO;
import com.github.lambda.gateway.swagger.model.Failure;
import com.github.lambda.gateway.swagger.model.PaginatedProductDTO;
import com.github.lambda.gateway.swagger.model.ProductContainerDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;


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
   * @return ProductContainerDTO
   */
  @RequestLine("GET /catalog/product/{productId}")
  @Headers({
    "Accept: application/json",
  })
  ProductContainerDTO findOneProduct(@Param("productId") Long productId);

  /**
   * 
   * 
    * @param page  (optional)
    * @param size  (optional)
    * @param sort  (optional)
    * @param categoryId  (optional)
    * @param search  (optional)
    * @param minPrice  (optional)
    * @param maxPrice  (optional)
    * @param minRate  (optional)
    * @param tags  (optional)
    * @param minShippingDate  (optional)
   * @return PaginatedProductDTO
   */
  @RequestLine("GET /catalog/products?page={page}&size={size}&sort={sort}&categoryId={categoryId}&search={search}&minPrice={minPrice}&maxPrice={maxPrice}&minRate={minRate}&tags={tags}&minShippingDate={minShippingDate}")
  @Headers({
    "Accept: application/json",
  })
  PaginatedProductDTO findPaginatedProducts(@Param("page") Long page, @Param("size") Long size, @Param("sort") List<String> sort, @Param("categoryId") Long categoryId, @Param("search") String search, @Param("minPrice") Long minPrice, @Param("maxPrice") Long maxPrice, @Param("minRate") Long minRate, @Param("tags") List<String> tags, @Param("minShippingDate") String minShippingDate);

  /**
   * 
   * 
   * Note, this is equivalent to the other <code>findPaginatedProducts</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link FindPaginatedProductsQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>page -  (optional)</li>
   *   <li>size -  (optional)</li>
   *   <li>sort -  (optional)</li>
   *   <li>categoryId -  (optional)</li>
   *   <li>search -  (optional)</li>
   *   <li>minPrice -  (optional)</li>
   *   <li>maxPrice -  (optional)</li>
   *   <li>minRate -  (optional)</li>
   *   <li>tags -  (optional)</li>
   *   <li>minShippingDate -  (optional)</li>
   *   </ul>
   * @return PaginatedProductDTO
   */
  @RequestLine("GET /catalog/products?page={page}&size={size}&sort={sort}&categoryId={categoryId}&search={search}&minPrice={minPrice}&maxPrice={maxPrice}&minRate={minRate}&tags={tags}&minShippingDate={minShippingDate}")
  @Headers({
  "Accept: application/json",
  })
  PaginatedProductDTO findPaginatedProducts(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>findPaginatedProducts</code> method in a fluent style.
   */
  public static class FindPaginatedProductsQueryParams extends HashMap<String, Object> {
    public FindPaginatedProductsQueryParams page(final Long value) {
      put("page", EncodingUtils.encode(value));
      return this;
    }
    public FindPaginatedProductsQueryParams size(final Long value) {
      put("size", EncodingUtils.encode(value));
      return this;
    }
    public FindPaginatedProductsQueryParams sort(final List<String> value) {
      put("sort", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public FindPaginatedProductsQueryParams categoryId(final Long value) {
      put("categoryId", EncodingUtils.encode(value));
      return this;
    }
    public FindPaginatedProductsQueryParams search(final String value) {
      put("search", EncodingUtils.encode(value));
      return this;
    }
    public FindPaginatedProductsQueryParams minPrice(final Long value) {
      put("minPrice", EncodingUtils.encode(value));
      return this;
    }
    public FindPaginatedProductsQueryParams maxPrice(final Long value) {
      put("maxPrice", EncodingUtils.encode(value));
      return this;
    }
    public FindPaginatedProductsQueryParams minRate(final Long value) {
      put("minRate", EncodingUtils.encode(value));
      return this;
    }
    public FindPaginatedProductsQueryParams tags(final List<String> value) {
      put("tags", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public FindPaginatedProductsQueryParams minShippingDate(final String value) {
      put("minShippingDate", EncodingUtils.encode(value));
      return this;
    }
  }
}
