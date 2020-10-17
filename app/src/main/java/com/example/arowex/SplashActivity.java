package com.example.arowex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.arowex.dashboard.DashboardActivity;


public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

     new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
              startActivity(new Intent(getBaseContext(), DashboardActivity.class));
              finish();
            }
        },1000);
    }
}