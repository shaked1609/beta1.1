package com.example.beta11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
EditText et16;
EditText a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15;
EditText b1,b2,b3,b4,b5;
Button b17;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main2 );
        a1=(EditText)findViewById( R.id.a1 );a2=(EditText)findViewById( R.id.a2 );a3=(EditText)findViewById( R.id.a3 );a4=(EditText)findViewById( R.id.a4 );a5=(EditText)findViewById( R.id.a5 );
        a6=(EditText)findViewById( R.id.a6 );a7=(EditText)findViewById( R.id.a7 );a8=(EditText)findViewById( R.id.a8 );a9=(EditText)findViewById( R.id.a9 );a10=(EditText)findViewById( R.id.a10 );
        a11=(EditText)findViewById( R.id.a11 );a12=(EditText)findViewById( R.id.a12 );a13=(EditText)findViewById( R.id.a13 );a14=(EditText)findViewById( R.id.a14 );a15=(EditText)findViewById( R.id.a15 );
        b1=(EditText)findViewById( R.id.b1 );b2=(EditText)findViewById( R.id.b2 );b3=(EditText)findViewById( R.id.b3 );b4=(EditText)findViewById( R.id.b4 );b5=(EditText)findViewById( R.id.b5 );
        et16=(EditText)findViewById( R.id.a16 );
        b17=(Button)findViewById( R.id.a17 );
        b17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });
    }
    private void sendMail() {
        String recipientList = et16.getText().toString();
        String[] recipients = recipientList.split(",");

        String subject = "first name: "+a1.getText().toString()+", last name: "+a2.getText().toString()+", I.D: "+a3.getText().toString();
        String message = "Personal Information"+".                                                   "+
                "Date of birth: "+a4.getText().toString()+",   Marital Status: "+a5.getText().toString()+",  E-Mail: "+a6.getText().toString()+
        ",  city: "+a7.getText().toString()+",  street:"+a8.getText().toString()+", house number: "+a9.getText().toString()+
                ",  Postal Code: "+a10.getText().toString()+",  phone number: "+a11.getText().toString()+",  mobile phone number: "+a12.getText().toString()+
                ",  gender: "+a13.getText().toString()+",  The name of the school where you are employed, if any else Type no: "+a14.getText().toString()+",  Are you a qualified teacher for teaching: "+a15.getText().toString()+"" +
                ".                                                                            " +
                "Bank Information                                                 " +
                "" + "the bank's name: "+b1.getText().toString()+",  branch name: "+b2.getText().toString()+",  branch number:"+b3.getText().toString()
        +",  Address of the branch: "+b4.getText().toString()+",  Account Number: "+b2.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Choose an email client"));
    }
    public void sd(View view){
        Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
        startActivity(intent);
    }
}
