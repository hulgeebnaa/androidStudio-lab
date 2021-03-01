package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class lab4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab4);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}



    }
}