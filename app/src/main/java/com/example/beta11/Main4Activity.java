package com.example.beta11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;


public class Main4Activity extends AppCompatActivity {
EditText edt,name;
    FirebaseStorage storage;
    StorageReference storageReference;
    ImageView iV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main4 );
        edt=(EditText)findViewById( R.id.edt );
        name=(EditText)findViewById( R.id.fullName );
        iV=(ImageView)findViewById( R.id.imageView2 );
        Button buttonSend = findViewById(R.id.btn);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });
    }

    private void sendMail() {
        String recipientList = edt.getText().toString();
        String[] recipients = recipientList.split(",");

        String subject = "Income Tax Form and Police and signature of:"+name.getText().toString();
        String message = "בבקשה לצרף את התמונות של הטפסים ולשלוח";

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Choose an email client"));
    }


}
