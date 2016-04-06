package com.example.chen.catalogmag.s.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.chen.catalogmag.R;
import com.example.chen.catalogmag.s.adapter.CategoryAdapter;
import com.example.chen.catalogmag.s.model.Category;
import com.example.chen.catalogmag.s.presenter.CategoryPresenter;
import com.example.chen.catalogmag.s.utils.Constants;

import java.util.List;


public class CategoryActivity extends BaseActivity implements
        NavigationView.OnNavigationItemSelectedListener {


    private static final String TAG = CategoryActivity.class.getSimpleName();
    private CategoryPresenter presenter;

    public CategoryActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
    }

    @Override
    void init() {
        setTitle(R.string.title_category);
        presenter = new CategoryPresenter(this);
        presenter.onStart();
        super.init();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.add_category) {
            Snackbar.make(drawer, "Add Category ", Snackbar.LENGTH_LONG).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }


    public void showCategories(List<Category> list) {
        recyclerView.setAdapter(new CategoryAdapter(list, this));
        for (int i = 0; i < list.size(); i++) {
            Log.d(TAG, "category " + list.get(i));
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.nav_shops:
                Log.d(TAG, "nav_shops");
                break;

            case R.id.nav_start_items_activity:
                startActivity(new Intent(CategoryActivity.this, ItemActivity.class));
                break;

            case R.id.nav_add_category:
                showAddDialog();
                break;

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    void showAddDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.add_dialog_category, null);
        final EditText editText = (EditText) dialogView.findViewById(R.id.new_category_value);

        builder.setView(dialogView)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d(TAG, "OK" + " value " + editText.getText().toString());
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });


        AlertDialog dialog = builder.create();
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                final Button positiveButton = ((AlertDialog) dialog).getButton(DialogInterface.BUTTON_POSITIVE);
                if (editText.length() == 0) {
                    positiveButton.setEnabled(false);
                }
                editText.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        if (count > 0) {
                            positiveButton.setEnabled(true);
                        } else {
                            positiveButton.setEnabled(false);
                        }
//                        Log.d(TAG, "start " + start);
//                        Log.d(TAG, "before " + before);
//                        Log.d(TAG, "count  " + count);
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });
            }
        });
        dialog.show();
    }

    @Override
    public void onCLickItem(Object object) {
        Intent intent = new Intent(CategoryActivity.this, ItemActivity.class);

        intent.putExtra(Constants.CATEGORY, (Category) object);
        startActivity(intent);
    }

    @Override
    public void onLongClickItem(Object object) {
        Category category = (Category) object;
        super.showDeleteDialog("Удалить запись " + category.getTitle());
    }

    @Override
    int getLayoutId() {
        return R.layout.activity_category;
    }

    @Override
    int getRootId() {
        return R.id.root_category_view;
    }

    @Override
    protected int getNavId() {
        return R.id.nav_category_view;
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
