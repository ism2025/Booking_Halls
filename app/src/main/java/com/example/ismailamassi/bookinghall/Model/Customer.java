package com.example.ismailamassi.bookinghall.Model;

import com.example.ismailamassi.bookinghall.Helper.SystemControl;

import java.io.Serializable;
import java.util.ArrayList;

import static com.example.ismailamassi.bookinghall.Helper.SystemControl.*;

public class Customer extends User implements Serializable{
    private ArrayList<Book> books;

    public Customer(int id, String fName, String lName, String email, String password, String photo, String phoneNumner) {
        super(id, fName, lName, email, password, photo, phoneNumner);
        books = new ArrayList<>();
        if (SystemControl.allCustomers.size() > 1) {
            this.setId((SystemControl.allCustomers.get(SystemControl.allCustomers.size() - 1).getId()) + 1);
        } else {
            this.setId(1);
        }
        allCustomers.add(this);
        allUsers.add(this);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
}
