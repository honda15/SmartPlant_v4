package com.example.smartplant_v4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btn_login(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    public void btn_register(View view) {
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }


}