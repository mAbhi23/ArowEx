package com.example.arowex.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.arowex.R;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText  email;
    TextInputEditText  pass;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setupUI();
        setupListeners();
    }

    private void setupUI() {
        email =(TextInputEditText ) findViewById(R.id.email);
        pass =(TextInputEditText ) findViewById(R.id.pass);
        login = findViewById(R.id.loginBtn);
    }

    private void setupListeners() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckDataEntered();
            }
        });


    }


    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    void CheckDataEntered() {
        boolean isValid = true;
        if (!isEmail(email)) {
                email.setError("Enter valid email!");
                isValid = false;
            }
        if (isEmpty(pass)) {
            pass.setError("You must enter password to login!");
            isValid = false;
        } else {
            if (pass.getText().toString().length() < 4) {
                pass.setError("Password must be at least 4 chars long!");
                isValid = false;
            }
        }

        if (isValid) {
            //Code for Login.
        }
    }

    public void viewRegisterClicked(View v){
        Intent intent = new Intent(MainActivity.this, activity_register.class);
        startActivity(intent);

    }

    public void viewForgetPassClicked(View v){
        Intent intent = new Intent(MainActivity.this, activity_forgetpass.class);
        startActivity(intent);
    }




}