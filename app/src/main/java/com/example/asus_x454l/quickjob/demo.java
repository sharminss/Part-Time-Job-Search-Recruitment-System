package com.example.asus_x454l.quickjob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class demo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

    }
    public void viewf(View view)
    {
        Intent i=new Intent(demo.this,ADD_JOB2.class);
        startActivity(i);
    }
    public void editf(View view)
    {
        Intent i=new Intent(demo.this,AddToDatabase.class);
        startActivity(i);
    }
}
