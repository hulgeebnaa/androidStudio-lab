package com.example.lab3;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class lab6n2n2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab6n2n2);
        ActionBar actionBar = getSupportActionBar();
        actionBarCustomize(actionBar);
        Intent intent = getIntent();
        String body = intent.getStringExtra("body");
       TextView bodyview = (TextView) findViewById(R.id.notiBodyView);
       bodyview.setText(body);
    }
    private void actionBarCustomize(ActionBar actionBar){
        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.background)));
        actionBar.setTitle(" Laboratory-6-2");
        actionBar.setIcon(R.drawable.ic_action_bar_swim);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
    }
}