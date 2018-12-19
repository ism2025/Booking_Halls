package com.example.ismailamassi.bookinghall.Activites;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ismailamassi.bookinghall.Helper.Constants;
import com.example.ismailamassi.bookinghall.Helper.PrefManager;
import com.example.ismailamassi.bookinghall.Model.Customer;
import com.example.ismailamassi.bookinghall.Model.Hall;
import com.example.ismailamassi.bookinghall.Model.Owner;
import com.example.ismailamassi.bookinghall.Model.User;
import com.example.ismailamassi.bookinghall.R;
import com.example.ismailamassi.bookinghall.Helper.SystemControl;

public class MainActivity extends AppCompatActivity {

    CountDownTimer count;
    PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        prefManager = new PrefManager(MainActivity.this);
        Customer customer1 = new Customer(1, "cust1", "Amassi", "cust1", "123456", "https://api.androidhive.info/images/glide/large/xmen.jpg", "0055995511");
        Customer customer2 = new Customer(2, "cust2", "Amassi", "cust2", "123456", "https://api.androidhive.info/images/glide/large/xmen.jpg", "0055995511");
        Customer customer3 = new Customer(3, "cust3", "Amassi", "cust3", "123456", "https://api.androidhive.info/images/glide/large/xmen.jpg", "0055995511");
        Customer customer4 = new Customer(4, "cust4", "Amassi", "cust4", "123456", "https://api.androidhive.info/images/glide/large/xmen.jpg", "0055995511");
        Customer customer5 = new Customer(5, "cust5", "Amassi", "cust5", "123456", "https://api.androidhive.info/images/glide/large/xmen.jpg", "0055995511");

        Owner owner1 = new Owner(11, "Owner1", "Amassi", "owner1", "123456", "https://api.androidhive.info/images/glide/large/cacw.jpg", "0592182025");
        Owner owner2 = new Owner(22, "Owner2", "Amassi", "owner2", "123456", "https://api.androidhive.info/images/glide/large/cacw.jpg", "0592182025");
        Owner owner3 = new Owner(33, "Owner3", "Amassi", "owner3", "123456", "https://api.androidhive.info/images/glide/large/cacw.jpg", "0592182025");
        Owner owner4 = new Owner(44, "Owner4", "Amassi", "owner4", "123456", "https://api.androidhive.info/images/glide/large/cacw.jpg", "0592182025");
        Owner owner5 = new Owner(55, "Owner5", "Amassi", "owner5", "123456", "https://api.androidhive.info/images/glide/large/cacw.jpg", "0592182025");

        Hall hall1 = new Hall(1, "Hall Number 1", "0592182025", "https://i.ibb.co/Kbn8Rr6/images-3.jpg", "", 2, 500, owner1.getId());
        Hall hall2 = new Hall(2, "Hall Number 2", "0592471020", "https://i.ibb.co/nMRtxny/17.jpg", "", 4.3f, 300, owner5.getId());
        Hall hall3 = new Hall(3, "Hall Number 3", "0592471020", "https://i.ibb.co/3rNsNkM/image.jpg", "", 3, 700, owner5.getId());
        Hall hall4 = new Hall(4, "Hall Number 4", "0592182025", "https://www.hiamag.com/sites/default/files/styles/ph2_960_600/public/article/04/05/2017/5362576-1307337527.jpg", "", 1, 1000, owner2.getId());
        Hall hall5 = new Hall(5, "Hall Number 5", "0599141112", "https://www.hiamag.com/sites/default/files/styles/ph2_960_600/public/article/04/05/2017/5362581-808536815.jpg", "", 2.9f, 900, owner3.getId());

        Hall hall6 = new Hall(6, "Hall Number 6", "059809997", "https://api.androidhive.info/images/glide/large/doctor.jpg", "", 2, 650, owner5.getId());
        Hall hall7 = new Hall(7, "Hall Number 7", "0549872532", "https://api.androidhive.info/images/glide/large/cacw.jpg", "", 4.3f, 450, owner3.getId());
        Hall hall8 = new Hall(8, "Hall Number 8", "0554649665", "https://api.androidhive.info/images/glide/large/deadpool", "", 3, 290, owner5.getId());
        Hall hall9 = new Hall(9, "Hall Number 9", "0592182025", "https://api.androidhive.info/images/glide/large/bourne.jpg", "", 0, 1600, owner2.getId());
        Hall hall10 = new Hall(10, "Hall Number 10", "0592182688", "https://api.androidhive.info/images/glide/large/squad.jpg", "", 2.9f, 3000, owner1.getId());

        Hall hall11 = new Hall(11, "Hall Number 11", "0592182521", "https://www.hiamag.com/sites/default/files/styles/ph2_960_600/public/article/04/05/2017/5362556-1367634382.jpg", "", 2, 890, owner2.getId());
        Hall hall12 = new Hall(12, "Hall Number 12", "0546443296", "https://www.hiamag.com/sites/default/files/styles/ph2_960_600/public/article/04/05/2017/5362551-315125083.jpg", "", 4.3f, 340, owner4.getId());
        Hall hall13 = new Hall(13, "Hall Number 13", "0599998789", "https://www.hiamag.com/sites/default/files/styles/ph2_960_600/public/article/04/05/2017/5362566-163410885.jpg", "", 3, 500, owner2.getId());
        Hall hall14 = new Hall(14, "Hall Number 14", "0599302622", "https://www.hiamag.com/sites/default/files/styles/ph2_960_600/public/article/04/05/2017/5362626-945630472.jpg", "", 0, 790, owner4.getId());
        Hall hall15 = new Hall(15, "Hall Number 15", "05921121215", "https://www.hiamag.com/sites/default/files/styles/ph2_960_600/public/article/04/05/2017/5362616-438583405.jpg", "", 2.9f, 690, owner5.getId());

        count = new CountDownTimer(1500, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                if (prefManager.isSignin()) {
                    User user = prefManager.getCurrnetUser();
                    if (user != null) {
                        SystemControl.launchMainActivity(MainActivity.this, getSupportFragmentManager(), user);
                        finish();
                    }
                } else {
                    getSupportFragmentManager().beginTransaction().replace(Constants.CONTAINER_ID, Constants.LOGIN_FRAGMENT).addToBackStack(Constants.FRAGMENT_LOG).commit();
                }
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
