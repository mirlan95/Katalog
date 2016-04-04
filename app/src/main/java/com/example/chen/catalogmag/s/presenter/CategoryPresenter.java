package com.example.chen.catalogmag.s.presenter;

import android.content.Context;

import com.example.chen.catalogmag.s.model.CategoriesInterator;
import com.example.chen.catalogmag.s.model.Category;
import com.example.chen.catalogmag.s.view.CategoryActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen on 04.04.16.
 */
public class CategoryPresenter extends Presenter {

    CategoryActivity context;
    CategoriesInterator categoriesInterator;


    public CategoryPresenter(CategoryActivity context) {
        this.context = context;
        categoriesInterator = new CategoriesInterator();

    }

    @Override
    public void onStart() {
        categoriesInterator.getCategory(this);
    }

    public void onFinished(List<Category> list){
        context.showCategories(list);
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }
}
