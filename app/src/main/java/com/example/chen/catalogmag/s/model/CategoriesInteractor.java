package com.example.chen.catalogmag.s.model;

import com.example.chen.catalogmag.s.api.ListCategories;
import com.example.chen.catalogmag.s.api.Network;
import com.example.chen.catalogmag.s.presenter.CategoryPresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by chen on 04.04.16.
 */
public class CategoriesInteractor {


    private static final String TAG = CategoriesInteractor.class.getSimpleName();

    public void getCategory(final CategoryPresenter categoryPresenter) {

        Call<ListCategories> categories = Network.getInterface().getCategories();
        categories.enqueue(new Callback<ListCategories>() {
            @Override
            public void onResponse(Call<ListCategories> call, Response<ListCategories> response) {
                categoryPresenter.onFinished(response.body().getCategories());
            }

            @Override
            public void onFailure(Call<ListCategories> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
