package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class lab5 extends AppCompatActivity {
    Button btnilgeeh1;
    TextView msg1;
    EditText bichihtext1;
    String conversation1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab5);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        btnilgeeh1 = (Button) findViewById(R.id.btnilgeeh1);
        msg1 = (TextView) findViewById(R.id.msg1);
        bichihtext1 = (EditText) findViewById(R.id.edittext1);
        conversation1 = msg1.getText().toString() + "/nUser1:" + bichihtext1.getText().toString();
        btnilgeeh1.setOnClickListener(v -> ilgeeh1(conversation1));
    }

    private void ilgeeh1(String updatedtext) {
        Intent intent = new Intent(lab5.this, lab52dahi.class);
        intent.putExtra("conversation1",updatedtext);
        startActivity(intent);
    }

}