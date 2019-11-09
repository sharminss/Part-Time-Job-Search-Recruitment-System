package com.example.asus_x454l.quickjob;

/**
 * Created by ASUS_X454L on 9/15/2017.
 */

public class UserInformation {

    private   String  id2;
    private String name;
    private String email;
    private String phone_num;

    public UserInformation(){

    }

    public UserInformation(String id2, String email, String name, String phone_num) {

        this.id2 = id2;
        this.email = email;
        this.name = name;
        this.phone_num = phone_num;
    }

    public String getId2() {
        return id2;
    }

    public void setId2(String id2) {
        this.id2 = id2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }
}
