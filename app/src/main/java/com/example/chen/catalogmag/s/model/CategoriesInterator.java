package com.example.chen.catalogmag.s.model;

import com.example.chen.catalogmag.s.api.Network;
import com.example.chen.catalogmag.s.presenter.CategoryPresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by chen on 04.04.16.
 */
public class CategoriesInterator {


    private static final String TAG = CategoriesInterator.class.getSimpleName();

    public void getCategory(final CategoryPresenter categoryPresenter) {
        Call<List<Category>> cat = Network.getInterface().getCategoriesSimple();
        cat.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                categoryPresenter.onFinished(response.body());
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                t.printStackTrace();

            }
        });

//        Call<ListCategories> categories = Network.getInterface().getCategories();
//        categories.enqueue(new Callback<ListCategories>() {
//            @Override
//            public void onResponse(Call<ListCategories> call, Response<ListCategories> response) {
//                Log.d(TAG, "onResponse");
//            }
//
//            @Override
//            public void onFailure(Call<ListCategories> call, Throwable t) {
//                t.printStackTrace();
//            }
//        });
    }
}
