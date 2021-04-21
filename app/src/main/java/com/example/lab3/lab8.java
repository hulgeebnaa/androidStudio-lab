package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class lab8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ListView simpleListView;
        String[] animalName={"Lion","Tiger","Monkey","Dog","Cat","Elephant"};//animal names array
        int[] animalImages = {R.drawable.lion, R.drawable.tiger, R.drawable.monkey, R.drawable.dog8, R.drawable.cat8, R.drawable.elephant};//animal images array
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab8);
        this.getSupportActionBar().hide();


        simpleListView = (ListView) findViewById(R.id.simpleListview);
        ArrayList<HashMap<String,String>> arrayList=new ArrayList<>();
        for (int i=0;i<animalName.length;i++)
        {
            HashMap<String,String> hashMap=new HashMap<>();//create a hashmap to store the data in key value pair
            hashMap.put("name",animalName[i]);
            hashMap.put("image",animalImages[i]+"");
            arrayList.add(hashMap);//add the hashmap into arrayList
        }
        String[] from={"name","image"};//string array
        int[] to={R.id.lab8text,R.id.lab8image};//int array of views id's
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,arrayList,R.layout.activity_list_view_items,from,to);//Create object and set the parameters for simpleAdapter
        simpleListView.setAdapter(simpleAdapter);//sets the adapter for listView

        //perform listView item click event
        simpleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),animalName[i], Toast.LENGTH_LONG).show();//show the selected image in toast according to position
            }
        });



    }

}