package com.example.chen.catalogmag.s.api;

import com.example.chen.catalogmag.s.model.Category;
import com.example.chen.catalogmag.s.model.Element;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by chen on 04.04.16.
 */
public interface Api {

    @GET("/categories.json?format=json")
    Call<ListCategories> getCategories();

    @GET("/products.json?format=json")
    Call<ListItems> getItems();

    @GET("/products.json?format=json")
    Call<Element> getElements();
}
