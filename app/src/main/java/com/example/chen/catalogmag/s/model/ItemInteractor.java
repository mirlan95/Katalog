package com.example.chen.catalogmag.s.model;

import android.util.Log;

import com.example.chen.catalogmag.s.api.ListItems;
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
//        Call<ListItems> items = Network.getInterface().getItems();
//        items.enqueue(new Callback<ListItems>() {
//            @Override
//            public void onResponse(Call<ListItems> call, Response<ListItems> response) {
//                Log.d(TAG, "onResponse " + response.body().toString());
//                Log.d(TAG, "onResponse " + response.body().getItemList());
//                Log.d(TAG, "onResponse url " + call.request().url());
//                Log.d(TAG, "onResponse msg " + response.message());
//                Log.d(TAG, "onResponse errorBody " + response.errorBody());
//                Log.d(TAG, "onResponse isSuccessful " + response.isSuccessful());
////                presenter.onFinished(response.body().getItemList());
//            }
//
//            @Override
//            public void onFailure(Call<ListItems> call, Throwable t) {
//                t.printStackTrace();
//            }
//        });

        Call<Element> element = Network.getInterface().getElements();
        element.enqueue(new Callback<Element>() {
            @Override
            public void onResponse(Call<Element> call, Response<Element> response) {
                presenter.onFinished(response.body().getProducts());
            }

            @Override
            public void onFailure(Call<Element> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
