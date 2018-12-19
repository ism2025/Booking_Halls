package com.example.ismailamassi.bookinghall.Model;

import com.example.ismailamassi.bookinghall.Helper.SystemControl;

import java.io.Serializable;
import java.util.ArrayList;

public class Owner extends User implements Serializable {
    private ArrayList<Hall> halls;

    public ArrayList<Hall> getHalls() {
        return halls;
    }

    public void setHalls(ArrayList<Hall> halls) {
        this.halls = halls;
    }

    public Owner(int id, String fName, String lName, String email, String password, String photo, String phoneNumber) {
        super(id, fName, lName, email, password, photo, phoneNumber);
        if (SystemControl.allOwners.size() > 1) {
            this.setId((SystemControl.allOwners.get(SystemControl.allOwners.size() - 1).getId()) + 1);
        } else {
            this.setId(1);
        }
        halls = new ArrayList<>();

        SystemControl.allOwners.add(this);
        SystemControl.allUsers.add(this);
    }

}
