package com.example.arowex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class activity_markets extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_markets);

        Market[] markets = new Market[] {
                new Market(" BTC", "1150779","-0.39%"),
                new Market(" ETH", "24335.65","-0.35%"),
                new Market(" HT", "6764.56","+0.43%"),
                new Market(" XRP", "1314.76","+43.54%"),
                new Market(" LINK", "2453.74","-12.54%"),
                new Market(" BCH", "2334.33", "-23.23%"),
                new Market(" LTC", "5134.33", "+11.43%"),
                new Market(" BSV", "9754.33", "-43.87%"),
                new Market(" XRP", "1314.76","+43.54%"),
                new Market(" LINK", "2453.74","-12.54%"),
                new Market(" BCH", "2334.33", "-23.23%"),
                new Market(" LTC", "5134.33", "+11.43%"),
                new Market(" BSV", "9754.33", "-43.87%"),
        };


        RecyclerView rvmarkets = findViewById(R.id.rvMarkets);
        rvmarkets.setHasFixedSize(true);
        rvmarkets.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rvmarkets.setItemAnimator(new DefaultItemAnimator());
        MarketAdapters adapter = new MarketAdapters(markets);
        rvmarkets.setAdapter(adapter);

    }



}