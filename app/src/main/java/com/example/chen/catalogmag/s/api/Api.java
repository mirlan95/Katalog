package com.example.chen.catalogmag.s.api;

import com.example.chen.catalogmag.s.model.ListItems;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by chen on 04.04.16.
 */
public interface Api {

    @GET("/categories.json?format=json")
    Call<ListCategories> getCategories();

    @GET("/products.json?format=json") //category_id=2&&format=json
    Call<ListItems> getItemsByCategory(@Query("category_id") int category_id);

    @GET("/products.json?format=json")
    Call<ListItems> getAllItems();
}
