package com.example.lab3;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.android.material.timepicker.TimeFormat;

import java.text.DateFormat;
import java.util.Calendar;

public class lab7n1 extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {
    EditText editDate,editTime;
    Chronometer chronometer;
    boolean running;
    int hour,minutee;
    TextView dateview,timeview;
    Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab7n1);
        ActionBar actionBar = getSupportActionBar();
        actionBarCustomize(actionBar);
    editDate = (EditText) findViewById(R.id.editDate);
    editTime = (EditText) findViewById(R.id.editTime);
    start = (Button) findViewById(R.id.start);
    dateview = (TextView) findViewById(R.id.dateview);
    //timeview = (TextView) findViewById(R.id.timeview);
    chronometer = (Chronometer) findViewById(R.id.chronometer);
    start = (Button) findViewById(R.id.start);
    editDate.setOnFocusChangeListener((v, hasFocus) -> datefocus());
    editTime.setOnFocusChangeListener((v, hasFocus) -> timefocus());
    start.setOnClickListener(v -> startChronometer());
    }
    private void datefocus(){
        DialogFragment datePicker = new DatePickerFragment();
        datePicker.show(getSupportFragmentManager(),"date picker");
    }
    private void timefocus(){
        DialogFragment timePicker = new TimePickerFragment();
        timePicker.show(getSupportFragmentManager(),"time picker");
    }
    private void startChronometer(){
        chronometer.setBase(SystemClock.elapsedRealtime()-hour*60*60*1000-minutee*60*1000);
        chronometer.start();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR,year);
        c.set(Calendar.MONTH,month);
        c.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        String currentDateString = DateFormat.getDateInstance(DateFormat.SHORT).format(c.getTime());
        editDate.setText(currentDateString);
        dateview.setText(currentDateString);
    }
    private void actionBarCustomize(ActionBar actionBar){
        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.background)));
        actionBar.setTitle(" Laboratory-7-1");
        actionBar.setIcon(R.drawable.ic_action_bar_swim);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        hour = hourOfDay;
        minutee = minute;
        String currentTime = hourOfDay + " : " + minute;
        chronometer.setText(currentTime);
        editTime.setText(currentTime);
    }
}