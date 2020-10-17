package com.example.arowex.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.example.arowex.R;
import com.example.arowex.home.model.TopGainerResonse;

import java.util.ArrayList;
import java.util.List;


public class NewestAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<TopGainerResonse> items;
    private Context context;

    public NewestAdapter(Context context) {
        this.context = context;
        items = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.newest_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CardView store;
        TextView shopname;
        ImageView productImage;
        TextView shopDescription, shopaddress, shopphoneno, shopcategory;
        ImageView iv_menu_popup;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }

}