package com.example.beta11;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.UUID;
/**
 * @author		shaked mhachloof <sm3505@bs.amalnet.k12.il>
 * @version	4.1 (Jelly Bean)
 * @since		20/03/2020
 *The activity will cost Pierre Bayes the police form required by the practitioner to bring the tax and signature coordination form from the first activity which means approval of the terms of the transaction
 */

public class UploadPictures extends AppCompatActivity {
    Button sig, pol, tax;
    ImageView im1;
    EditText ID;
    Uri filePath;
    FirebaseStorage storage;
    StorageReference storageReference;
    int y=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_upload_pictures );
        storage = FirebaseStorage.getInstance();
        ID=(EditText)findViewById( R.id.ID );
        im1 = (ImageView) findViewById( R.id.imageView );
        storageReference = storage.getReference();
        sig = (Button) findViewById( R.id.signature );
        sig.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseImage();
            }
        } );
        tax = (Button) findViewById( R.id.TaxCoordination );
        tax.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseImage();
            }
        } );
        pol = (Button) findViewById( R.id.PoliceForm );
        pol.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseImage();

            }
        } );
    }

    /**
     *This will open the user to the gallery to select a photo
     */
    private void chooseImage() {
        if (ID.getText().length()==9) {
            Intent intent = new Intent();
            intent.setType( "image/*" );
            intent.setAction( Intent.ACTION_GET_CONTENT );
            startActivityForResult( Intent.createChooser( intent, "Select Image" ), 1 );
        }
        else {
            Toast.makeText( UploadPictures.this, "Incorrect ID", Toast.LENGTH_SHORT ).show();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult( requestCode, resultCode, data );
        if (requestCode == 1 && requestCode != RESULT_OK && data != null && data.getData() != null) {
            filePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap( getContentResolver(), filePath );
                im1.setImageBitmap( bitmap );
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    /**
     *Upload the photo he chose from Pierre Bayes Gallery
     *  @param view
     */
    public void im1(View view) {
        if (ID.getText().length()==9) {
            ID.setVisibility( view.GONE );
            if (filePath != null) {
                final ProgressDialog progressDialog = new ProgressDialog( this );
                progressDialog.setTitle( "Uploading...." );
                progressDialog.show();
                StorageReference reference = storageReference.child( ID.getText().toString() + "/" +ID.getText().toString()+"po"  );
                reference.putFile( filePath ).addOnSuccessListener( new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        progressDialog.dismiss();
                        y++;
                        Toast.makeText( UploadPictures.this, "image uploaded", Toast.LENGTH_SHORT ).show();
                    }
                } )
                        .addOnProgressListener( new OnProgressListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onProgress(@NonNull UploadTask.TaskSnapshot taskSnapshot) {
                                double progres = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                                progressDialog.setMessage( "Uploaded" + (int) progres + " %" );
                            }
                        } );
            }
        }
        else {
            Toast.makeText( UploadPictures.this, "Incorrect ID", Toast.LENGTH_SHORT ).show();
        }
    }
    /**
     *Upload the photo he chose from Pierre Bayes Gallery
     *  @param view
     */
    public void im2(View view) {
        if (ID.getText().length()==9) {
            if (filePath != null) {
                final ProgressDialog progressDialog = new ProgressDialog( this );
                progressDialog.setTitle( "Uploading...." );
                progressDialog.show();
                StorageReference reference = storageReference.child(  ID.getText().toString() + "/" +ID.getText().toString()+"tax" );
                reference.putFile( filePath ).addOnSuccessListener( new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        progressDialog.dismiss();
                        y++;
                        Toast.makeText( UploadPictures.this, "image uploaded", Toast.LENGTH_SHORT ).show();
                    }
                } )
                        .addOnProgressListener( new OnProgressListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onProgress(@NonNull UploadTask.TaskSnapshot taskSnapshot) {
                                double progres = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                                progressDialog.setMessage( "Uploaded" + (int) progres + "%" );
                            }
                        } );
            }
        }
        else {
            Toast.makeText( UploadPictures.this, "Incorrect ID", Toast.LENGTH_SHORT ).show();
        }

    }
    /**
     *Upload the photo he chose from Pierre Bayes Gallery
     *  @param view
     */
    public void im3(View view) {
        if (ID.getText().length()==9) {
            if (filePath != null) {
                final ProgressDialog progressDialog = new ProgressDialog( this );
                progressDialog.setTitle( "Uploading...." );
                progressDialog.show();
                StorageReference reference = storageReference.child( ID.getText().toString() + "/" +ID.getText().toString()+"sig" );
                reference.putFile( filePath ).addOnSuccessListener( new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        progressDialog.dismiss();
                        y++;
                        Toast.makeText( UploadPictures.this, "image uploaded", Toast.LENGTH_SHORT ).show();
                    }
                } )
                        .addOnProgressListener( new OnProgressListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onProgress(@NonNull UploadTask.TaskSnapshot taskSnapshot) {
                                double progres = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                                progressDialog.setMessage( "Uploaded" + (int) progres + "%" );
                            }
                        } );
            }
        }
        else {
            Toast.makeText( UploadPictures.this, "Incorrect ID", Toast.LENGTH_SHORT ).show();
        }
    }
    /**
     *This will take the user to the next screen
     *  @param view
     */
    public void next2(View view) {
       if (y==4){
        Intent intent = new Intent( UploadPictures.this, PersonalInformation.class );
        startActivity( intent );}
       else  Toast.makeText( UploadPictures.this, "You did not upload any of the files please complete the missing", Toast.LENGTH_SHORT ).show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String st = item.getTitle().toString();

        if (st.equals("agreement")&&y==4){
            Intent t=new Intent(this, agreement.class);
            startActivity(t);}
        else  Toast.makeText( UploadPictures.this, "You did not upload any of the files please complete the missing", Toast.LENGTH_SHORT ).show();
        if (st.equals("Upload")&&y==4){
            Intent t=new Intent(this, UploadPictures.class);
            startActivity(t);
        }
        else  Toast.makeText( UploadPictures.this, "You did not upload any of the files please complete the missing", Toast.LENGTH_SHORT ).show();
        if (st.equals("Data")&&y==4){
            Intent t=new Intent(this, PersonalInformation.class);
            startActivity(t);
        }
        else  Toast.makeText( UploadPictures.this, "You did not upload any of the files please complete the missing", Toast.LENGTH_SHORT ).show();
        if (st.equals("Form101")&&y==4){
            Intent t=new Intent(this, Form101.class);
            startActivity(t);
        }
        else  Toast.makeText( UploadPictures.this, "You did not upload any of the files please complete the missing", Toast.LENGTH_SHORT ).show();
        if (st.equals("E-mail")&&y==4){
            Intent t=new Intent(this, Appendices.class);
            startActivity(t);
        }
        else  Toast.makeText( UploadPictures.this, "You did not upload any of the files please complete the missing", Toast.LENGTH_SHORT ).show();
        return super.onOptionsItemSelected(item);
    }

}