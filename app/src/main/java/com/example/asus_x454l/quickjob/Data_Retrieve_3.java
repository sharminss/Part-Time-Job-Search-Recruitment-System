package com.example.asus_x454l.quickjob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Data_Retrieve_3 extends AppCompatActivity implements View.OnClickListener {
    private Button Search;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data__retrieve_3);


        editText = (EditText) findViewById(R.id.editText28);

        Search = (Button) findViewById(R.id.text_q);

        Search.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {

        if (view == Search){
            String message = editText.getText().toString();
            if (message.isEmpty()){
                Toast.makeText(this, "Please enter keywords to search for!", Toast.LENGTH_SHORT).show();
                //return;
            }
            else {
                Intent intent = new Intent(Data_Retrieve_3.this, search_test3.class);
                intent.putExtra("message3", message);
                startActivity(intent);
            }
        }
    }

}
