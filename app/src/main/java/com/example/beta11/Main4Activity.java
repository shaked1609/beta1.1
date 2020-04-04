package com.example.beta11;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Main4Activity extends AppCompatActivity {
EditText edt,name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main4 );
        edt=(EditText)findViewById( R.id.edt );
        name=(EditText)findViewById( R.id.fullName );
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
