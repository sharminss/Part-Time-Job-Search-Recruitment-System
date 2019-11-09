package com.example.asus_x454l.quickjob;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ASUS_X454L on 9/18/2017.
 */

public class Joblist2  extends ArrayAdapter<Job> {

    private Activity context;


    List<Job> jobs;

    public Joblist2(Activity context,  List<Job>jobs) {
        super(context, R.layout.model3, jobs);
        this.context = context;
        this.jobs = jobs;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.model3, null, true);

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.model_m2);


        Job job5 = jobs.get(position);
        textViewName.setText(job5.getName2());

        return listViewItem;

    }
}
