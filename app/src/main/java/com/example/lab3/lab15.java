package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class lab15 extends AppCompatActivity {
    private ProgressDialog progressDialog;
    private Bitmap bitmap = null;
    Button lab15download;
    ImageView lab15show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab15);
        this.getSupportActionBar().hide();
        lab15download = findViewById(R.id.lab15download);
        lab15show = findViewById(R.id.lab15image);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        lab15download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    downloadImage("http://eit.edu.mn/web_2/resources/images/medee%20jijig/EiT.jpg");
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private void downloadImage(String URl) throws MalformedURLException {
        progressDialog = ProgressDialog.show(this, "", "Татаж байна...");
//        final String url = URl;
        final int[] responseCode = {-1};
        new Thread() {
            public void run() {
                Message msg = Message.obtain();
                msg.what = 1;
                InputStream stream = null;
                BitmapFactory.Options bmOptions = new BitmapFactory.Options();
                bmOptions.inSampleSize = 1;
                try {
                    stream = getHttpConnection(URl);
                    bitmap = BitmapFactory.decodeStream(stream, null, bmOptions);
                    stream.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                    System.out.println("downloadImage" + e1.toString());
                }
                messageHandler.sendMessage(msg);
            }
        }.start();
    }

    private Handler messageHandler = new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            lab15show.setImageBitmap(bitmap);
            progressDialog.dismiss();
        }
    };

    public static InputStream getHttpConnection(String urlString) throws IOException {

        InputStream stream = null;
        URL url = new URL(urlString);
        URLConnection connection = url.openConnection();

        try {
            HttpURLConnection httpConnection = (HttpURLConnection) connection;
            httpConnection.setRequestMethod("GET");
            httpConnection.connect();

            if (httpConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                stream = httpConnection.getInputStream();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("downloadImage" + ex.toString());
        }
        return stream;
    }
}