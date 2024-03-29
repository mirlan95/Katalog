package com.example.chen.catalogmag.s.presenter;

import com.example.chen.catalogmag.s.model.CategoriesInteractor;
import com.example.chen.catalogmag.s.model.Category;
import com.example.chen.catalogmag.s.view.CategoryActivity;

import java.util.List;

/**
 * Created by chen on 04.04.16.
 */
public class CategoryPresenter extends Presenter {

    private CategoryActivity context;
    private CategoriesInteractor categoriesInterator;


    public CategoryPresenter(CategoryActivity context) {
        this.context = context;
        categoriesInterator = new CategoriesInteractor();

    }

    @Override
    public void onStart() {
        categoriesInterator.getCategory(this);
    }

    public void onFinished(List<Category> list){
        if(list.size() < 1){
            context.showError("Ничего ненашли по категориям");
        } else {
            context.showCategories(list);
        }


    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {
        context = null;
        categoriesInterator = null;
    }
}
