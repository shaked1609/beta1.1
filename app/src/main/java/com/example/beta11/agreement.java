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
 * The activity will click the button for the next practitioner to sign up for the school's terms of employment agreement and confirm the terms by clicking on the open below and signing within WebView and then moving to the next activity
 */
public class agreement extends AppCompatActivity {
    WebView wv;
int counter=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        wv=(WebView)findViewById(R.id.Wv);
    }

    /**
     *This will display the WebView Terms of Service Agreement
     *  @param view
     */
    public void show (View view ){
        wv.setVisibility( View.VISIBLE );
        wv.getSettings().setJavaScriptEnabled( true );
        String url="https://drive.google.com/file/d/1-mPGDN9CZVw9FyV17b-NrMvgYP8Yrid-/view?usp=sharing";
        wv.loadUrl( url );
        counter++;
    }

    /**
     *This will display the signature for WebView approval
     *  @param view
     */
    public void signature(View view){
        if (counter==2){
        wv.getSettings().setJavaScriptEnabled( true );
        String url="https://signature-maker.net/signature-creator";
        wv.loadUrl( url );
            counter++;}
        else{
            Toast.makeText( agreement.this, "You haven't read the terms of the deal", Toast.LENGTH_SHORT ).show();
        }
    }

    /**
     *This will take the user to the next screen
     *  @param view
     */
    public void next (View view){
        if(counter==3){
        Intent intent = new Intent(agreement.this, UploadPictures.class);
        startActivity(intent);
        }
        else  Toast.makeText( agreement.this, "You haven't read the terms of the deal/You have not signed in for approval", Toast.LENGTH_LONG ).show();
    }
@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String st = item.getTitle().toString();

        if ((st.equals("agreement")) && (counter==3)){
            Intent t=new Intent(this, agreement.class);
            startActivity(t);}
        else Toast.makeText( agreement.this, "You haven't read the terms of the deal/You have not signed in for approval", Toast.LENGTH_SHORT ).show();
        if (st.equals("Upload") && counter==3){
            Intent t=new Intent(this, UploadPictures.class);
            startActivity(t);
        }
        else Toast.makeText( agreement.this, "You haven't read the terms of the deal/You have not signed in for approval", Toast.LENGTH_SHORT ).show();

        if (st.equals("Data")){
            Intent t=new Intent(this, PersonalInformation.class);
            startActivity(t);
        }
       else Toast.makeText( agreement.this, "You haven't read the terms of the deal/You have not signed in for approval", Toast.LENGTH_SHORT ).show();
        if (st.equals("Form101")){
            Intent t=new Intent(this, Form101.class);
            startActivity(t);
        }
        else Toast.makeText( agreement.this, "You haven't read the terms of the deal/You have not signed in for approval", Toast.LENGTH_SHORT ).show();
        if (st.equals("E-mail")){
            Intent t=new Intent(this, Appendices.class);
            startActivity(t);
        }
        else Toast.makeText( agreement.this, "You haven't read the terms of the deal/You have not signed in for approval", Toast.LENGTH_SHORT ).show();

        return super.onOptionsItemSelected(item);
    }
}
