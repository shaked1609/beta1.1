package com.example.beta11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class Main3Activity extends AppCompatActivity {
WebView we;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main3 );
        we=(WebView)findViewById( R.id.tofes );

    }
    public void open (View view ){
        we.setVisibility( View.VISIBLE );
        we.getSettings().setJavaScriptEnabled( true );
        String url="https://tofes101.co.il/fill-form-101/";
        we.loadUrl( url );

    }
    public void next1(View view){
        Intent intent = new Intent(Main3Activity.this, Main4Activity.class);
        startActivity(intent);
    }
}
