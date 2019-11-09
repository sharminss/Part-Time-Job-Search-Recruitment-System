package com.example.asus_x454l.quickjob;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ASUS_X454L on 9/17/2017.
 */

public class userinformationlist extends ArrayAdapter<UserInformation> {

    private Activity context;


    List<UserInformation> users;

    public userinformationlist(Activity context,  List<UserInformation> users) {
        super(context, R.layout.listout3,users);
        this.context = context;
        this.users = users;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.listout3, null, true);

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textView11);

        TextView textViewName2 = (TextView) listViewItem.findViewById(R.id.textView12);
        TextView textViewName3 = (TextView) listViewItem.findViewById(R.id.textView17);



        UserInformation  u1 = users.get(position);
        textViewName.setText(u1.getName());
        textViewName2.setText(u1.getEmail());
        textViewName3.setText(u1.getPhone_num());


        return listViewItem;

    }
}
