package com.example.chen.catalogmag.s.model;

import com.example.chen.catalogmag.s.api.Network;
import com.example.chen.catalogmag.s.presenter.ItemPresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by chen on 05.04.16.
 */
public class ItemInteractor {


    private static final String TAG = ItemInteractor.class.getSimpleName();

    public void getItem(final ItemPresenter presenter){

        Call<ListItems> element = Network.getInterface().getAllItems();
        element.enqueue(new Callback<ListItems>() {
            @Override
            public void onResponse(Call<ListItems> call, Response<ListItems> response) {
                presenter.onFinished(response.body().getProducts());
            }

            @Override
            public void onFailure(Call<ListItems> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void getItem(final ItemPresenter presenter, int categoryId){

        Call<ListItems> element = Network.getInterface().getItemsByCategory(categoryId);
        element.enqueue(new Callback<ListItems>() {
            @Override
            public void onResponse(Call<ListItems> call, Response<ListItems> response) {
                presenter.onFinished(response.body().getProducts());
            }

            @Override
            public void onFailure(Call<ListItems> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
