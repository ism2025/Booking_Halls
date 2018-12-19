package com.example.ismailamassi.bookinghall.Model;

import com.example.ismailamassi.bookinghall.Helper.SystemControl;

import java.io.Serializable;
import java.util.ArrayList;

public class Hall implements Serializable {
    private int id;
    private Owner owner;
    private String name;
    private String location;
    private float rate;
    private String phoneNumber;
    private String photo;
    private int price;
    private ArrayList<Book> books;


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Hall(int id, String name, String phoneNumber, String photo, String location, float rate, int price, int ownerId) {
        if (SystemControl.allHalls.size() > 1) {
            this.setId((SystemControl.allHalls.get(SystemControl.allHalls.size() - 1).getId()) + 1);
        } else {
            this.setId(1);
        }
        this.owner = SystemControl.getOwnerById(ownerId);
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.rate = rate;
        this.price = price;
        this.photo = photo;
        this.location = location;
        books = new ArrayList<>();
        owner.getHalls().add(this);
        SystemControl.allHalls.add(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
}
