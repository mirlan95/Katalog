package com.example.chen.catalogmag.s.view;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.util.Log;
import android.view.MenuItem;

import com.example.chen.catalogmag.R;
import com.example.chen.catalogmag.s.adapter.ItemAdapter;
import com.example.chen.catalogmag.s.model.Category;
import com.example.chen.catalogmag.s.model.Product;
import com.example.chen.catalogmag.s.presenter.ItemPresenter;
import com.example.chen.catalogmag.s.utils.Constants;

import java.util.List;

public class ItemActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = ItemActivity.class.getSimpleName();

    private ItemPresenter presenter;

    public ItemActivity() {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getCategoryIntent();


    }


    private void getCategoryIntent() {
        setTitle(R.string.title_goods);
        presenter = new ItemPresenter(this);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null){
            Category category = bundle.getParcelable(Constants.CATEGORY);
            Log.d(TAG, " not null " + category.toString());
            presenter.onStart(category.getId());
        } else {
            Log.d(TAG, "null ");
            presenter.onStart();
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_shops:
                Log.d(TAG, "nav_shops");
                break;

            case R.id.nav_start_items_activity:
                Log.d(TAG, "nav_shops");
                break;

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onShow(List<Product> list) {
        recyclerView.setAdapter(new ItemAdapter(list, this));
        for (int i = 0; i < list.size(); i++) {
            Log.d(TAG, "onShow " + list.get(i).toString());
        }
    }

    @Override
    public void onCLickItem(Object object) {
        Log.d(TAG, object.toString());
    }

    @Override
    public void onLongClickItem(Object object) {
        Product product = (Product) object;
        super.showDeleteDialog("Удалить запись " + product.getTitle());
    }

    @Override
    int getLayoutId() {
        return R.layout.activity_item;
    }

    @Override
    int getRootId() {
        return R.id.drawer_item;
    }
    @Override
    protected int getNavId() {
        return R.id.nav_item_view;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void showError(String message) {
        super.showError(message);
    }
}
