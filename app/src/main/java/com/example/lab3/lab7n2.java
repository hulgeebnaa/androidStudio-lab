package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class lab7n2 extends AppCompatActivity {
    WebView webView;
    Button webviewbtn,htmlviewbtn;
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab7n2);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        webView = (WebView) findViewById(R.id.webview);
        webView.setBackgroundColor(R.color.background);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webviewbtn = (Button) findViewById(R.id.webviewbtn);
        htmlviewbtn = (Button) findViewById(R.id.htmlviewbtn);
        webviewbtn.setOnClickListener(v -> webview());
        htmlviewbtn.setOnClickListener(v -> htmlviewbtn());
    }
    private void htmlviewbtn() {
    String myurl = "file:///android_asset/index.html";
    webView.setWebViewClient(new WebViewClient());
    webView.loadUrl(myurl);
    }

    private void webview(){
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://erdenetis.edu.mn/");
    }
    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
            return;
        }
        super.onBackPressed();
    }
}