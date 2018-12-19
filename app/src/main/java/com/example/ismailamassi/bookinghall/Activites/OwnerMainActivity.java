package com.example.ismailamassi.bookinghall.Activites;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ismailamassi.bookinghall.Helper.Constant;
import com.example.ismailamassi.bookinghall.R;

public class OwnerMainActivity extends AppCompatActivity {


//
//    //Store In SharedPreferences
//    SharedPreferences sharedPreferences = getSharedPreferences("name", MODE_PRIVATE);
//    SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putInt("tt", 5645);
//        editor.putString("ttt", "");
//        editor.commit(); // (Same) editor.apply();
//
//    //get From SharedPreferences
//    getSharedPreferences("name" ,MODE_PRIVATE).getInt("tt",0);
//    getSharedPreferences("name" ,MODE_PRIVATE).getString("tt","defalut value");


    DrawerLayout drawerLayout;
    NavigationView navigationView;
    FloatingActionButton fab;
    View navHeader;
    ImageView iv_userPhoto;
    TextView tv_username, tv_accountType;

    private static final String TAG_HOMEPAGE = "homePage";
    private static final String TAG_PROFILE = "profile";
    private static final String TAG_SETTINGS = "settings";
    private static final String TAG_HALLS = "halls";
    private static final String TAG_ABOUT = "about";
    private static final String TAG_PRIVACY_POLICY = "privacy policy";
    public static String CURRENT_TAG = TAG_HOMEPAGE;


    public static int navItemIndex = 0;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_main);

        bindViews();
        mHandler = new Handler();
        setUpNavigationView();
        if (savedInstanceState == null) {
            navItemIndex = 0;
            CURRENT_TAG = TAG_HOMEPAGE;
            loadHomeFragment();
        }
    }

    private void bindViews() {
        navigationView = findViewById(R.id.navigationView);
        drawerLayout = findViewById(R.id.drawerLayout);
        fab = findViewById(R.id.fab);
        navHeader = navigationView.getHeaderView(0);
        iv_userPhoto = navHeader.findViewById(R.id.iv_userPhoto);
        tv_username = navHeader.findViewById(R.id.tv_username);
        tv_accountType = navHeader.findViewById(R.id.tv_accountType);
    }

    private void loadHomeFragment() {
        // selecting appropriate nav menu item
        selectNavMenu();


        if (getSupportFragmentManager().findFragmentByTag(CURRENT_TAG) != null) {
            drawerLayout.closeDrawers();
        }
        Runnable mPendingRunnable = new Runnable() {
            @Override
            public void run() {
                // update the main content by replacing fragments
                Fragment fragment = getHomeFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                        android.R.anim.fade_out);
                fragmentTransaction.replace(Constant.OWNER_CONTENT_ID, fragment, CURRENT_TAG);
                fragmentTransaction.commitAllowingStateLoss();
            }
        };

        // If mPendingRunnable is not null, then add to the message queue
        if (mPendingRunnable != null) {
            mHandler.post(mPendingRunnable);
        }


        navigationView.getMenu().getItem(3).setActionView(R.layout.menu_dot);

        //Closing drawer on item click
        drawerLayout.closeDrawers();

        // refresh toolbar menu
//        getActivity().invalidateOptionsMenu();

        if (navItemIndex == 0) {
            fab.setVisibility(View.VISIBLE);
        } else
            fab.setVisibility(View.GONE);
    }

    private void selectNavMenu() {
        navigationView.getMenu().getItem(navItemIndex).setChecked(true);
    }

    private void setUpNavigationView() {
        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()) {
                    //Replacing the main content with ContentFragment Which is our Inbox View;
                    case R.id.homepage:
                        navItemIndex = 0;
                        CURRENT_TAG = TAG_HOMEPAGE;
                        break;
                    case R.id.profile:
                        navItemIndex = 1;
                        CURRENT_TAG = TAG_PROFILE;
                        break;
                    case R.id.setting:
                        navItemIndex = 2;
                        CURRENT_TAG = TAG_SETTINGS;
                        break;
                    case R.id.halls:
                        navItemIndex = 3;
                        CURRENT_TAG = TAG_HALLS;
                        break;
                    case R.id.about:
                        navItemIndex = 4;
                        CURRENT_TAG = TAG_ABOUT;
                        break;
                    case R.id.privacyPolicy:
                        navItemIndex = 5;
                        CURRENT_TAG = TAG_PRIVACY_POLICY;
                        break;
                    case R.id.signOut:
                        startActivity(new Intent(OwnerMainActivity.this, MainActivity.class));
                        finish();
                        break;
                    case R.id.shere:
                        Intent sendIntent = new Intent();
                        sendIntent.setAction(Intent.ACTION_SEND);
                        sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
                        sendIntent.setType("text/plain");
                        Intent.createChooser(sendIntent, "Ismail Amassi");
                        startActivityForResult(sendIntent, 2);
                    default:
                        navItemIndex = 0;
                }

                //Checking if the item is in checked state or not, if not make it in checked state
                if (menuItem.isChecked()) {
                    menuItem.setChecked(false);
                } else {
                    menuItem.setChecked(true);
                }
                menuItem.setChecked(true);

                loadHomeFragment();

                return true;
            }
        });

    }

    private Fragment getHomeFragment() {
        switch (navItemIndex) {
            case 0:
                // home
                return Constant.OWNER_HOMEPAGE_FRAGMENT;
            case 1:
                // profile
                return Constant.CUSTMOR_PROFILE_FRAGMENT;
            case 2:
                //settings
                return Constant.CUSTMOR_SETTINGS_FRAGMENT;
            case 3:
                // books
                return Constant.OWNER_HOMEPAGE_FRAGMENT;
//              return Constant.OWNER_HALLS_FRAGMENT;
            case 4:
                // about
                return Constant.ABOUT_FRAGMENT;
            case 5:
                // privacy policy
                return Constant.PRIVACY_POLICY_FRAGMENT;
            default:
                return Constant.CUSTMOR_HOMEPAGE_FRAGMENT;
        }
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawers();
            return;
        }
        if (navItemIndex != 0) {
            navItemIndex = 0;
            CURRENT_TAG = TAG_HOMEPAGE;
            loadHomeFragment();
            return;
        }
        super.onBackPressed();
    }


}
