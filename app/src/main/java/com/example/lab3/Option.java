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
        Button lab7n1 = (Button) findViewById(R.id.lab7n1);
        Button lab7n2 = (Button) findViewById(R.id.lab7n2);
        Button lab8n1 = (Button) findViewById(R.id.lab8n1);
        Button lab8n2 = (Button) findViewById(R.id.lab8n2);
        Button lab9 = (Button) findViewById(R.id.lab9);
        Button lab10 = (Button) findViewById(R.id.lab10);
        Button lab11 = (Button) findViewById(R.id.lab11);
        Button lab12n1 = (Button) findViewById(R.id.lab12n1);
        Button lab12n2 = (Button) findViewById(R.id.lab12n2);
        Button lab13 = (Button) findViewById(R.id.lab13);
        Button lab14 = (Button) findViewById(R.id.lab14);
        Button lab15 = (Button) findViewById(R.id.lab15);
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
        lab7n1.setOnClickListener(v -> lab7n1click());
        lab7n2.setOnClickListener(v -> lab7n2click());
        lab8n1.setOnClickListener(v -> lab8n1click());
        lab8n2.setOnClickListener(v -> lab8n2click());
        lab9.setOnClickListener(v -> lab9click());
        lab10.setOnClickListener(v -> lab10click());
        lab11.setOnClickListener(v -> lab11click());
        lab12n1.setOnClickListener(v -> lab12n1click());
        lab12n2.setOnClickListener(v -> lab12n2click());
        lab13.setOnClickListener(v -> lab13click());
        lab14.setOnClickListener(v -> lab14click());
        lab15.setOnClickListener(v -> lab15click());
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
    private void lab7n1click() {
        Intent intent = new Intent(Option.this, lab7n1.class);
        startActivity(intent);
    }
    private void lab7n2click() {
        Intent intent = new Intent(Option.this, lab7n2.class);
        startActivity(intent);
    }
    private void lab8n1click() {
        Intent intent = new Intent(Option.this, lab8.class);
        startActivity(intent);
    }
    private void lab8n2click() {
        Intent intent = new Intent(Option.this, lab8n2.class);
        startActivity(intent);
    }
    private void lab9click() {
        Intent intent = new Intent(Option.this, lab9.class);
        startActivity(intent);
    }
    private void lab10click() {
        Intent intent = new Intent(Option.this, lab10nav.class);
        startActivity(intent);
    }
    private void lab11click() {
        Intent intent = new Intent(Option.this, lab11.class);
        startActivity(intent);
    }
    private void lab12n1click() {
        Intent intent = new Intent(Option.this, lab12n1.class);
        startActivity(intent);
    }
    private void lab12n2click() {
        Intent intent = new Intent(Option.this, lab12n2.class);
        startActivity(intent);
    }
    private void lab13click() {
        Intent intent = new Intent(Option.this, lab13.class);
        startActivity(intent);
    }
    private void lab14click() {
        Intent intent = new Intent(Option.this, lab14.class);
        startActivity(intent);
    }
    private void lab15click() {
        Intent intent = new Intent(Option.this, lab15.class);
        startActivity(intent);
    }
}