package com.example.chen.catalogmag.s.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.chen.catalogmag.R;

public class ItemListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        setTitle(R.string.item);
    }
}
