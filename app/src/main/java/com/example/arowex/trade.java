package com.example.arowex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class trade extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trade);

//trade1
        tradeClass[] trades = new tradeClass[] {
                new tradeClass(" 1", "452345","65654"),
                new tradeClass(" 2", "453575","14356"),
                new tradeClass(" 3", "233423","54576"),
                new tradeClass(" 4", "456823","38615"),
                new tradeClass(" 5", "863535","62765"),
                new tradeClass(" 1", "345555","65554"),
                new tradeClass(" 2", "453575","14356"),
                new tradeClass(" 3", "233423","54576"),
                new tradeClass(" 4", "456823","38615"),
                new tradeClass(" 5", "863535","62765"),


        };


        RecyclerView rvtrades = findViewById(R.id.rvTrade1);
        rvtrades.setHasFixedSize(true);
        rvtrades.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rvtrades.setItemAnimator(new DefaultItemAnimator());
        TradeAdapters adapter = new TradeAdapters(trades);
        rvtrades.setAdapter(adapter);

        //trade2
        tradeClass2[] trades2 = new tradeClass2[] {
                new tradeClass2(" 1", "235467","65654"),
                new tradeClass2(" 2", "453575","14356"),
                new tradeClass2(" 3", "233423","54576"),
                new tradeClass2(" 4", "456823","38615"),
                new tradeClass2(" 5", "863535","62765"),
                new tradeClass2(" 1", "235555","65554"),
                new tradeClass2(" 2", "453575","14356"),
                new tradeClass2(" 3", "233423","54576"),
                new tradeClass2(" 4", "456823","38615"),
                new tradeClass2(" 5", "863535","62765"),


        };


        RecyclerView rvtrades2 = findViewById(R.id.rvTrade2);
        rvtrades2.setHasFixedSize(true);
        rvtrades2.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rvtrades2.setItemAnimator(new DefaultItemAnimator());
        TradeAdapters2 adapter2 = new TradeAdapters2(trades2);
        rvtrades2.setAdapter(adapter2);








        // Spinner element
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);


        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Limit order");
        categories.add("Market order");
        categories.add("Stop-Limit");
        categories.add("Trigger order");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);




    }
}