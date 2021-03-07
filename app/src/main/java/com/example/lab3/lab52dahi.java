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
    String conversation2 = " ";
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
        String conversation1 = "" + intent.getStringExtra("conversation1");
        msg2.setText(conversation1);
        btnilgeeh2.setOnClickListener(v -> ilgeeh2(conversation1));
    }
    private void ilgeeh2(String updatedtext) {
        write(read(updatedtext));
    }
    private void write(String updatedtext){
        Intent intent = new Intent(lab52dahi.this, lab5.class);
        intent.putExtra("conversation2",updatedtext);
        bichihtext2.setText(" ");
        startActivity(intent);
    }
    private String read(String conversation1){
        conversation2 = conversation1 + "\nUser-2 : " + bichihtext2.getText().toString();
        return conversation2;
    }
}