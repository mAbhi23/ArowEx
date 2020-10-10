package com.example.arowex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class activity_register extends AppCompatActivity {
    TextInputEditText  name;
    TextInputEditText  email;
    TextInputEditText  password;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name =(TextInputEditText ) findViewById(R.id.name);

        email = (TextInputEditText ) findViewById(R.id.email);
        password =(TextInputEditText ) findViewById(R.id.pass);
        register = findViewById(R.id.regBtn);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckDataEntered();
            }
        });

    }

    boolean isEmail(EditText text){
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email)&& Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text){
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    void CheckDataEntered(){
        boolean isValid = true;
        if(isEmpty(name)){
            Toast t = Toast.makeText(this, "You must enter name to register", Toast.LENGTH_SHORT);
            t.show();
            isValid= false;
        }

        if(isEmpty(email)){
            Toast t = Toast.makeText(this, "You must enter email to register", Toast.LENGTH_SHORT);
            t.show();
            isValid= false;
        }
        if(isEmpty(password)){
            Toast t = Toast.makeText(this, "You must enter password to register", Toast.LENGTH_SHORT);
            t.show();
            isValid= false;
        }

        if(isEmail(email) == false){
            email.setError("Enter valid email!");
            isValid= false;
        }

        if(isValid){
            //Code for Register.
        }

    }

    public void viewLoginClicked(View v){
        Intent intent = new Intent(activity_register.this,MainActivity.class);
        startActivity(intent);

    }
}