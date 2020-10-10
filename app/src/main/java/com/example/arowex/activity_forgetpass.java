package com.example.arowex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

public class activity_forgetpass extends AppCompatActivity {
    TextInputEditText email;
    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpass);

        email = (TextInputEditText ) findViewById(R.id.email);

        reset =(Button) findViewById(R.id.regBtn);


    }

}