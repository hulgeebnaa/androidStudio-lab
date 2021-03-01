package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class animal extends AppCompatActivity {
    CheckBox ehleh;
    TextView amitan;
    RadioGroup radiogp;
    ImageView amitanView;
    ConstraintLayout amitanLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        amitanLayout = (ConstraintLayout) findViewById(R.id.amitanlayout);
        ehleh = (CheckBox) findViewById(R.id.checkBox);
        amitan = (TextView) findViewById(R.id.amitan);
        radiogp = (RadioGroup) findViewById(R.id.radioGroup);
        amitanView = (ImageView) findViewById(R.id.amitanView);


        radiogp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.amitan1){
                    amitanView.setImageResource(R.drawable.dog);
                }
                else if(checkedId == R.id.amitan2){
                    amitanView.setImageResource(R.drawable.cat);
                }
                else{
                    amitanView.setImageResource(R.drawable.rabbit);
                }

            }
        });
        ehleh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                    amitanLayout.setVisibility(View.VISIBLE);
                }
                else{
                    amitanLayout.setVisibility(View.INVISIBLE);
                }

            }
        });
    }
}
