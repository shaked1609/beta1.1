package com.example.beta11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
