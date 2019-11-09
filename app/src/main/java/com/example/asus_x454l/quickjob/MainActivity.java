package com.example.asus_x454l.quickjob;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private EditText email_add;
    private EditText pass;
    private FirebaseAuth firebaseAuth;
//sensor
    private SensorManager sm;
    private float acelVal;
    private float acelLast;
    private float shake;
    //sensor


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("");
        TextView textView=(TextView) findViewById(R.id.text);
        String t="<font color=#800080>Quick</font><font color=#FF3336>Job.com</font>";
        textView.setText(Html.fromHtml(t));



        email_add=(EditText)findViewById(R.id.email_add);
        pass=(EditText)findViewById(R.id.pass);
        firebaseAuth=FirebaseAuth.getInstance();


//sensor

        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sm.registerListener(sensorListener ,sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) ,SensorManager.SENSOR_DELAY_NORMAL);


        acelVal = SensorManager.GRAVITY_EARTH;
        acelLast = SensorManager.GRAVITY_EARTH;
        shake = 0.00f;

  //sensor



    }



//sensor

    private final SensorEventListener sensorListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {

            float x = sensorEvent.values[0];
            float y = sensorEvent.values[1];

            float z = sensorEvent.values[2];

            acelLast = acelVal;
            acelVal = (float) Math.sqrt((double) (x*x + y*y + z*z));

            float delta = acelVal - acelLast;
            shake = shake * 0.9f + delta;


            if(shake > 6)
            {
                Intent i=new Intent(MainActivity.this,About.class);
                startActivity(i);
                Toast toast = Toast.makeText(getApplicationContext(),"Do not shake Me",Toast.LENGTH_LONG);
                toast.show();
            }



        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };


//sensor


    public void sign_up(View v)
    {
        Intent ii=new Intent(MainActivity.this,reg_activity.class);
        startActivity(ii);
    }



    public void sign_in(View v)
    {
       // String em=email_add.getText().toString();
       // String passw= pass.getText().toString();
        String em=email_add.getText().toString().trim();
        String passw= pass.getText().toString().trim();

        Log.i("em pass",em+"  "+pass);

        final ProgressDialog progressDialog = ProgressDialog.show(MainActivity.this, "please wait....", "processing...", true);
        (firebaseAuth.signInWithEmailAndPassword(em,passw))
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Log in Successful", Toast.LENGTH_LONG).show();
                           // Intent i=new Intent(MainActivity.this,navigation.class);
                          //  startActivity(i);
                        Intent mani2 = new Intent(MainActivity.this,navigation.class);
                        String message =  email_add.getText().toString();
                         mani2.putExtra("nameID1", message);
                        startActivity(mani2);
                        }
                        else {
                            Log.e("ERROR", task.getException().toString());
                            Toast.makeText(MainActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }

                    }
                });

    }
    public void googlef(View view)
    {
        Intent i=new Intent(MainActivity.this,Google_sign_in.class);
        startActivity(i);
    }

    public void about(View view)
    {
        Intent i=new Intent(MainActivity.this,About.class);
        startActivity(i);
    }

}
