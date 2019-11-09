package com.example.asus_x454l.quickjob;

/**
 * Created by ASUS_X454L on 8/20/2017.
 */

public class Apply {

    private   String  idj;
    private   String  namej;
    private    String  salaryj;
    private   String  addj;
    private   String  expj;
    private String  educationj;

    private  String  contactj;

    public   Apply()
    {


    }

    public Apply(String idj, String namej, String salaryj, String addj, String expj, String educationj, String contactj) {
        this.idj = idj;
        this.namej = namej;
        this.salaryj = salaryj;
        this.addj = addj;
        this.expj = expj;
        this.educationj = educationj;
        this.contactj = contactj;
    }

    public String getIdj() {
        return idj;
    }

    public String getNamej() {
        return namej;
    }

    public String getSalaryj() {
        return salaryj;
    }

    public String getAddj() {
        return addj;
    }

    public String getExpj() {
        return expj;
    }

    public String getEducationj() {
        return educationj;
    }

    public void setNamej(String namej) {
        this.namej = namej;
    }

    public String getContactj() {
        return contactj;
    }

    public void setIdj(String idj) {
        this.idj = idj;
    }
}
