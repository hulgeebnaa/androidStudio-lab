package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class lab9 extends AppCompatActivity {
    ImageView battery, btn;
    TextView percentage;
    SeekBar seekBar;
    boolean flag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab9);
        this.getSupportActionBar().hide();
        battery = findViewById(R.id.battery);
        btn = findViewById(R.id.btn);
        Drawable d = btn.getDrawable();
        TransitionDrawable td = (TransitionDrawable) d;
        percentage = findViewById(R.id.percentage);
        seekBar = findViewById(R.id.seek);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!flag) {
                    td.startTransition(1000);
                    percentage.setVisibility(View.INVISIBLE);
                    flag = true;
                } else {
                    td.reverseTransition(1000);
                    percentage.setVisibility(View.VISIBLE);
                    flag = false;
                }

            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                percentage.setText(progress + "%");
                if (progress >= 90) {
                    battery.setBackgroundColor(Color.parseColor("#00ff00"));

                } else if (progress >= 20) {
                    battery.setBackgroundColor(Color.parseColor("#ffcc00"));
                } else {
                    battery.setBackgroundColor(Color.parseColor("#ff0000"));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}