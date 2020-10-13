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

public class MarketAdapters extends RecyclerView.Adapter<MarketAdapters.ViewHolder> {

    private Market[] listdata;

    // RecyclerView recyclerView;
    public MarketAdapters(Market[] listdata) {
        this.listdata = listdata;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View listItem = inflater.inflate(R.layout.activity_item_markets, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Market myListData = listdata[position];
        holder.textViewName.setText(listdata[position].getName());
        holder.textViewPrice.setText(listdata[position].getPrice());
        holder.textViewButton.setText(listdata[position].getBtnText());
        if(listdata[position].getBtnText().contains("+")){
            holder.textViewButton.setBackgroundResource(R.drawable.rounder_btn_green);
        };
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"click on item: "+myListData.getName(),Toast.LENGTH_LONG).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewName;
        public TextView textViewPrice;
        public Button textViewButton;
        public LinearLayout linearLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.name);
            this.textViewPrice = (TextView) itemView.findViewById(R.id.price);
            this.textViewButton = (Button) itemView.findViewById(R.id.button);
            this.linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);

        }
    }
}
