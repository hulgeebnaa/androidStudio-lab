package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class lab12n2 extends AppCompatActivity {
    Button threadStart;
    SeekBar process1, process2;
    TextView process1text, process2text;
    Handler mainHandler = new Handler();
    private static final String TAG = "lab12n2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab12n2);
        this.getSupportActionBar().hide();

        threadStart = (Button) findViewById(R.id.threadStart);
        process1 = (SeekBar) findViewById(R.id.process1);
        process2 = (SeekBar) findViewById(R.id.process2);
        process1text = (TextView) findViewById(R.id.process1txt);
        process2text = (TextView) findViewById(R.id.process2txt);
        threadStart.setOnClickListener(v -> threadStartclick());
    }

    private void threadStartclick() {
        startThread();
    }


    public void startThread() {
        new Thread() {
            @Override
            public void run() {
                updateui1();
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                updateui2();
            }
        }.start();
    }


    public void updateui1() {
        for (int i = process1.getProgress() + 1; i <= 100; i++) {
            int finalI1 = i;
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    process1.setProgress(finalI1);
                    process1text.setText("Process 1 : " + finalI1 + "%");
                }
            });
            SystemClock.sleep(100);
        }
    }

    public void updateui2() {
        for (int i = process2.getProgress() + 1; i <= 100; i++) {
            int finalI1 = i;
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    process2.setProgress(finalI1);
                    process2text.setText("Process 2 : " + finalI1 + "%");
                }
            });
            SystemClock.sleep(100);
        }
    }
}
