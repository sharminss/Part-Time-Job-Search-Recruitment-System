package com.example.asus_x454l.quickjob;

/**
 * Created by ASUS_X454L on 8/19/2017.
 */

public class Job {


    private   String  id3;
    private   String  id2;
    private   String  name2;
    private    String  salary2;
    private   String  time2;
    private   String  experience2;
    private String  education2;
    private String  requirment2;
    private  String  contact2;

    private   String  address2;
    public   Job()
    {


    }

    public Job( String id2,String  id3, String name2, String salary2, String time2, String experience2, String education2, String requirment2, String contact2, String address2) {
        this.id2 = id2;
        this.id3 = id3;
        this.name2 = name2;
        this.salary2 = salary2;
        this.time2 = time2;
        this.experience2 = experience2;
        this.education2 = education2;
        this.requirment2 = requirment2;
        this.contact2 = contact2;
        this.address2 = address2;
    }

    public String getId3() {
        return id3;
    }

    public void setId3(String id3) {
        this.id3 = id3;
    }

    public String getId() {
        return id2;
    }

    public String getName2() {
        return name2;
    }

    public String getSalary2() {
        return salary2;
    }

    public String getTime2() {
        return time2;
    }

    public String getExperience2() {
        return experience2;
    }

    public String getEducation2() {
        return education2;
    }

    public String getRequirment2() {
        return requirment2;
    }

    public String getContact2() {
        return contact2;
    }

    public String getAddress2() {
        return address2;
    }

    public void setId2(String id2) {
        this.id2 = id2;
    }
}
