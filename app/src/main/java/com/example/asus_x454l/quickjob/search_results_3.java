package com.example.asus_x454l.quickjob;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class search_results_3 extends AppCompatActivity {
    DatabaseReference mDatabaseRef;


    List<Job> jobListnew;

    ListView listViewjobnew;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results_3);

        mDatabaseRef = FirebaseDatabase.getInstance().getReference("jobs");

        jobListnew = new ArrayList<>();

        listViewjobnew = (ListView) findViewById(R.id.listnewr4);

        // TextView tx2 = (TextView)findViewById(R.id.message);
        Intent j = getIntent();
        final String val =j.getStringExtra("message3");

        //tx2.setText(val);




        final ProgressDialog progressDialog = ProgressDialog.show(search_results_3.this, "please wait....", "processing...", true);
        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                progressDialog.dismiss();

                //Fetch image data from firebase database
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    //ImageUpload class require default constructor
                    Job img = snapshot.getValue(Job.class);
                    if(img.getSalary2().toLowerCase().contains(val.toLowerCase())) {
                        jobListnew.add(img);
                    }
                }


                Joblist2 adapter = new Joblist2(search_results_3.this, jobListnew);
                listViewjobnew.setAdapter(adapter);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
