package com.example.chen.catalogmag.s.view;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.chen.catalogmag.R;
import com.example.chen.catalogmag.s.adapter.ItemAdapter;
import com.example.chen.catalogmag.s.model.Product;
import com.example.chen.catalogmag.s.presenter.ItemPresenter;
import com.example.chen.catalogmag.s.utils.DividerItemDecoration;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ItemListActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = ItemListActivity.class.getSimpleName();
    @Bind(R.id.recycler_list)
    RecyclerView recyclerView;

    @Bind(R.id.drawer_item)
    DrawerLayout drawer;

    @Bind(R.id.toolbar)
    android.support.v7.widget.Toolbar toolbar;

    @Bind(R.id.nav_item_main)
    NavigationView navigationView;
    private ItemPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        init();
    }

    void init() {
        ButterKnife.bind(this);
        setTitle(R.string.title_goods);
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

        presenter = new ItemPresenter(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_shops:
                Log.d(TAG, "nav_shops");
                break;

            case R.id.nav_items:
                Log.d(TAG, "nav_shops");
                break;

        }

        drawer.closeDrawer(GravityCompat.START);
//        finish();
        return true;
    }

    public void onShow(List<Product> list) {
        recyclerView.setAdapter(new ItemAdapter(list));
        for (int i = 0; i < list.size(); i++) {
            Log.d(TAG, "onShow " + list.get(i).getTitle());
        }
    }
}
