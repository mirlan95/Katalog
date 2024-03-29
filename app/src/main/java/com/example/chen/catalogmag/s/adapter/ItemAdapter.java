package com.example.chen.catalogmag.s.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chen.catalogmag.R;
import com.example.chen.catalogmag.s.model.Product;
import com.example.chen.catalogmag.s.utils.ItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by chen on 04.04.16.
 */
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private static final String TAG = ItemAdapter.class.getSimpleName();
    private static List<Product> list = new ArrayList();
    private LayoutInflater inflater;
    private View view;
    private ItemClickListener listener;

    public ItemAdapter(List<Product> list, ItemClickListener listener) {
        this.list = list;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (inflater == null) {
            inflater = (LayoutInflater) parent.getContext()
                                                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        view = inflater.inflate(R.layout.item_element, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int adapterPos = holder.getAdapterPosition();
                if (adapterPos != RecyclerView.NO_POSITION) {
                    listener.onCLickItem(list.get(adapterPos));
                }
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                int adapterPos = holder.getAdapterPosition();
                if (adapterPos != RecyclerView.NO_POSITION) {
                    listener.onLongClickItem(list.get(adapterPos));
                    return true;
                }
                return false;
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setData(list.get(position), position);
    }


    @Override
    public int getItemCount() {
        return this.list.size();
    }




    public static class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.item)
        TextView item;

        @Bind(R.id.price)
        TextView price;

        @Bind(R.id.description)
        TextView description;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public  void setData(Product product, int position){
            this.item.setText(product.getTitle());
            this.price.setText(product.getPrice());
            this.description.setText(product.getText());
        }

        @OnClick(R.id.item_image)
        void onClickImage(View v){
            Log.d(TAG, "itemView " + list.get(getAdapterPosition()).getTitle());

        }
    }


}
