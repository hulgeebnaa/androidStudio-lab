package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class calculator extends AppCompatActivity {
Button btnnemeh, btnhasah, btnurjih, btnhuvaah, btnclear;
TextView hariu;
EditText number1,number2;
Float answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.activity_calculator);

        btnclear = (Button) findViewById(R.id.clear_btn);
        btnnemeh = (Button) findViewById(R.id.nemeh_btn);
        btnhasah = (Button) findViewById(R.id.hasah_btn);
        btnurjih = (Button) findViewById(R.id.urj_btn);
        btnhuvaah = (Button) findViewById(R.id.huvaah_btn);
        hariu = (TextView) findViewById(R.id.hariu);
        number1 = (EditText) findViewById(R.id.number1);
        number2 = (EditText) findViewById(R.id.number2);

        btnnemeh.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                answer = Float.parseFloat(String.valueOf(number1.getText())) + Float.parseFloat(String.valueOf(number2.getText()));
                hariu.setText(String.valueOf(answer));
            }
        });
        btnhasah.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                answer = Float.parseFloat(String.valueOf(number1.getText())) - Float.parseFloat(String.valueOf(number2.getText()));
                hariu.setText(String.valueOf(answer));
            }
        });
        btnurjih.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                answer = Float.parseFloat(String.valueOf(number1.getText())) * Float.parseFloat(String.valueOf(number2.getText()));
                hariu.setText(String.valueOf(answer));
            }
        });
        btnhuvaah.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                answer = Float.parseFloat(String.valueOf(number1.getText())) / Float.parseFloat(String.valueOf(number2.getText()));
                hariu.setText(String.valueOf(answer));
            }
        });
        btnclear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                hariu.setText("0.0");
                number1.setText("");
                number2.setText("");
            }
        });
    }

}