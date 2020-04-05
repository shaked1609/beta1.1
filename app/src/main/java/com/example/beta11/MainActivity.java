package com.example.beta11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
        wv.setVisibility( View.VISIBLE );
        wv.getSettings().setJavaScriptEnabled( true );
        String url="https://drive.google.com/file/d/1-mPGDN9CZVw9FyV17b-NrMvgYP8Yrid-/view?usp=sharing";
        wv.loadUrl( url );
        //https://signature-maker.net/signature-creator
    }
    public void signature(View view){
        wv.getSettings().setJavaScriptEnabled( true );
        String url="https://signature-maker.net/signature-creator";
        wv.loadUrl( url );


    }
    public void next (View view){
        Intent intent = new Intent(MainActivity.this, UploadPictures.class);
        startActivity(intent);
    }
@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String st = item.getTitle().toString();

        if (st.equals("agreement")){
            Intent t=new Intent(this, MainActivity.class);
            startActivity(t);}

        if (st.equals("Upload")){
            Intent t=new Intent(this, UploadPictures.class);
            startActivity(t);
        }

        if (st.equals("Data")){
            Intent t=new Intent(this, Main2Activity.class);
            startActivity(t);
        }

        if (st.equals("Form101")){
            Intent t=new Intent(this, Main3Activity.class);
            startActivity(t);
        }
        if (st.equals("E-mail")){
            Intent t=new Intent(this, Main4Activity.class);
            startActivity(t);
        }

        return super.onOptionsItemSelected(item);
    }
}
