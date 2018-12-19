package com.example.ismailamassi.bookinghall.Helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.ismailamassi.bookinghall.Model.Customer;
import com.example.ismailamassi.bookinghall.Model.Owner;
import com.example.ismailamassi.bookinghall.Model.User;

/**
 * Created by Lincoln on 05/05/16.
 */
public class PrefManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    Context mContext;

    // shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name


    public PrefManager(Context context) {
        this.mContext = context;
        pref = mContext.getSharedPreferences(Constants.PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }


    public PrefManager(Context context, int x) {
        this.mContext = context;
        pref = PreferenceManager.getDefaultSharedPreferences(context);
        editor = pref.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(Constants.IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(Constants.IS_FIRST_TIME_LAUNCH, true);
    }

    public void setSignin(boolean isSignin) {
        editor.putBoolean(Constants.IS_SIGN_IN, isSignin);
        editor.commit();//apply();
    }

    public boolean isSignin() {
        return pref.getBoolean(Constants.IS_SIGN_IN, false);
    }

    public void setCurrentUser(User currentUser) {
        if (currentUser != null) {


            editor.putInt(Constants.USER_ID, currentUser.getId());
            if (currentUser instanceof Customer) {
                editor.putInt(Constants.CURRENT_USER_TYPE, Constants.CUSTOMER_ROLE);
            } else if (currentUser instanceof Owner) {
                editor.putInt(Constants.CURRENT_USER_TYPE, Constants.OWNER_ROLE);
            }
            editor.commit();//apply();
        }
    }

    public User getCurrnetUser() {
        int userId = pref.getInt(Constants.USER_ID, 0);
        if (pref.getInt(Constants.CURRENT_USER_TYPE, 0) == Constants.CUSTOMER_ROLE) {
            return SystemControl.getCustomerById(userId);
        } else if (pref.getInt(Constants.CURRENT_USER_TYPE, 0) == Constants.OWNER_ROLE) {
            return SystemControl.getOwnerById(userId);
        } else return null;
    }


}