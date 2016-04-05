package com.example.chen.catalogmag.s.presenter;

import android.util.Log;

import com.example.chen.catalogmag.s.model.Item;
import com.example.chen.catalogmag.s.model.ItemInteractor;
import com.example.chen.catalogmag.s.model.Product;
import com.example.chen.catalogmag.s.view.ItemListActivity;

import java.util.List;

/**
 * Created by chen on 05.04.16.
 */
public class ItemPresenter extends Presenter {

    ItemListActivity activity;
    ItemInteractor interactor;

    public ItemPresenter(ItemListActivity activity) {
        this.activity = activity;
        interactor = new ItemInteractor();
    }

    private static final String TAG = ItemPresenter.class.getSimpleName();

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onStart() {
        interactor.getItem(this);
    }

    public void onFinished(List<Product> list) {

        activity.onShow(list);
    }
}
