package com.example.ismailamassi.bookinghall.Helper;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ismailamassi.bookinghall.Helper.Constant;
import com.example.ismailamassi.bookinghall.Model.Book;
import com.example.ismailamassi.bookinghall.Model.Customer;
import com.example.ismailamassi.bookinghall.Model.Hall;
import com.example.ismailamassi.bookinghall.Model.Owner;
import com.example.ismailamassi.bookinghall.Model.User;

import java.util.ArrayList;

public class SystemControl {

    public static ArrayList<User> allUsers = new ArrayList<>();
    public static ArrayList<Customer> allCustomers = new ArrayList<>();
    public static ArrayList<Owner> allOwners = new ArrayList<>();
    public static ArrayList<Hall> allHalls = new ArrayList<>();
    public static ArrayList<Book> allBooks = new ArrayList<>();

    public static Hall getHallById(int hallId) {
        Hall tmp = null;
        for (Hall hall : allHalls) {
            if (hall.getId() == hallId) {
                tmp = hall;
            }
        }
        return tmp;
    }

    public static User getUserById(int userId) {
        User tmp = null;
        for (User user : allUsers) {
            if (user.getId() == userId) {
                tmp = user;
            }
        }
        return tmp;
    }

    public static Customer getCustomerById(int custmoerId) {
        Customer tmp = null;
        for (Customer customer : allCustomers) {
            if (customer.getId() == custmoerId) {
                tmp = customer;
            }
        }
        return tmp;
    }

    public static Owner getOwnerById(int ownerId) {
        Owner tmp = null;
        for (Owner owner : allOwners) {
            if (owner.getId() == ownerId) {
                tmp = owner;
            }
        }
        return tmp;
    }

    public static void startFragment(AppCompatActivity activity, int containerId, Fragment fragment) {
        activity.getSupportFragmentManager().beginTransaction().replace(containerId, fragment).addToBackStack(Constant.FRAGMENT_LOG).commit();
    }

    public static String getStringFromEditText(EditText editText) {
        return editText.getText().toString();
    }

    public static String getStringFromTextView(TextView textView) {
        return textView.getText().toString();
    }

    public static User getUserByEmail(String email) {
        User tmp = null;
        for (User user : allUsers) {
            if (user.getEmail().equals(email)) {
                tmp = user;
                break;
            }
        }
        return tmp;
    }

    public static Customer getCustomerByEmail(String email) {
        Customer tmp = null;
        for (Customer customer : allCustomers) {
            if (customer.getEmail().equals(email)) {
                tmp = customer;
                break;
            }
        }
        return tmp;
    }

    public static Owner getOwnerByEmail(String email) {
        Owner tmp = null;
        for (Owner owner : allOwners) {
            if (owner.getEmail().equals(email)) {
                tmp = owner;
                break;
            }
        }
        return tmp;
    }

}
