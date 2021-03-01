package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Option extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}

        Button lab2 = (Button) findViewById(R.id.welcome);
        Button lab3 = (Button) findViewById(R.id.welcome2);
        Button lab4 = (Button) findViewById(R.id.welcome5);
        lab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Option.this, calculator.class);
                startActivity(intent);
            }
        });
        lab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Option.this, animal.class);
                startActivity(intent);
            }
        });
        lab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Option.this, lab4.class);
                startActivity(intent);
            }
        });
    }
}