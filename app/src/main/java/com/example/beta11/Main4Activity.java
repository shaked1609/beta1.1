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

import java.io.File;
import java.io.IOException;


public class Main4Activity extends AppCompatActivity {
String Email,ID;
    StorageReference mStorageRef;
    public static StorageReference Ref;
    ImageView iV,iv2,iv3;
    public Uri imguri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main4 );
iV=(ImageView)findViewById( R.id.imageView2 ) ;
iv2=(ImageView)findViewById( R.id.imageView3);
iv3=(ImageView)findViewById( R.id.imageView4 );
        mStorageRef = FirebaseStorage.getInstance().getReference();

        //edt=(EditText)findViewById( R.id.edt );
        //name=(EditText)findViewById( R.id.fullName );
        //iV=(ImageView)findViewById( R.id.imageView2 );
        Button buttonSend = findViewById(R.id.button10);
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
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(Main4Activity.this);
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
                            Toast.makeText(Main4Activity.this, "Data save", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }else{
                            Toast.makeText(Main4Activity.this, "error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }


    private void DownloadImg() {// a method that downloads the url of the last added image
        Ref = mStorageRef.child(""+ID).child( ""+ID+"po" );
        Ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>(){
            @Override
            public void onSuccess(Uri uri) {
                Picasso.with(Main4Activity.this).load(uri).fit().centerCrop().into(iV);
            }


        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), "Failure", Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void DownloadImg2() {// a method that downloads the url of the last added image
        Ref = mStorageRef.child(""+ID).child( ""+ID+"tax" );
        Ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>(){
            @Override
            public void onSuccess(Uri uri) {
                Picasso.with(Main4Activity.this).load(uri).fit().centerCrop().into(iv2);
            }


        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), "Failure", Toast.LENGTH_SHORT).show();

            }
        });

    }
    private void DownloadImg3() {// a method that downloads the url of the last added image
        Ref = mStorageRef.child(""+ID).child( ""+ID+"sig" );
        Ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>(){
            @Override
            public void onSuccess(Uri uri) {
                Picasso.with(Main4Activity.this).load(uri).fit().centerCrop().into(iv3);
            }


        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), "Failure", Toast.LENGTH_SHORT).show();

            }
        });

    }


    private void sendMail() {
        String recipientList =Email;
        String[] recipients = recipientList.split(",");
        String subject = "Income Tax Form and Police and signature of:"+ID;
        String message = "בבקשה לצרף את התמונות של הטפסים ולשלוח";
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Choose an email client"));
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

    public void sss(View view) {
        DownloadImg();

    }

    public void bbb(View view) {
        DownloadImg2();
    }



    public void ccc(View view) {
        DownloadImg3();
    }
}
