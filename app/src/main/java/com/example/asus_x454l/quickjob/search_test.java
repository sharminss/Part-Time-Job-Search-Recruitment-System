package com.example.asus_x454l.quickjob;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class search_test extends AppCompatActivity {


    private DatabaseReference mDatabaseRef;
    private List<ImageUpload> imgList;
    private ListView lv;
    private ImageListAdapter adapter;
    private ProgressDialog progressDialog;
    private String userID;
    //add Firebase Database stuff
    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference myRef;


    public static final String JOB_ID = "net.simplifiedcoding.firebasedatabaseexample.id";
    public static final String JOB_ID1 = "net.simplifiedcoding.firebasedatabaseexample.id2";

    public static final String JOB_NAME1 = "net.simplifiedcoding.firebasedatabaseexample.name";
    public static final String URL = "net.simplifiedcoding.firebasedatabaseexample.url";
    public static final String SALARY2 = "net.simplifiedcoding.firebasedatabaseexample.salary2";
    public static final String TIME = "net.simplifiedcoding.firebasedatabaseexample.time2";
    public static final String EXP = "net.simplifiedcoding.firebasedatabaseexample.experience2";
    public static final String EDU = "net.simplifiedcoding.firebasedatabaseexample.educaton2";
    public static final String REQ = "net.simplifiedcoding.firebasedatabaseexample.requirement2";
    public static final String CON = "net.simplifiedcoding.firebasedatabaseexample.contact2";
    public static final String ADDR = "net.simplifiedcoding.firebasedatabaseexample.address2";

    private FirebaseAuth firebaseAuth;
    DatabaseReference databasejob2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_test);
        imgList = new ArrayList<>();
        lv = (ListView) findViewById(R.id.listViewImage);
        //Show progress dialog during list image loading
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait loading list image...");
        progressDialog.show();

        databasejob2 = FirebaseDatabase.getInstance().getReference("stjobs");


        Intent j = getIntent();
        final String val =j.getStringExtra("message");


        //  listViewjobnew = (ListView) findViewById(R.id.listview3);

        //  jobListnew = new ArrayList<>();

        mDatabaseRef = FirebaseDatabase.getInstance().getReference(Strorage.FB_Database_Path);
        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();
        FirebaseUser user = mAuth.getCurrentUser();
        userID = user.getUid();



        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //getting the selected artist
                ImageUpload im5 = imgList.get(i);

                //creating an intent
                Intent intent = new Intent(getApplicationContext(), AddimgTrack.class);

                //putting artist name and id to intent
                intent.putExtra(JOB_ID, im5.getId());
                intent.putExtra(JOB_ID1, im5.getId2());

                intent.putExtra(JOB_NAME1,im5.getName());
                intent.putExtra(URL,im5.getUrl());
                intent.putExtra(SALARY2, im5.getSalary2());
                intent.putExtra(TIME,im5.getTime2());
                intent.putExtra(EXP, im5.getExperience2());
                intent.putExtra(EDU,im5.getEducation2());
                intent.putExtra(REQ, im5.getRequirment2());


                intent.putExtra(CON, im5.getContact2());
                intent.putExtra(ADDR,im5.getAddress2());


                //starting the activity with intent
                startActivity(intent);
            }
        });


        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                progressDialog.dismiss();

                //Fetch image data from firebase database
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    //ImageUpload class require default constructor
                    ImageUpload img = snapshot.getValue(ImageUpload.class);

                    if(img.getName().toLowerCase().contains(val.toLowerCase())) {

                        imgList.add(img);

                    }
                }


                //Init adapter
                adapter = new ImageListAdapter(search_test.this, R.layout.image_item, imgList);
                //Set adapter for listview
                lv.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                progressDialog.dismiss();
            }
        });

    }
}
