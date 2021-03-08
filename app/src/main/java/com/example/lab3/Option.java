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
        Button lab5 = (Button) findViewById(R.id.lab5);
        Button lab5btn = (Button) findViewById(R.id.lab5btn);
        Button lab6menu = (Button) findViewById(R.id.lab6menu);
        Button lab6noti = (Button) findViewById(R.id.lab6noti);
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
        lab5.setOnClickListener(v -> lab5click());
        lab5btn.setOnClickListener(v -> lab5btnclick());
        lab6menu.setOnClickListener(v -> lab6menu());
        lab6noti.setOnClickListener(v -> lab6noti());
    }

    private void lab5click() {
        Intent intent = new Intent(Option.this, lab5.class);
        startActivity(intent);
    }
    private void lab5btnclick() {
        Intent intent = new Intent(Option.this, lab5_btn.class);
        startActivity(intent);
    }
    private void lab6menu() {
        Intent intent = new Intent(Option.this, lab6n1.class);
        startActivity(intent);
    }
    private void lab6noti() {
        Intent intent = new Intent(Option.this, lab6n2.class);
        startActivity(intent);
    }
}