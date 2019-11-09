package com.example.asus_x454l.quickjob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class My_added_jobs extends AppCompatActivity {
    public static final String JOB_NAME = "net.simplifiedcoding.firebasedatabaseexample.id3";
    public static final String JOB_ID = "net.simplifiedcoding.firebasedatabaseexample.name";

    private FirebaseAuth firebaseAuth;
    DatabaseReference databaseuser2;
    ListView listViewusernew;
    List<Job> userListnew;
    List<Job> users;
    private String userID;
    //add Firebase Database stuff
    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_added_jobs);


        databaseuser2 = FirebaseDatabase.getInstance().getReference("jobs");

        //
        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();
        FirebaseUser user = mAuth.getCurrentUser();
        userID = user.getUid();

        listViewusernew = (ListView) findViewById(R.id.listview3);

        userListnew = new ArrayList<>();

        users = new ArrayList<>();
        listViewusernew.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
             Job  ur = users.get(i);
                //showUpdateDeleteDialog(ur.getEmail(),ur.getName());
                return true;
            }
        });
    }


    protected void onStart() {
        super.onStart();
        databaseuser2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                userListnew.clear();
                for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                Job u1 = userSnapshot.getValue(Job.class);
                    Toast.makeText(My_added_jobs.this,userID.toString()+"  SAMIA\n"+u1.getId3().toString(), Toast.LENGTH_LONG).show();

                    if(userID.toString().equals(u1.getId3().toString())) {

                        userListnew.add(u1);


                    }
                }


             Joblist    adapter = new      Joblist(My_added_jobs.this, userListnew);
                listViewusernew.setAdapter(adapter);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}


