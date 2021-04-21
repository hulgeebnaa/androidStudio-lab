package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class lab8n2 extends AppCompatActivity {
    GridView gridView;
    int image[] = {R.drawable.bird01,R.drawable.bird02,R.drawable.bird03,R.drawable.bird04,R.drawable.bird05,R.drawable.bird06,R.drawable.bird07,R.drawable.bird08,R.drawable.bird09,R.drawable.bird10,R.drawable.bird11,R.drawable.bird12};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab8n2);
        try {
            this.getSupportActionBar().hide();
        }catch(NullPointerException e){}
        gridView = (GridView) findViewById(R.id.grid_view);
        CustomAdapter adapter = new CustomAdapter(lab8n2.this,image);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(lab8n2.this,"Selected"+image[position],Toast.LENGTH_SHORT).show();
            }
        });


    }
}