package com.example.asus_x454l.quickjob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Data_Retrieve_2 extends AppCompatActivity  implements View.OnClickListener {


    private Button Search2;
    private EditText editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data__retrieve_2);


        editText2 = (EditText) findViewById(R.id.editText18);

        Search2= (Button) findViewById(R.id.text_p);

        Search2.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        if (view == Search2){
            String message2 = editText2.getText().toString();
            if (message2.isEmpty()){
                Toast.makeText(this, "Please enter keywords to search for!", Toast.LENGTH_SHORT).show();
                //return;
            }
            else {
                Intent intent = new Intent(Data_Retrieve_2.this, search_test2.class);
                intent.putExtra("message2", message2);
                startActivity(intent);
            }
        }
    }
}
