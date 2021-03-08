package com.example.lab3;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class lab6n2 extends AppCompatActivity {
    EditText notiTitle, notiBody;
    Button send;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab6n2);
        ActionBar actionBar = getSupportActionBar();
        actionBarCustomize(actionBar);
        send = (Button) findViewById(R.id.send);
        notiTitle = (EditText) findViewById(R.id.notiTitle);
        notiBody = (EditText) findViewById(R.id.notiBody);

        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("mmm","mmm",NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        send.setOnClickListener(v -> sendToNoti(notiTitle.getText().toString(),notiBody.getText().toString()));
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void sendToNoti(String title, String body) {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, "mmm");
        mBuilder.setContentTitle(title);
        mBuilder.setContentText(body);
        mBuilder.setSmallIcon(R.drawable.ic_action_bar_search);
        mBuilder.setAutoCancel(true);
        notiShow(body,mBuilder);
    }
    private void openActivity(String body, NotificationCompat.Builder mBuilder){
        Intent resultIntent = new Intent(this, lab6n2n2.class);
        resultIntent.putExtra("body",body);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(lab6n2n2.class);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_ONE_SHOT);
        mBuilder.setContentIntent(resultPendingIntent);
        //mBuilder.addAction(R.drawable.ic_action_bar_search, body,resultPendingIntent);
    }
    private void notiShow(String body, NotificationCompat.Builder mBuilder){
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        openActivity(body,mBuilder);
        managerCompat.notify(0,mBuilder.build());
    }

    private void actionBarCustomize(ActionBar actionBar){
        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.background)));
        actionBar.setTitle(" Welcome!");
        actionBar.setIcon(R.drawable.ic_action_bar_swim);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
    }
}