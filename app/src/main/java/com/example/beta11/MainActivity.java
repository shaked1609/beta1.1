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
 * האקטיביטי יציג בלחיצת כפתור למתרגל הבא להירשם לבית הספר את הסכם תנאי העסקה של בית הספר ויאשר את התנאים באמצעןת לחיצה על הפתוח מתחתיו וחתימה בתוך WebView ולאחר מכן יועבר לאקטיביטי הבא
 */
public class MainActivity extends AppCompatActivity {
    WebView wv;
int x=1;
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
        x++;
    }
    public void signature(View view){
        if (x==2){
        wv.getSettings().setJavaScriptEnabled( true );
        String url="https://signature-maker.net/signature-creator";
        wv.loadUrl( url );
        x++;}
        else{
            Toast.makeText( MainActivity.this, "You haven't read the terms of the deal", Toast.LENGTH_SHORT ).show();
        }
    }
    public void next (View view){
        if(x==3){
        Intent intent = new Intent(MainActivity.this, UploadPictures.class);
        startActivity(intent);
        }
        else  Toast.makeText( MainActivity.this, "You haven't read the terms of the deal/You have not signed in for approval", Toast.LENGTH_LONG ).show();
    }
@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String st = item.getTitle().toString();

        if ((st.equals("agreement")) && (x==3)){
            Intent t=new Intent(this, MainActivity.class);
            startActivity(t);}
        else Toast.makeText( MainActivity.this, "You haven't read the terms of the deal/You have not signed in for approval", Toast.LENGTH_SHORT ).show();
        if (st.equals("Upload") && x==3){
            Intent t=new Intent(this, UploadPictures.class);
            startActivity(t);
        }
        else Toast.makeText( MainActivity.this, "You haven't read the terms of the deal/You have not signed in for approval", Toast.LENGTH_SHORT ).show();

        if (st.equals("Data")){
            Intent t=new Intent(this, Main2Activity.class);
            startActivity(t);
        }
       else Toast.makeText( MainActivity.this, "You haven't read the terms of the deal/You have not signed in for approval", Toast.LENGTH_SHORT ).show();
        if (st.equals("Form101")){
            Intent t=new Intent(this, Main3Activity.class);
            startActivity(t);
        }
        else Toast.makeText( MainActivity.this, "You haven't read the terms of the deal/You have not signed in for approval", Toast.LENGTH_SHORT ).show();
        if (st.equals("E-mail")){
            Intent t=new Intent(this, Main4Activity.class);
            startActivity(t);
        }
        else Toast.makeText( MainActivity.this, "You haven't read the terms of the deal/You have not signed in for approval", Toast.LENGTH_SHORT ).show();

        return super.onOptionsItemSelected(item);
    }
}
