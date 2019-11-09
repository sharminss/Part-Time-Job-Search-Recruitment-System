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

public class viewprofile2 extends AppCompatActivity {


    public static final String JOB_ID = "net.simplifiedcoding.firebasedatabaseexample.id2";

    public static final String JOB_NAME1 = "net.simplifiedcoding.firebasedatabaseexample.name2";
    public static final String SALARY2 = "net.simplifiedcoding.firebasedatabaseexample.salary2";
    public static final String TIME = "net.simplifiedcoding.firebasedatabaseexample.time2";
    public static final String EXP = "net.simplifiedcoding.firebasedatabaseexample.experience2";
    public static final String EDU = "net.simplifiedcoding.firebasedatabaseexample.educaton2";
    public static final String REQ = "net.simplifiedcoding.firebasedatabaseexample.requirement2";
    public static final String CON = "net.simplifiedcoding.firebasedatabaseexample.contact2";
    public static final String ADDR = "net.simplifiedcoding.firebasedatabaseexample.address2";

    EditText naj;
    EditText ej;
    EditText    pj;
    Button adduser;
    DatabaseReference databaseuser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewprofile2);
        databaseuser = FirebaseDatabase.getInstance().getReference("users");
        naj= (EditText) findViewById(R.id.editText);

        ej = (EditText) findViewById(R.id.editText2);
        pj = (EditText) findViewById(R.id.editText5);

        adduser= (Button) findViewById(R.id.button10);
        adduser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //calling the method addArtist()
                //the method is defined below
                //this method is actually performing the write operation
                addusernew();
            }
        });


    }


    private void addusernew()
    {


        String namejob=naj.getText().toString().trim();
        String salaryjob=ej.getText().toString().trim();
        String tim=pj.getText().toString().trim();



        if(!TextUtils.isEmpty(namejob))
        {


            String id1 = databaseuser.push().getKey();

            //creating an Artist Object
            UserInformation u   = new UserInformation(id1,namejob,salaryjob,tim);

            //Saving the Artist
            databaseuser.child(id1).setValue(u);
            Toast.makeText(this, "user added", Toast.LENGTH_LONG).show();
        }
    }















}

