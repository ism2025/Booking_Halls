package com.example.ismailamassi.bookinghall.Model;

import com.example.ismailamassi.bookinghall.Helper.SystemControl;

public class Book {
    private int bookId;
    private String date;
    private Customer customer;
    private Hall hall;

    public Book(int bookId, String date, int customerId, int hallId) {
        this.setBookId(bookId);
        this.setDate(date);
        Customer customer = SystemControl.getCustomerById(customerId);
        customer.getBooks().add(this);
        this.setCustomer(customer);
        Hall hall = SystemControl.getHallById(hallId);
        hall.getBooks().add(this);
        this.setHall(hall);
        SystemControl.allBooks.add(this);
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }
}
