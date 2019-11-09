package com.example.asus_x454l.quickjob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AddimgTrack extends AppCompatActivity {



    TextView TextViewJobName;
    TextView TextViewSalary;
    TextView TextViewTime;
    TextView TextViewExp;
    TextView TextViewEdu;
    TextView TextViewReq;

    TextView TextViewCon;
    TextView TextViewAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addimg_track);
        TextViewJobName=(TextView)findViewById(R.id.jobnames);
        TextViewSalary=(TextView)findViewById(R.id.salarys);
        TextViewTime=(TextView)findViewById(R.id.times);
        TextViewExp=(TextView)findViewById(R.id.exps);
        TextViewEdu=(TextView)findViewById(R.id.edus);
        TextViewReq=(TextView)findViewById(R.id.reqs);
        TextViewCon=(TextView)findViewById(R.id.contacts);
        TextViewAdd=(TextView)findViewById(R.id.adds);









        Intent intent=getIntent();


        String idt=intent.getStringExtra(ImageListActivity.JOB_ID);
        String idt2=intent.getStringExtra(ImageListActivity.JOB_ID1);
        //  String idt=intent.getStringExtra(profile.JOB_ID);
        String namet=intent.getStringExtra(ImageListActivity.JOB_NAME1);
        String salaryt=intent.getStringExtra(ImageListActivity.SALARY2);

        String timet=intent.getStringExtra(ImageListActivity.TIME);

        String expt=intent.getStringExtra(ImageListActivity.EXP);

        String edut=intent.getStringExtra(ImageListActivity.EDU);
        String reqt=intent.getStringExtra(ImageListActivity.REQ);
        String contt=intent.getStringExtra(ImageListActivity.CON);
        String addt=intent.getStringExtra(ImageListActivity.ADDR);


        TextViewJobName.setText(namet);
        TextViewSalary.setText(salaryt);
        TextViewTime.setText(timet);
        TextViewExp.setText(expt);
        TextViewEdu.setText(edut);
        TextViewReq.setText(reqt);
        TextViewCon.setText(contt);
        TextViewAdd.setText(addt);

    }
    public void apply_m(View view)
    {
        Intent i=new Intent(AddimgTrack.this,Apply_job.class);
        startActivity(i);
    }
}
