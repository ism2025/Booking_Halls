package com.example.ismailamassi.bookinghall.Helper;

import com.example.ismailamassi.bookinghall.Fragments.CommonFragments.AboutFragment;
import com.example.ismailamassi.bookinghall.Fragments.CommonFragments.HallPageFragment;
import com.example.ismailamassi.bookinghall.Fragments.CommonFragments.PrivacyPolicyFragment;
import com.example.ismailamassi.bookinghall.Fragments.CustomerFragments.CustomerBooksFragment;
import com.example.ismailamassi.bookinghall.Fragments.CustomerFragments.CustomerHomepageFragment;
import com.example.ismailamassi.bookinghall.Fragments.CustomerFragments.CustomerProfileFragment;
import com.example.ismailamassi.bookinghall.Fragments.CustomerFragments.CustomerSettingsFragment;
import com.example.ismailamassi.bookinghall.Fragments.ForgetPasswordFragment;
import com.example.ismailamassi.bookinghall.Fragments.LoginFragment;
import com.example.ismailamassi.bookinghall.Fragments.ResetPasswordFragment;
import com.example.ismailamassi.bookinghall.Fragments.SignupFragment;
import com.example.ismailamassi.bookinghall.R;

//
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
public class Constant {
    public static final String FRAGMENT_LOG = "fragment_log";
    public static final String USER_FORGET_PASSWORD = "userForgetPassword";
    public static final int CONTAINER_ID = R.id.containerView;
    public static final int CONTENT_ID = R.id.contentLayout;

    //SignIn & Up Fragments
    public static final LoginFragment LOGIN_FRAGMENT = new LoginFragment();
    public static final SignupFragment SIGN_UP_FRAGMENT = new SignupFragment();
    public static final ForgetPasswordFragment FORGET_PASSWORD_FRAGMENT = new ForgetPasswordFragment();
    public static final ResetPasswordFragment RESET_PASSWORD_FRAGMENT = new ResetPasswordFragment();
    //Customer Fragments
    public static final CustomerHomepageFragment CUSTMOR_HOMEPAGE_FRAGMENT = new CustomerHomepageFragment();
    public static final CustomerProfileFragment CUSTMOR_PROFILE_FRAGMENT = new CustomerProfileFragment();
    public static final CustomerSettingsFragment CUSTMOR_SETTINGS_FRAGMENT = new CustomerSettingsFragment();
    public static final CustomerBooksFragment CUSTMOR_BOOKS_FRAGMENT = new CustomerBooksFragment();
    //Owner Fragments

    //Common Fragments
    public static final AboutFragment ABOUT_FRAGMENT = new AboutFragment();
    public static final PrivacyPolicyFragment PRIVACY_POLICY_FRAGMENT = new PrivacyPolicyFragment();
    public static final HallPageFragment HALL_PAGE_FRAGMENT= new HallPageFragment();


}
