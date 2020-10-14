package com.example.arowex;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TradeAdapters2 extends RecyclerView.Adapter<TradeAdapters2.ViewHolder> {

    private tradeClass2[] listdata;

    // RecyclerView recyclerView;
    public TradeAdapters2(tradeClass2[] listdata) {
        this.listdata = listdata;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View listItem = inflater.inflate(R.layout.item_trades2, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final tradeClass2 myListData = listdata[position];
        holder.textViewT2sell.setText(listdata[position].getT2sell());
        holder.textViewT2amount.setText(listdata[position].getT2amount());
        holder.textViewT2price.setText(listdata[position].getT2price());



    }

    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewT2sell;
        public TextView textViewT2amount;
        public TextView textViewT2price;



        public LinearLayout linearLayout2;
        public ViewHolder(View itemView) {
            super(itemView);
            this.textViewT2sell = (TextView) itemView.findViewById(R.id.t2sell);
            this.textViewT2amount = (TextView) itemView.findViewById(R.id.t2amount);
            this.textViewT2price = (TextView) itemView.findViewById(R.id.t2price);
            this.linearLayout2 = (LinearLayout) itemView.findViewById(R.id.layout_tradeitem2);

        }
    }
}
