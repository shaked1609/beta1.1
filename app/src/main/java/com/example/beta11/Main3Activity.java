package com.example.beta11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Toast;

/**
 * @author		shaked mhachloof <sm3505@bs.amalnet.k12.il>
 * @version	4.1 (Jelly Bean)
 * @since		20/03/2020
 *באקטיביטי הזה יוצג טופס 101 מקוון בWebView ובסיום המילוי ישלח למייל הרכז
 */
public class Main3Activity extends AppCompatActivity {
WebView we;
int c=1;
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
c++;
    }
    public void next1(View view){
        if (c>=2){
        Intent intent = new Intent(Main3Activity.this, Main4Activity.class);
        startActivity(intent);}
        else Toast.makeText( Main3Activity.this, "Fill out the form", Toast.LENGTH_LONG ).show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String st = item.getTitle().toString();

        if (st.equals("agreement")&&c>=2){
            Intent t=new Intent(this, MainActivity.class);
            startActivity(t);}

        if (st.equals("Upload")&&c>=2){
            Intent t=new Intent(this, UploadPictures.class);
            startActivity(t);
        }

        if (st.equals("Data")&&c>=2){
            Intent t=new Intent(this, Main2Activity.class);
            startActivity(t);
        }

        if (st.equals("Form101")&&c>=2){
            Intent t=new Intent(this, Main3Activity.class);
            startActivity(t);
        }
        if (st.equals("E-mail")&&c>=2){
            Intent t=new Intent(this, Main4Activity.class);
            startActivity(t);
        }

        return super.onOptionsItemSelected(item);
    }
}
