package com.example.chen.catalogmag.s.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.chen.catalogmag.R;
import com.example.chen.catalogmag.s.model.Category;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by chen on 04.04.16.
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private static final String TAG = CategoryAdapter.class.getSimpleName();
    private List<Category> list = new ArrayList();
    private LayoutInflater inflater;
    private View view;

    public CategoryAdapter(List<Category> list) {
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (inflater == null) {
            inflater = (LayoutInflater) parent.getContext()
                                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        view = inflater.inflate(R.layout.item_cateogry, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        Log.d(TAG, "onCreateViewHolde listSize " + list.size());
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setData(list.get(position).getTitle(), position);
        Log.d(TAG, "onBindViewHolder listSize " + list.size());
    }


    @Override
    public int getItemCount() {
        return this.list.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.category)
        TextView category;

        @Bind(R.id.position)
        TextView position;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public  void setData(String category, int position){
            this.category.setText(category);
            Log.d(TAG, "setData " + category);
            this.position.setText((position+1) + "");
        }
    }


}
