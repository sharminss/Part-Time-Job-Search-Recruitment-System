package com.example.asus_x454l.quickjob;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class reg_activity extends AppCompatActivity {

    private EditText email_add2;
    private EditText pass2;
    private FirebaseAuth firebaseAuth;
    //mim
//    DatabaseReference db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_activity);
        getSupportActionBar().setTitle("Registration Form");
        email_add2 = (EditText) findViewById(R.id.email_add2);
        pass2 = (EditText) findViewById(R.id.pass2);
        firebaseAuth = FirebaseAuth.getInstance();
        //mim
  //      db= FirebaseDatabase.getInstance().getReference().child("User");
    }

    public void reg_in(View v) {
        final ProgressDialog progressDialog = ProgressDialog.show(reg_activity.this, "please wait....", "processing...", true);
        (firebaseAuth.createUserWithEmailAndPassword(email_add2.getText().toString().trim(), pass2.getText().toString().trim()))
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()) {
                            //mim

                            //mim//  String uid=firebaseAuth.getCurrentUser().getUid();

                           //mim// db.child(uid).child("Name: ").setValue(name);

                            Toast.makeText(reg_activity.this, "Congrats!!!Your Registration Successful ", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(reg_activity.this, MainActivity.class);
                            startActivity(i);
                        } else {
                            Log.e("ERROR", task.getException().toString());
                            Toast.makeText(reg_activity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }



}
