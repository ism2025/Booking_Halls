package com.example.ismailamassi.bookinghall.Activites;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.ismailamassi.bookinghall.Helper.Constant;
import com.example.ismailamassi.bookinghall.Model.Customer;
import com.example.ismailamassi.bookinghall.Model.Hall;
import com.example.ismailamassi.bookinghall.Model.Owner;
import com.example.ismailamassi.bookinghall.R;
import com.example.ismailamassi.bookinghall.Helper.SystemControl;

import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    CountDownTimer count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        Customer customer = new Customer(1, "Ismail", "Amassi", "mail", "123456", "https://api.androidhive.info/images/glide/large/xmen.jpg", "0055995511");
        Owner owner = new Owner(1, "Owner", "Amassi", "owner", "123456", "https://api.androidhive.info/images/glide/large/cacw.jpg", "0592182025");

        Hall hall1 = new Hall(1, "Al Helo AlDoly", "0592182025", "https://api.androidhive.info/images/glide/large/doctor.jpg", "", 2, 1);
        Hall hall2 = new Hall(2, "AlQahera", "0592471020", "https://api.androidhive.info/images/glide/large/cacw.jpg", "", 4.3f, 1);
        Hall hall3 = new Hall(3, "AlHoraya", "0592471020", "https://api.androidhive.info/images/glide/large/deadpool", "", 3, 1);
        Hall hall4 = new Hall(4, "Oriant", "0592182025", "https://api.androidhive.info/images/glide/large/bourne.jpg", "", 1, 1);
        Hall hall5 = new Hall(5, "Princess", "0599141112", "https://api.androidhive.info/images/glide/large/squad.jpg", "", 2.9f, 1);

        Hall hall6 = new Hall(6, "Al Helo AlDoly", "059809997", "https://api.androidhive.info/images/glide/large/doctor.jpg", "", 2, 1);
        Hall hall7 = new Hall(7, "AlQahera", "0549872532", "https://api.androidhive.info/images/glide/large/cacw.jpg", "", 4.3f, 1);
        Hall hall8 = new Hall(8, "AlHoraya", "0554649665", "https://api.androidhive.info/images/glide/large/deadpool", "", 3, 1);
        Hall hall9 = new Hall(9, "Oriant", "0592182025", "https://api.androidhive.info/images/glide/large/bourne.jpg", "", 0, 1);
        Hall hall10 = new Hall(10, "Princess", "0592182688", "https://api.androidhive.info/images/glide/large/squad.jpg", "", 2.9f, 1);

        Hall hall11 = new Hall(11, "Al Helo AlDoly", "0592182521", "https://api.androidhive.info/images/glide/large/doctor.jpg", "", 2, 1);
        Hall hall12 = new Hall(12, "AlQahera", "0546443296", "https://api.androidhive.info/images/glide/large/cacw.jpg", "", 4.3f, 1);
        Hall hall13 = new Hall(13, "AlHoraya", "0599998789", "https://api.androidhive.info/images/glide/large/deadpool", "", 3, 1);
        Hall hall14 = new Hall(14, "Oriant", "0599302622", "https://api.androidhive.info/images/glide/large/bourne.jpg", "", 0, 1);
        Hall hall15 = new Hall(15, "Princess", "05921121215", "https://api.androidhive.info/images/glide/large/squad.jpg", "", 2.9f, 1);

        count = new CountDownTimer(1500, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                SystemControl.startFragment(MainActivity.this, Constant.CONTAINER_ID, Constant.LOGIN_FRAGMENT);
                getSupportActionBar().show();
            }
        }.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}
