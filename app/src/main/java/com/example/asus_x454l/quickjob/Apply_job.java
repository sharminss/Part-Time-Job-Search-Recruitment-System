package com.example.asus_x454l.quickjob;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Apply_job extends AppCompatActivity {


    EditText namea;
    EditText    salarya;

    EditText    experiencea;
    EditText   educationa;

    EditText contacta;
    EditText addressa;
    Button applyjob;
    DatabaseReference databaseapplyjob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_job);

        getSupportActionBar().setTitle("Application form");


        databaseapplyjob = FirebaseDatabase.getInstance().getReference("Apply");
        namea= (EditText) findViewById(R.id.named);

        salarya = (EditText) findViewById(R.id.sald);


        experiencea = (EditText) findViewById(R.id.expd);

        educationa = (EditText) findViewById(R.id.edud);



        addressa = (EditText) findViewById(R.id.addd);
        contacta= (EditText) findViewById(R.id.contactd);
        applyjob= (Button) findViewById(R.id.applyd);

        applyjob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //calling the method addArtist()
                //the method is defined below
                //this method is actually performing the write operation
                applyjobnew();
            }
        });

    }

    private void applyjobnew()
    {


        String nameapp= namea.getText().toString().trim();
        String salaryapp= salarya.getText().toString().trim();

        String expeapp=experiencea.getText().toString().trim();
        String educapp=educationa.getText().toString().trim();

        String contaapp=contacta.getText().toString().trim();
        String addrapp=addressa.getText().toString().trim();


        if(TextUtils.isEmpty(nameapp))
        {

            Toast.makeText(Apply_job.this,"you should enter jobname    ",Toast.LENGTH_LONG).show();
        }

        else if (TextUtils.isEmpty(salaryapp))
        {

            Toast.makeText(Apply_job.this,"you should enter salary    ",Toast.LENGTH_LONG).show();



        }



        else if (TextUtils.isEmpty(contaapp))
        {

            Toast.makeText(Apply_job.this,"you should enter  contact  ",Toast.LENGTH_LONG).show();



        }


        else if (TextUtils.isEmpty(addrapp))
        {

            Toast.makeText(Apply_job.this,"you should enter  address     ",Toast.LENGTH_LONG).show();



        }


        else
        {

            String ida = databaseapplyjob.push().getKey();

            //creating an Artist Object
            Apply  apply  = new Apply(ida,nameapp,salaryapp,contaapp,addrapp,educapp,expeapp);

            //Saving the Artist
            databaseapplyjob.child(ida).setValue(apply);
            Toast.makeText(this, "job applied successfully", Toast.LENGTH_LONG).show();
        }
    }









}
