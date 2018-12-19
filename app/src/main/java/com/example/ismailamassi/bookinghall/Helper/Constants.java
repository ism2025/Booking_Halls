package com.example.ismailamassi.bookinghall.Helper;

import com.example.ismailamassi.bookinghall.Fragments.CommonFragments.AboutFragment;
import com.example.ismailamassi.bookinghall.Fragments.CommonFragments.HallPageFragment;
import com.example.ismailamassi.bookinghall.Fragments.CommonFragments.PrivacyPolicyFragment;
import com.example.ismailamassi.bookinghall.Fragments.CustomerFragments.CustomerBooksFragment;
import com.example.ismailamassi.bookinghall.Fragments.CustomerFragments.CustomerHomepageFragment;
import com.example.ismailamassi.bookinghall.Fragments.CommonFragments.ProfileFragment;
import com.example.ismailamassi.bookinghall.Fragments.CommonFragments.SettingsFragment;
import com.example.ismailamassi.bookinghall.Fragments.LoginSystemFragments.ForgetPasswordFragment;
import com.example.ismailamassi.bookinghall.Fragments.LoginSystemFragments.LoginFragment;
import com.example.ismailamassi.bookinghall.Fragments.LoginSystemFragments.ResetPasswordFragment;
import com.example.ismailamassi.bookinghall.Fragments.LoginSystemFragments.SignupFragment;
import com.example.ismailamassi.bookinghall.Fragments.OwnerFragments.OwnerHallBooksFragment;
import com.example.ismailamassi.bookinghall.Fragments.OwnerFragments.OwnerHallsFragment;
import com.example.ismailamassi.bookinghall.Fragments.OwnerFragments.OwnerHomepageFragment;
import com.example.ismailamassi.bookinghall.Fragments.OwnerFragments.OwnerNewHallFragment;
import com.example.ismailamassi.bookinghall.R;

//
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
public class Constants {
    public static final String PREF_NAME = "introSP";
    public static final String FRAGMENT_LOG = "fragment_log";
    public static final String USER_FORGET_PASSWORD = "userForgetPassword";
    public static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";
    public static final String IS_SIGN_IN = "IsSignIn";
    public static final String CURRENT_USER_TYPE = "currentUser";
    public static final String USER_ID = "";
    public static final int CUSTOMER_ROLE = 1;
    public static final int OWNER_ROLE = 2;

    //Containers
    public static final int CONTAINER_ID = R.id.containerView;
    public static final int CUSTOMER_CONTENT_ID = R.id.contentLayoutForCustemor;
    public static final int OWNER_CONTENT_ID = R.id.contentLayoutForOwner;

    //SignIn & Up Fragments
    public static final LoginFragment LOGIN_FRAGMENT = new LoginFragment();
    public static final SignupFragment SIGN_UP_FRAGMENT = new SignupFragment();
    public static final ForgetPasswordFragment FORGET_PASSWORD_FRAGMENT = new ForgetPasswordFragment();
    public static final ResetPasswordFragment RESET_PASSWORD_FRAGMENT = new ResetPasswordFragment();

    //Customer Fragments
    public static final CustomerHomepageFragment CUSTMOR_HOMEPAGE_FRAGMENT = new CustomerHomepageFragment();
    public static final CustomerBooksFragment CUSTMOR_BOOKS_FRAGMENT = new CustomerBooksFragment();

    //Owner Fragments
    public static final OwnerHomepageFragment OWNER_HOMEPAGE_FRAGMENT = new OwnerHomepageFragment();
    public static final OwnerHallsFragment OWNER_HALLS_FRAGMENT = new OwnerHallsFragment();
    public static final OwnerHallBooksFragment OWNER_HALL_BOOKS_FRAGMENT = new OwnerHallBooksFragment();
    public static final OwnerNewHallFragment OWNER_NEW_HALL_FRAGMENT = new OwnerNewHallFragment();

    //Common Fragments
    public static final AboutFragment ABOUT_FRAGMENT = new AboutFragment();
    public static final PrivacyPolicyFragment PRIVACY_POLICY_FRAGMENT = new PrivacyPolicyFragment();
    public static final HallPageFragment HALL_PAGE_FRAGMENT = new HallPageFragment();
    public static final SettingsFragment CUSTMOR_SETTINGS_FRAGMENT = new SettingsFragment();
    public static final ProfileFragment CUSTMOR_PROFILE_FRAGMENT = new ProfileFragment();


}
