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

public class TradeAdapters extends RecyclerView.Adapter<TradeAdapters.ViewHolder> {

    private tradeClass[] listdata;

    // RecyclerView recyclerView;
    public TradeAdapters(tradeClass[] listdata) {
        this.listdata = listdata;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View listItem = inflater.inflate(R.layout.activity_item_trades, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final tradeClass myListData = listdata[position];
        holder.textViewT1buy.setText(listdata[position].getT1buy());
        holder.textViewT1amount.setText(listdata[position].getT1amount());
        holder.textViewT1price.setText(listdata[position].getT1price());



    }

    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewT1buy;
        public TextView textViewT1price;
        public TextView textViewT1amount;



        public LinearLayout linearLayout1;
        public ViewHolder(View itemView) {
            super(itemView);
            this.textViewT1buy = (TextView) itemView.findViewById(R.id.t1buy);
            this.textViewT1amount = (TextView) itemView.findViewById(R.id.t1amount);
            this.textViewT1price = (TextView) itemView.findViewById(R.id.t1price);
            this.linearLayout1 = (LinearLayout) itemView.findViewById(R.id.layout_tradeitem1);

        }
    }
}
