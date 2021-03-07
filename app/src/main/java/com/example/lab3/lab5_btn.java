package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Button;

public class lab5_btn extends AppCompatActivity {
    Button web, sms, call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab5_btn);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        web = (Button) findViewById(R.id.web);
        sms = (Button) findViewById(R.id.sms);
        call = (Button) findViewById(R.id.call);

        web.setOnClickListener(v -> webclick());
        sms.setOnClickListener(v -> smsclick());
        call.setOnClickListener(v -> callclick());
    }
    private void webclick(){
        goToUrl ( "http://erdenetis.edu.mn/");
    }

    private void goToUrl(String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

    private void smsclick(){
        String smsNumber = "99999999";
        String smsText = "Implicit intent ашиглан activity-аас өөр програм руу шилжих боломжтой.";
        Uri uri = Uri.parse("smsto:" + smsNumber);
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        intent.putExtra("sms_body", smsText);
        startActivity(intent);
    }
    private void callclick(){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:99999999"));
        startActivity(intent);
    }

}