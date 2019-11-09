package com.example.asus_x454l.quickjob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddTrack extends AppCompatActivity{

    TextView TextViewJobName;
    TextView TextViewSalary;
    TextView TextViewTime;
    TextView TextViewExp;
    TextView TextViewEdu;
    TextView TextViewReq;
    TextView tid;

    TextView TextViewCon;
    TextView TextViewAdd;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_track);


        TextViewJobName=(TextView)findViewById(R.id.jobnames);
        TextViewSalary=(TextView)findViewById(R.id.salarys);
        TextViewTime=(TextView)findViewById(R.id.times);
        TextViewExp=(TextView)findViewById(R.id.exps);
        TextViewEdu=(TextView)findViewById(R.id.edus);
        TextViewReq=(TextView)findViewById(R.id.reqs);
        TextViewCon=(TextView)findViewById(R.id.contacts);


        TextViewAdd=(TextView)findViewById(R.id.adds);




        Intent intent=getIntent();
        String idt=intent.getStringExtra(profile.JOB_ID);
        String idt2=intent.getStringExtra(profile.JOB_ID2);
        String namet=intent.getStringExtra(profile.JOB_NAME1);
        String salaryt=intent.getStringExtra(profile.SALARY2);

        String timet=intent.getStringExtra(profile.TIME);

        String expt=intent.getStringExtra(profile.EXP);

        String edut=intent.getStringExtra(profile.EDU);
        String reqt=intent.getStringExtra(profile.REQ);
        String contt=intent.getStringExtra(profile.CON);
        String addt=intent.getStringExtra(profile.ADDR);


        TextViewJobName.setText(namet);
        TextViewSalary.setText(salaryt);
        TextViewTime.setText(timet);
        TextViewExp.setText(expt);
        TextViewEdu.setText(edut);
        TextViewReq.setText(reqt);
        TextViewCon.setText(contt);
        TextViewAdd.setText(addt);


    }

    public void apply_method(View view)
    {
        Intent i =new Intent(AddTrack.this,Apply_job.class);
        startActivity(i);
    }

}
