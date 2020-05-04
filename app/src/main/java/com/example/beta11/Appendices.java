package com.example.beta11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.example.beta11.FDrif;
import com.squareup.picasso.Picasso;
/**
 * @author		shaked mhachloof <sm3505@bs.amalnet.k12.il>
 * @version	4.1 (Jelly Bean)
 * @since		20/03/2020
 *This activity will have a green button which will open a dialog and where the practitioner will enter the required details according to the data.
 */


public class Appendices extends AppCompatActivity {
String Email,ID;
    StorageReference mStorageRef;
    public static StorageReference Ref;
    ImageView iV;
    int t=1;
    public Uri imguri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main4 );
iV=(ImageView)findViewById( R.id.imageView2 ) ;
        mStorageRef = FirebaseStorage.getInstance().getReference();
        Button buttonSend = findViewById(R.id.button12);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });
        Button mShowDialog = (Button) findViewById(R.id.btn);
        mShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(Appendices.this);
                View mView = getLayoutInflater().inflate(R.layout.dialog, null);
                 final EditText mEmail = (EditText) mView.findViewById(R.id.etEmail);
                 final EditText mID = (EditText) mView.findViewById(R.id.etID);
                Button mLogin = (Button) mView.findViewById(R.id.btnLogin);
                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();
                mLogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(!mEmail.getText().toString().isEmpty() && !mID.getText().toString().isEmpty()){
                            Email=mEmail.getText().toString();
                            ID=mID.getText().toString();
                            Toast.makeText(Appendices.this, "Data save", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }else{
                            Toast.makeText(Appendices.this, "error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

    /**
     * This will download the form of the form from the cloud
     */
    private void DownloadImg() {// a method that downloads the url of the last added image
        Ref = mStorageRef.child(""+ID).child( ""+ID+"po" );
        Ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>(){
            @Override
            public void onSuccess(Uri uri) {
                Picasso.with(Appendices.this).load(uri).fit().centerCrop().into(iV);
            }


        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), "Failure", Toast.LENGTH_SHORT).show();

            }
        });

    }
    /**
     *This will download the form of the form from the cloud
     */
    private void DownloadImg2() {// a method that downloads the url of the last added image
        Ref = mStorageRef.child(""+ID).child( ""+ID+"tax" );
        Ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>(){
            @Override
            public void onSuccess(Uri uri) {
                Picasso.with(Appendices.this).load(uri).fit().centerCrop().into(iV);
            }


        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), "Failure", Toast.LENGTH_SHORT).show();

            }
        });

    }
    /**
     * This will download the form of the form from the cloud
     */
    private void DownloadImg3() {// a method that downloads the url of the last added image
        Ref = mStorageRef.child(""+ID).child( ""+ID+"sig" );
        Ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>(){
            @Override
            public void onSuccess(Uri uri) {
                Picasso.with(Appendices.this).load(uri).fit().centerCrop().into(iV);
            }


        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), "Failure", Toast.LENGTH_SHORT).show();

            }
        });

    }

    /**
     * This will download the form of the form from the cloud
     */
    private void sendMail() {
        if (t>=4){
        String recipientList =Email;
        String[] recipients = recipientList.split(",");
        String subject = "Income Tax Form and Police and signature of:"+ID;
        String message = "Please attach the photos of the forms and submit";
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Choose an email client"));}
        else Toast.makeText( Appendices.this, "See what photos you need to send", Toast.LENGTH_LONG ).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String st = item.getTitle().toString();

        if (st.equals("agreement")){
            Intent t=new Intent(this, agreement.class);
            startActivity(t);}

        if (st.equals("Upload")){
            Intent t=new Intent(this, UploadPictures.class);
            startActivity(t);
        }

        if (st.equals("Data")){
            Intent t=new Intent(this, PersonalInformation.class);
            startActivity(t);
        }

        if (st.equals("Form101")){
            Intent t=new Intent(this, Form101.class);
            startActivity(t);
        }
        if (st.equals("E-mail")){
            Intent t=new Intent(this, Appendices.class);
            startActivity(t);
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * The action will schedule the action and download the image
     * @param view
     */
    public void sss(View view) {
        DownloadImg();t++;

    }
    /**
     * The action will schedule the action and download the image
     * @param view
     */
    public void bbb(View view) {
        DownloadImg2();t++;
    }
    /**
     *The action will schedule the action and download the image
     * @param view
     */
    public void ccc(View view) {
        DownloadImg3();t++;
    }
}
