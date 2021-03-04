package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class lab52dahi extends AppCompatActivity {
    Button btnilgeeh2;
    TextView msg2;
    EditText bichihtext2;
    String conversation2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab52dahi);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        btnilgeeh2 = (Button) findViewById(R.id.btnilgeeh2);
        msg2 = (TextView) findViewById(R.id.msg2);
        bichihtext2 = (EditText) findViewById(R.id.bichih2);
        Intent intent = getIntent();
        String conversation1 = intent.getStringExtra("conversation1");

        conversation2 = conversation1 + msg2.getText().toString() + "/nUser2:" + bichihtext2.getText().toString();
        btnilgeeh2.setOnClickListener(v -> ilgeeh2(conversation2));
    }

    private void ilgeeh2(String updatedtext) {
        Intent intent = new Intent(lab52dahi.this, lab5.class);
        intent.putExtra("conversation1",updatedtext);
        startActivity(intent);
    }
    private void write(){

    }
    private void read(){

    }
}