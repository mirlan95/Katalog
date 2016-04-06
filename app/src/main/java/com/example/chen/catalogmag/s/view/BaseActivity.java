package com.example.chen.catalogmag.s.view;

import android.content.DialogInterface;
import android.opengl.Visibility;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

import com.example.chen.catalogmag.R;
import com.example.chen.catalogmag.s.presenter.CategoryPresenter;
import com.example.chen.catalogmag.s.utils.DividerItemDecoration;
import com.example.chen.catalogmag.s.utils.ItemClickListener;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by chen on 05.04.16.
 */
public abstract class BaseActivity extends AppCompatActivity implements ItemClickListener, NavigationView.OnNavigationItemSelectedListener {


    private static final String TAG = BaseActivity.class.getSimpleName();

    @Bind(R.id.recycler_list)
    RecyclerView recyclerView;

    @Bind(R.id.toolbar)
    android.support.v7.widget.Toolbar toolbar;

    DrawerLayout drawer;
    NavigationView navigationView;
    MenuItem progressBar;

    public BaseActivity() {

        Log.d(TAG, this.toString() + " ");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(getLayoutId());
        setProgressBarIndeterminateVisibility(true);
        init();
    }

    void init() {
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(getRootId());
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();
        navigationView = (NavigationView) findViewById(getNavId());
        navigationView.setNavigationItemSelectedListener(this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);


        return true;

    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        progressBar = menu.findItem(R.id.menu_progress_bar);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void onCLickItem(Object object) {

    }

    @Override
    public void onLongClickItem(Object object) {
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        return false;
    }

    void showRemoveElementDialog(String message) {


        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage(message)
                .setTitle(R.string.dialog_title);

        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d(TAG, "OK");
            }
        });

        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    void showError(String message){
        Snackbar.make(drawer, message, Snackbar.LENGTH_LONG).show();
        progressBar.setVisible(false);
    }

    abstract int getLayoutId();

    protected abstract int getNavId();

    abstract int getRootId();
}
