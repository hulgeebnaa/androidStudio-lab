package com.example.lab3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class lab6n1 extends AppCompatActivity {
    Button udaandar;
    RelativeLayout zugerdar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab6n1);
        ActionBar actionBar = getSupportActionBar();
        actionBarCustomize(actionBar);
        udaandar = (Button) findViewById(R.id.udaandar);
        zugerdar = (RelativeLayout) findViewById(R.id.colorsolino);
        registerForContextMenu(udaandar);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return true;
    }
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.udaandar, menu);
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        switch (item.getItemId()){
            case R.id.zugerdarnone:
                zugerdar.setBackgroundColor(getResources().getColor(R.color.background));
                return true;
            case R.id.zugerdarred:
                zugerdar.setBackgroundColor(getResources().getColor(R.color.red));
                return  true;
            case R.id.zugerdargreen:
                zugerdar.setBackgroundColor(getResources().getColor(R.color.green));
                return  true;
            case R.id.zugerdarblue:
                zugerdar.setBackgroundColor(getResources().getColor(R.color.blue));
                return  true;
            default: return false;
        }
    }
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        super.onContextItemSelected(item);
        switch (item.getItemId()){
            case R.id.udaandarnone:
                udaandar.setBackgroundColor(getResources().getColor(R.color.sharkov));
                return true;
            case R.id.udaandargreen:
                udaandar.setBackgroundColor(getResources().getColor(R.color.green));
                return true;
            case R.id.udaandarred:
                udaandar.setBackgroundColor(getResources().getColor(R.color.red));
                return  true;
            case R.id.udaandarblue:
                udaandar.setBackgroundColor(getResources().getColor(R.color.blue));
                return  true;
            default: return false;
        }
    }
    private void actionBarCustomize(ActionBar actionBar){
        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.background)));
        actionBar.setTitle(" Welcome!");
        actionBar.setIcon(R.drawable.ic_action_bar_swim);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
    }

}