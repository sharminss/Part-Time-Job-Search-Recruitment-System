package com.example.asus_x454l.quickjob;

/**
 * Created by ASUS_X454L on 9/30/2017.
 */

public class Rating {
    private String email_add;
    private  String comment;
    private String ratevalue;
    private String foodid;

    public Rating(String email_add, String comment, String ratevalue, String foodid) {
        this.email_add = email_add;
        this.comment = comment;
        this.ratevalue = ratevalue;
        this.foodid = foodid;
    }


    public Rating() {
    }

    public String getEmail_add() {
        return email_add;
    }

    public void setEmail_add(String email_add) {
        this.email_add = email_add;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getRatevalue() {
        return ratevalue;
    }

    public void setRatevalue(String ratevalue) {
        this.ratevalue = ratevalue;
    }

    public String getFoodid() {
        return foodid;
    }

    public void setFoodid(String foodid) {
        this.foodid = foodid;
    }
}
