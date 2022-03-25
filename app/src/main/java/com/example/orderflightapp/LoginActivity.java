package com.example.orderflightapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void SignIn(View view) {
        Intent intent = new Intent(LoginActivity.this, Index.class);
        startActivity(intent);
    }

    public void GoForgotPass(View view) {
    }

    public void CreateAccount(View view) {
    }
}

