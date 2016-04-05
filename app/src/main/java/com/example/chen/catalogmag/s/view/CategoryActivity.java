package com.example.chen.catalogmag.s.view;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.chen.catalogmag.R;
import com.example.chen.catalogmag.s.adapter.CategoryAdapter;
import com.example.chen.catalogmag.s.model.Category;
import com.example.chen.catalogmag.s.presenter.CategoryPresenter;
import com.example.chen.catalogmag.s.utils.DividerItemDecoration;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class CategoryActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private static final String TAG = CategoryActivity.class.getSimpleName();
    private CategoryPresenter presenter;

    @Bind(R.id.recycler_list)
    RecyclerView recyclerView;

    @Bind(R.id.root_category_view)
    DrawerLayout drawer;

    @Bind(R.id.toolbar)
    android.support.v7.widget.Toolbar toolbar;

    @Bind(R.id.nav_view)
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        init();
    }

    void init() {
        ButterKnife.bind(this);
        setTitle(R.string.title_category);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        presenter = new CategoryPresenter(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.add_category) {
            Snackbar.make(drawer, "Add Category ", Snackbar.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
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

    public void showCategories(List<Category> list) {
        recyclerView.setAdapter(new CategoryAdapter(list));
        for (int i = 0; i < list.size(); i++) {
            Log.d(TAG, "drawer " + list.get(i).getTitle());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.nav_shops:
                Log.d(TAG, "nav_shops");
                break;

            case R.id.nav_items:
                startActivity(new Intent(CategoryActivity.this, ItemListActivity.class));
                break;

        }

        drawer.closeDrawer(GravityCompat.START);
//        finish();
        return true;
    }
}
