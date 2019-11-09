package com.example.asus_x454l.quickjob;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
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

public class profile extends AppCompatActivity {

    public static final String JOB_ID = "net.simplifiedcoding.firebasedatabaseexample.id2";
    public static final String JOB_ID2 = "net.simplifiedcoding.firebasedatabaseexample.id3";

    public static final String JOB_NAME1= "net.simplifiedcoding.firebasedatabaseexample.name2";
    public static final String SALARY2 = "net.simplifiedcoding.firebasedatabaseexample.salary2";
    public static final String TIME = "net.simplifiedcoding.firebasedatabaseexample.time2";
    public static final String EXP= "net.simplifiedcoding.firebasedatabaseexample.experience2";
    public static final String EDU = "net.simplifiedcoding.firebasedatabaseexample.educaton2";
    public static final String REQ = "net.simplifiedcoding.firebasedatabaseexample.requirement2";
    public static final String CON = "net.simplifiedcoding.firebasedatabaseexample.contact2";
    public static final String ADDR= "net.simplifiedcoding.firebasedatabaseexample.address2";

    private FirebaseAuth firebaseAuth;
    DatabaseReference databasejob2;
    ListView listViewjobnew;
    List<Job> jobListnew;
    private DatabaseReference db;
    private DatabaseReference donate_data_event;
    private DatabaseReference donate_info_for_user;
    private FirebaseAuth auth;
    private String userID;

    //add Firebase Database stuff
    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference myRef;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        getSupportActionBar().setTitle("home");
        databasejob2 = FirebaseDatabase.getInstance().getReference("jobs");

        listViewjobnew=(ListView) findViewById(R.id.listview3);

        jobListnew=new ArrayList<>();




        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();
        FirebaseUser user = mAuth.getCurrentUser();
        userID = user.getUid();

       /* listViewjobnew.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //getting the selected artist
                Job job5 = jobListnew.get(i);

                //creating an intent
                Intent intent = new Intent(getApplicationContext(), AddTrack.class);

                //putting artist name and id to intent
                intent.putExtra(JOB_ID,job5.getId());
                intent.putExtra(JOB_ID2, job5.getId3());
                intent.putExtra(JOB_NAME1, job5.getName2());
                intent.putExtra(SALARY2, job5.getSalary2());
                intent.putExtra(TIME,job5.getTime2());
                intent.putExtra(EXP, job5.getExperience2());
                intent.putExtra(EDU, job5.getEducation2());
                intent.putExtra(REQ,job5.getRequirment2());


                intent.putExtra(CON, job5.getContact2());
                intent.putExtra(ADDR,job5.getAddress2());



                //starting the activity with intent
                startActivity(intent);
            }
        });*/



        listViewjobnew.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Job job5 = jobListnew.get(i);

              //  String s=String.valueOf(i);
               // String s = Integer.toString(i);



                db= FirebaseDatabase.getInstance().getReference().child("jobs");
                auth=FirebaseAuth.getInstance();




              // String idd=auth.getCurrentUser().getUid();


               showUpdateDeleteDialog(job5.getId(),job5.getName2());
               Toast.makeText(getApplicationContext(),job5.getId().toString(), Toast.LENGTH_LONG).show();
                //showUpdateDeleteDialog(s,job5.getName2());


                return true;

            }
        });

    }



  private void showUpdateDeleteDialog(final String artistId, String artistName) {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.update_dialog, null);
        dialogBuilder.setView(dialogView);

        final EditText editTextName = (EditText) dialogView.findViewById(R.id.editTextName);
        final EditText editTextName2 = (EditText) dialogView.findViewById(R.id.editTextName2);
        final EditText editTextName3 = (EditText) dialogView.findViewById(R.id.editTextName3);
        final EditText editTextName4 = (EditText) dialogView.findViewById(R.id.editTextName4);
        final EditText editTextName5 = (EditText) dialogView.findViewById(R.id.editTextName5);
        final EditText editTextName6 = (EditText) dialogView.findViewById(R.id.editTextName6);
        final EditText editTextName7 = (EditText) dialogView.findViewById(R.id.editTextName7);
        final EditText editTextName8 = (EditText) dialogView.findViewById(R.id.editTextName8);



        final Button buttonUpdate = (Button) dialogView.findViewById(R.id.buttonUpdateArtist);
        final Button buttonDelete = (Button) dialogView.findViewById(R.id.buttonDeleteArtist);


        final AlertDialog b = dialogBuilder.create();
        b.show();
       buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String named = editTextName.getText().toString().trim();
                String salaryd = editTextName2.getText().toString().trim();
                String timed = editTextName3.getText().toString().trim();
                String experienced = editTextName4.getText().toString().trim();
                String educationd = editTextName5.getText().toString().trim();
                String requirementd = editTextName6.getText().toString().trim();
                String contactd = editTextName7.getText().toString().trim();
                String addressd = editTextName8.getText().toString().trim();


               //updateArtist(artistId, named,salaryd,timed,experienced,educationd,requirementd,contactd,addressd);
               // b.dismiss();

                if (!TextUtils.isEmpty(named)&&!TextUtils.isEmpty(salaryd)&&!TextUtils.isEmpty(timed)&&!TextUtils.isEmpty(experienced)&&!TextUtils.isEmpty(educationd)&&!TextUtils.isEmpty(contactd)&&!TextUtils.isEmpty(requirementd)&&!TextUtils.isEmpty(addressd)) {
                    updateArtist(artistId, named,salaryd,timed,experienced,educationd,requirementd,contactd,addressd);
                    b.dismiss();
                }
            }
        });


        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });

    }


 private boolean updateArtist(String id, String name, String salary,String time,String exp,String edu,String req,String con,String add ) {
        //getting the specified artist reference
        DatabaseReference dR = FirebaseDatabase.getInstance().getReference("jobs").child(id);
       //mim// DatabaseReference dR = FirebaseDatabase.getInstance().getReference("jobs").child(id);

        //updating artist

     String id1 = dR.push().getKey();
     String id22 =   userID.toString();
         Job job5= new Job(id1,id22, name,salary,time,exp,edu,req,con,add);
        dR.setValue(job5);
        Toast.makeText(getApplicationContext(), "job Updated", Toast.LENGTH_LONG).show();
        return true;
    }

    public void job_add(View view)
    {
        Intent i=new Intent(profile.this,ADD_JOB.class);
        startActivity(i);
    }

    protected void onStart() {
        super.onStart();
        databasejob2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                jobListnew.clear();
                for(DataSnapshot jobSnapshot : dataSnapshot.getChildren() ) {
                    Job jobnew = jobSnapshot.getValue(Job.class);

                    jobListnew.add(jobnew);
                }


                Joblist  adapter= new Joblist(profile.this, jobListnew);
                listViewjobnew.setAdapter(adapter);




            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void advenced_search(View view)
    {
        Intent i = new Intent(profile.this,My_added_jobs.class);
        startActivity(i);
    }









}
