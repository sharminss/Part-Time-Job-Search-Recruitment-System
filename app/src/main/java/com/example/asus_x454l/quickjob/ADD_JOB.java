package com.example.asus_x454l.quickjob;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ADD_JOB extends AppCompatActivity {

    EditText jobname;
    EditText    salary;
    EditText    time;
    EditText    experience;
    EditText   education;
    EditText    requirement;
    EditText contact;
    EditText address;
    Button addjob;
    DatabaseReference databasejob;
    private String userID;

    //add Firebase Database stuff
    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference myRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__job);
        getSupportActionBar().setTitle("");



        databasejob = FirebaseDatabase.getInstance().getReference("jobs");

        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();
        FirebaseUser user = mAuth.getCurrentUser();
        userID = user.getUid();
        jobname= (EditText) findViewById(R.id.jobnames);

        salary = (EditText) findViewById(R.id.salarys);
        time = (EditText) findViewById(R.id.times);

        experience = (EditText) findViewById(R.id.exps);

        education = (EditText) findViewById(R.id.edus);
        requirement = (EditText) findViewById(R.id.reqs);


        address = (EditText) findViewById(R.id.adds);
        contact= (EditText) findViewById(R.id.contacts);
        addjob= (Button) findViewById(R.id.addjob1);

        addjob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //calling the method addArtist()
                //the method is defined below
                //this method is actually performing the write operation
                addjobnew();
            }
        });

    }




    private void addjobnew()
    {


        String namejob=jobname.getText().toString().trim();
        String salaryjob=salary.getText().toString().trim();
        String tim=time.getText().toString().trim();
        String expe=experience.getText().toString().trim();
        String educ=education.getText().toString().trim();
        String requ=requirement.getText().toString().trim();
        String conta=contact.getText().toString().trim();
        String addr=address.getText().toString().trim();


        if(TextUtils.isEmpty(namejob))
        {

            Toast.makeText(ADD_JOB.this,"you should enter jobname    ",Toast.LENGTH_LONG).show();
        }

        else if (TextUtils.isEmpty(salaryjob))
        {

            Toast.makeText(ADD_JOB.this,"you should enter salary    ",Toast.LENGTH_LONG).show();



        }

        else if (TextUtils.isEmpty(tim))
        {

            Toast.makeText(ADD_JOB.this,"you should enter time    ",Toast.LENGTH_LONG).show();



        }

        else if (TextUtils.isEmpty(conta))
        {

            Toast.makeText(ADD_JOB.this,"you should enter  contact  ",Toast.LENGTH_LONG).show();



        }


        else if (TextUtils.isEmpty(addr))
        {

            Toast.makeText(ADD_JOB.this,"you should enter  address     ",Toast.LENGTH_LONG).show();



        }


        else
        {

            String id1 = databasejob.push().getKey();
            String id22 =   userID.toString();
            Toast.makeText(ADD_JOB.this, id22.toString(), Toast.LENGTH_LONG).show();
            //creating an Artist Object
            Job job  = new Job(id1,id22, namejob,salaryjob,tim,expe,educ,requ,conta,addr);

            //Saving the Artist
            databasejob.child(id1).setValue(job);

            Toast.makeText(this, "job added", Toast.LENGTH_LONG).show();
        }
    }















}
