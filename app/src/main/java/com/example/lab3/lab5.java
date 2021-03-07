package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class lab5 extends AppCompatActivity {
    Button btnilgeeh1;
    TextView msg1;
    EditText bichihtext1;
    String conversation1= " ";
    private SoftInputAssist softInputAssist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        //softInputAssist = new SoftInputAssist(this);
//        InputMethodManager methodManager = (InputMethodManager) this.getSystemService(this.INPUT_METHOD_SERVICE);
//        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        setContentView(R.layout.activity_lab5);
        btnilgeeh1 = (Button) findViewById(R.id.btnilgeeh1);
        msg1 = (TextView) findViewById(R.id.msg1);
        bichihtext1 = (EditText) findViewById(R.id.edittext1);
        Intent intent = getIntent();
        String conversation2 = intent.getStringExtra("conversation2");
        if (conversation2==null){ conversation2 = "";}
        msg1.setText(conversation2);
        String finalConversation = conversation2;
        btnilgeeh1.setOnClickListener(v -> ilgeeh1(finalConversation));
    }
    private void ilgeeh1(String updatedtext) {
        write(read(updatedtext));
    }
    private void write(String updatedtext){
        Intent intent = new Intent(lab5.this, lab52dahi.class);
        intent.putExtra("conversation1",updatedtext);
        bichihtext1.setText(" ");
        startActivity(intent);
    }
    private String read(String conversation2){
        conversation1 = conversation2 + "\nUser-1 : " + bichihtext1.getText().toString();
        return conversation1;
    }
//    protected void onResume(){
//        softInputAssist.onResume();
//        super.onResume();
//    }
//    protected void onPause(){
//        softInputAssist.onPause();
//        super.onPause();
//    }
//    protected void onDestroy(){
//        softInputAssist.onDestroy();
//        super.onDestroy();
//    }
}