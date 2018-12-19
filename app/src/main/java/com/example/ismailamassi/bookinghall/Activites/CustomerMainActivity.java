package com.example.ismailamassi.bookinghall.Activites;

import android.content.Intent;
import android.os.Handler;
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

import com.example.ismailamassi.bookinghall.Helper.Constants;
import com.example.ismailamassi.bookinghall.Helper.PrefManager;
import com.example.ismailamassi.bookinghall.Model.Customer;
import com.example.ismailamassi.bookinghall.R;

public class CustomerMainActivity extends AppCompatActivity {


    DrawerLayout drawerLayout;
    NavigationView navigationView;
    View navHeader;
    ImageView iv_userPhoto;
    TextView tv_username, tv_accountType;

    PrefManager prefManager;

    private static final String TAG_HOMEPAGE = "homePage";
    private static final String TAG_PROFILE = "profile";
    private static final String TAG_SETTINGS = "settings";
    private static final String TAG_BOOKS = "books";
    private static final String TAG_ABOUT = "about";
    private static final String TAG_PRIVACY_POLICY = "privacy policy";
    public static String CURRENT_TAG = TAG_HOMEPAGE;


    public static int navItemIndex = 0;
    private Handler mHandler;
//    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_main);
        prefManager = new PrefManager(CustomerMainActivity.this);
        bindViews();
        mHandler = new Handler();
        setUpNavigationView();


//        toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        if (savedInstanceState == null) {
            navItemIndex = 0;
            CURRENT_TAG = TAG_HOMEPAGE;
            loadHomeFragment();
        }

        //        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name) {
//
//            @Override
//            public void onDrawerClosed(View drawerView) {
//                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
//                super.onDrawerClosed(drawerView);
//            }
//
//            @Override
//            public void onDrawerOpened(View drawerView) {
//                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
//                super.onDrawerOpened(drawerView);
//            }
//        };
//        drawerLayout.setDrawerListener(actionBarDrawerToggle);
//        actionBarDrawerToggle.syncState();

    }

    private void bindViews() {
        navigationView = findViewById(R.id.navigationView);
        drawerLayout = findViewById(R.id.drawerLayout);
        navHeader = navigationView.getHeaderView(0);
        iv_userPhoto = navHeader.findViewById(R.id.iv_userPhoto);
        tv_username = navHeader.findViewById(R.id.tv_username);
        tv_accountType = navHeader.findViewById(R.id.tv_accountType);
    }

    private void loadHomeFragment() {
        // selecting appropriate nav menu item
        selectNavMenu();

        // set toolbar title
        // toolbar.setTitle(navigationView.getMenu().getItem(navItemIndex).getTitle());
        // if user select the current navigation menu again, don't do anything
        // just close the navigation drawer
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
                fragmentTransaction.replace(Constants.CUSTOMER_CONTENT_ID, fragment, CURRENT_TAG);
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
                    case R.id.books:
                        navItemIndex = 3;
                        CURRENT_TAG = TAG_BOOKS;
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
                        prefManager.setSignin(false);
                        startActivity(new Intent(CustomerMainActivity.this, MainActivity.class));
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
                return Constants.CUSTMOR_HOMEPAGE_FRAGMENT;
            case 1:
                // profile
                return Constants.CUSTMOR_PROFILE_FRAGMENT;
            case 2:
                //settings
                return Constants.CUSTMOR_SETTINGS_FRAGMENT;
            case 3:
                // books
                return Constants.CUSTMOR_BOOKS_FRAGMENT;
            case 4:
                // about
                return Constants.ABOUT_FRAGMENT;
            case 5:
                // privacy policy
                return Constants.PRIVACY_POLICY_FRAGMENT;
            default:
                return Constants.CUSTMOR_HOMEPAGE_FRAGMENT;
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
