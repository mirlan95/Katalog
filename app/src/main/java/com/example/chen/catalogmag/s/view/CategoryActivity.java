package com.example.chen.catalogmag.s.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.chen.catalogmag.R;
import com.example.chen.catalogmag.s.adapter.CategoryAdapter;
import com.example.chen.catalogmag.s.model.Category;
import com.example.chen.catalogmag.s.presenter.CategoryPresenter;
import com.example.chen.catalogmag.s.presenter.Presenter;
import com.example.chen.catalogmag.s.utils.DividerItemDecoration;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CategoryActivity extends AppCompatActivity {


    private static final String TAG = CategoryActivity.class.getSimpleName();
    private CategoryPresenter presenter;

    @Bind(R.id.recycler_list)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        ButterKnife.bind(this);
        init();

    }

    void init(){
        setTitle(R.string.title_category);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        presenter = new CategoryPresenter(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    public void showCategories(List<Category> list){
        recyclerView.setAdapter(new CategoryAdapter(list));
        for (int i = 0; i < list.size(); i++) {
            Log.d(TAG, "view " + list.get(i).getTitle());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
