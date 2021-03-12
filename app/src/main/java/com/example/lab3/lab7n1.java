package com.example.lab3;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.util.Calendar;

public class lab7n1 extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {
    EditText editDate,editTime;
    TextView dateview;
    Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab7n1);
    editDate = (EditText) findViewById(R.id.editDate);
    editTime = (EditText) findViewById(R.id.editTime);
    start = (Button) findViewById(R.id.start);
    dateview = (TextView) findViewById(R.id.dateview);
    editDate.setOnFocusChangeListener((v, hasFocus) -> datefocus());
    editTime.setOnFocusChangeListener((v, hasFocus) -> timefocus());
    }
    private void datefocus(){
        DialogFragment datePicker = new DatePickerFragment();
        datePicker.show(getSupportFragmentManager(),"date picker");
    }
    private void timefocus(){
        DialogFragment timePicker = new TimePickerFragment();
        timePicker.show(getSupportFragmentManager(),"time picker");
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
        actionBar.setTitle(" Welcome!");
        actionBar.setIcon(R.drawable.ic_action_bar_swim);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        String currentTime ;

    }
}