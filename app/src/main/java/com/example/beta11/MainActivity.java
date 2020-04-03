package com.example.beta11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;


public class MainActivity extends AppCompatActivity {
    WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        wv=(WebView)findViewById(R.id.Wv);
    }
    public void show (View view ){
        wv.getSettings().setJavaScriptEnabled( true );
        String url="https://drive.google.com/file/d/1-mPGDN9CZVw9FyV17b-NrMvgYP8Yrid-/view?usp=sharing";
        wv.loadUrl( url );

    }
    public void next (View view){
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(intent);
    }
}
