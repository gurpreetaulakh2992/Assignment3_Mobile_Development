package com.example.sqliteapplication;

public class ListData {

    private String Name,contact,dob;
    public ListData(String Name, String contact,String dob) {
        this.contact=contact;
        this.Name=Name;
        this.dob=dob;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}
