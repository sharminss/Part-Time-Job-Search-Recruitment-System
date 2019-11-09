package com.example.asus_x454l.quickjob;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class navigation extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener ,GoogleApiClient.OnConnectionFailedListener  {


    NavigationView navigationView = null;
    Toolbar toolbar = null;

    public static final String JOB_ID = "net.simplifiedcoding.firebasedatabaseexample.id2";
    public static final String JOB_ID2 = "net.simplifiedcoding.firebasedatabaseexample.id3";
    public static final String JOB_NAME1 = "net.simplifiedcoding.firebasedatabaseexample.name2";
    public static final String SALARY2 = "net.simplifiedcoding.firebasedatabaseexample.salary2";
    public static final String TIME = "net.simplifiedcoding.firebasedatabaseexample.time2";
    public static final String EXP = "net.simplifiedcoding.firebasedatabaseexample.experience2";
    public static final String EDU = "net.simplifiedcoding.firebasedatabaseexample.educaton2";
    public static final String REQ = "net.simplifiedcoding.firebasedatabaseexample.requirement2";
    public static final String CON = "net.simplifiedcoding.firebasedatabaseexample.contact2";
    public static final String ADDR = "net.simplifiedcoding.firebasedatabaseexample.address2";

    private FirebaseAuth firebaseAuth;
    DatabaseReference databasejob2;
    ListView listViewjobnew;
    List<Job> jobListnew;

    private static final String TAG = "SignInActivity";
    private GoogleApiClient mGoogleApiClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        String t="<font color=#800080>HOME....</font>";
       // textView.setText(Html.fromHtml(t));
        Toolbar toolbar =(Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(Html.fromHtml(t));



//profile activity
        databasejob2 = FirebaseDatabase.getInstance().getReference("jobs");

        listViewjobnew = (ListView) findViewById(R.id.listview3);

        jobListnew = new ArrayList<>();


        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestScopes(new Scope(Scopes.DRIVE_APPFOLDER))
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

       /* listViewjobnew.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //getting the selected artist
                Job job5 = jobListnew.get(i);

                //creating an intent
                Intent intent = new Intent(getApplicationContext(), AddTrack.class);

                //putting artist name and id to intent
                intent.putExtra(JOB_ID, job5.getId());
                intent.putExtra(JOB_ID2, job5.getId3());
                intent.putExtra(JOB_NAME1, job5.getName2());
                intent.putExtra(SALARY2, job5.getSalary2());
                intent.putExtra(TIME, job5.getTime2());
                intent.putExtra(EXP, job5.getExperience2());
                intent.putExtra(EDU, job5.getEducation2());
                intent.putExtra(REQ, job5.getRequirment2());


                intent.putExtra(CON, job5.getContact2());
                intent.putExtra(ADDR, job5.getAddress2());


                //starting the activity with intent
                startActivity(intent);
            }
        });*/



        //profile activity



        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);




        //How to change elements in the header programatically
        View headerView = navigationView.getHeaderView(0);
        TextView  tx2 = (TextView) headerView.findViewById(R.id.profile_email);
        Intent  j = getIntent();
        String val =j.getStringExtra("nameID1");

        tx2.setText(val);


        navigationView.setNavigationItemSelectedListener(this);
    }
    public void job_add(View view) {
        Intent i = new Intent(navigation.this,Strorage.class);
        startActivity(i);
    }

   /* protected void onStart() {
        super.onStart();
        databasejob2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                jobListnew.clear();
                for (DataSnapshot jobSnapshot : dataSnapshot.getChildren()) {
                    Job jobnew = jobSnapshot.getValue(Job.class);

                    jobListnew.add(jobnew);
                }


                Joblist adapter = new Joblist(navigation.this, jobListnew);
                listViewjobnew.setAdapter(adapter);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }*/

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }





    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {

            Intent inr=new Intent(navigation.this,ADD_JOB2.class);
            startActivity(inr);
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {


            Intent inr=new Intent(navigation.this,AddToDatabase.class);
            startActivity(inr);


        } else if (id == R.id.nav_slideshow) {
            Intent inr=new Intent(navigation.this,MyApp.class);
            startActivity(inr);

        } else if (id == R.id.nav_manage) {

            Intent inr=new Intent(navigation.this,MyImageLIstActivity.class);
            startActivity(inr);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    public void advenced_search(View view) {
        Intent i = new Intent(navigation.this,Advanced_search.class);
        startActivity(i);
    }
   public void strorage(View view) {
        Intent i = new Intent(navigation.this,ImageListActivity.class);
        startActivity(i);
    }
    public void searchf(View view) {
        //Intent i = new Intent(Main2Activity.this,Advanced_search.class);
        //startActivity(i);
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.alert_layout, null);
        dialogBuilder.setView(dialogView);

        final Button location1 = (Button) dialogView.findViewById(R.id.location);
        final Button salary1 = (Button) dialogView.findViewById(R.id.salary);

        final Button  name1 = (Button) dialogView.findViewById(R.id.name);

        dialogBuilder.setTitle("choice");
        final AlertDialog b = dialogBuilder.create();
        b.show();


        location1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(navigation.this, Data_Retrieve_2.class);
                startActivity(i);
            }
        });


        salary1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(navigation.this, Data_Retrieve_3.class);
                startActivity(i);
            }
        });


        name1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(navigation.this,Data_Retrieve_1.class);
                startActivity(i);
            }
        });








    }


    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.commonmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.mnulog) {
            Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(
                    new ResultCallback<Status>() {
                        @Override
                        public void onResult(Status status) {
                            // [START_EXCLUDE]
                            //updateUI(false);
                            Intent o = new Intent(navigation.this, MainActivity.class);
                            startActivity(o);
                            // [END_EXCLUDE]
                        }
                    });
        }


        return super.onOptionsItemSelected(item);
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        // An unresolvable error has occurred and Google APIs (including Sign-In) will not
        // be available.
        Log.d(TAG, "onConnectionFailed:" + connectionResult);
    }


}
