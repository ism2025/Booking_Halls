package com.example.ismailamassi.bookinghall.Model;

import com.example.ismailamassi.bookinghall.Helper.SystemControl;

import java.io.Serializable;

public abstract class User implements Serializable {
    private int id;
    private String fName;
    private String lName;
    private String email;
    private String password;
    private String photo;
    private String phoneNumber;


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public User(int id, String fName, String lName, String email, String password, String photo, String phoneNumber) {
        this.id = id;
        this.phoneNumber = phoneNumber;

        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.password = password;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getFullName() {
        return getfName() + " " + getlName();
    }
}
