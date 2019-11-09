package com.example.asus_x454l.quickjob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ADD_JOB2 extends AppCompatActivity implements  GoogleApiClient.OnConnectionFailedListener {

    public static final String JOB_NAME = "net.simplifiedcoding.firebasedatabaseexample.id3";
    public static final String JOB_ID = "net.simplifiedcoding.firebasedatabaseexample.name";


    private static final String TAG = "SignInActivity";
    private GoogleApiClient mGoogleApiClient;
    private FirebaseAuth firebaseAuth;
    DatabaseReference databaseuser2;
    ListView listViewusernew;
    List<UserInformation> userListnew;
    List<UserInformation> users;
    private String userID;
    //add Firebase Database stuff
    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__job2);

        databaseuser2 = FirebaseDatabase.getInstance().getReference("users");

      //
        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();
        FirebaseUser user = mAuth.getCurrentUser();
        userID = user.getUid();

        listViewusernew = (ListView) findViewById(R.id.listvie9);

        userListnew = new ArrayList<>();

        users = new ArrayList<>();

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestScopes(new Scope(Scopes.DRIVE_APPFOLDER))
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
        listViewusernew.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                UserInformation ur = users.get(i);
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
                    UserInformation u1 = userSnapshot.getValue(UserInformation.class);
                    Toast.makeText(ADD_JOB2.this,userID.toString()+"  SAMIA\n"+u1.getId2().toString(), Toast.LENGTH_LONG).show();

                    if(userID.toString().equals(u1.getId2().toString())) {

                        userListnew.add(u1);


                    }
                }


         userinformationlist   adapter = new     userinformationlist(ADD_JOB2.this, userListnew);
            listViewusernew.setAdapter(adapter);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

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
                            Intent o = new Intent(ADD_JOB2.this, MainActivity.class);
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

