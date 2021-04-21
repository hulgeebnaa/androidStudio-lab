package com.example.lab3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.Toast;

public class lab12n1 extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    Intent intent ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab12n1);
        this.getSupportActionBar().hide();
        mediaPlayer = MediaPlayer.create(this,R.raw.homesick);
        intent = new Intent(this,MusicService.class);
        Button playservice = (Button) findViewById(R.id.playservice);
        Button stopservice = (Button) findViewById(R.id.stopservice);
        playservice.setOnClickListener(v -> playserviceonclick());
        stopservice.setOnClickListener(v -> stopserviceonclick());
    }

    private void playserviceonclick() {
        startService(intent);
        mediaPlayer.start();
        Toast.makeText(this, "Service started",Toast.LENGTH_LONG).show();
    }

    private void stopserviceonclick() {
        stopService(intent);
        mediaPlayer.stop();
        Toast.makeText(this, "Service stopped",Toast.LENGTH_LONG).show();
    }

    public class MusicService extends Service{
        @Nullable
        @Override
        public IBinder onBind(Intent intent) {
            return null;
        }
    }
}