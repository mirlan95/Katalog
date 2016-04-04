package com.example.chen.catalogmag.s.api;

import com.example.chen.catalogmag.s.model.Category;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by chen on 04.04.16.
 */
public interface Api {

    @GET("/categories.json?format=json")
    Call<ListCategories> getCategories();

    @GET("/categories.json?format=json")
    Call<List<Category>> getCategoriesSimple();
}
