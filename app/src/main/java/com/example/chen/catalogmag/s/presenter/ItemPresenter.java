package com.example.chen.catalogmag.s.presenter;

import android.util.Log;

import com.example.chen.catalogmag.s.model.ItemInteractor;
import com.example.chen.catalogmag.s.model.Product;
import com.example.chen.catalogmag.s.view.ItemActivity;

import java.util.List;

/**
 * Created by chen on 05.04.16.
 */
public class ItemPresenter extends Presenter {

    private ItemActivity activity;
    private ItemInteractor interactor;

    public ItemPresenter(ItemActivity activity) {
        this.activity = activity;
        interactor = new ItemInteractor();
    }

    private static final String TAG = ItemPresenter.class.getSimpleName();

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {
        activity = null;
        interactor = null;
    }

    @Override
    public void onStart() {
        interactor.getItem(this);
    }

    public void onStart(int categoryId) {
        interactor.getItem(this, categoryId);
    }

    public void onFinished(List<Product> list) {
        if(list.size() < 1){
            Log.d(TAG, "List size 0");
            activity.showError("Сервер ничего не вернул, нету товара");
        }else {
            activity.onShow(list);
        }
    }

}
