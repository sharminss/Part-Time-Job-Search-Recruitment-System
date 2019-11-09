package com.example.asus_x454l.quickjob;

/**
 * Created by ASUS_X454L on 9/22/2017.
 */

public class ImageUpload {

    public String name;
    public  String  id;
    public  String   id2;
    public String url;
    private    String  salary2;
    private   String  time2;
    private   String  experience2;
    private String  education2;
    private String  requirment2;
    private  String  contact2;
    private   String  address2;



    public String getId() {
        return id;
    }

    public String getId2() {
        return id2;
    }

    public String getAddress2() {
        return address2;
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

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public ImageUpload(String name, String id, String id2, String url, String salary2, String time2, String experience2, String education2, String requirment2, String contact2, String address2) {
        this.name = name;
        this.id = id;
        this.id2 = id2;
        this.url = url;
        this.salary2 = salary2;
        this.time2 = time2;
        this.experience2 = experience2;
        this.education2 = education2;
        this.requirment2 = requirment2;
        this.contact2 = contact2;
        this.address2 = address2;
    }

    public ImageUpload(){




    }

}
