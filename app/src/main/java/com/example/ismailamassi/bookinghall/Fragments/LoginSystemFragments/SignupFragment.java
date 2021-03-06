package com.example.ismailamassi.bookinghall.Fragments.LoginSystemFragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ismailamassi.bookinghall.Helper.Constants;
import com.example.ismailamassi.bookinghall.Helper.SystemControl;
import com.example.ismailamassi.bookinghall.Model.Customer;
import com.example.ismailamassi.bookinghall.Model.Owner;
import com.example.ismailamassi.bookinghall.Model.User;
import com.example.ismailamassi.bookinghall.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignupFragment extends Fragment {

    EditText et_fname, et_lname, et_email, et_password, et_confirmPassword, et_phoneNumber;
    RadioGroup rg_accountType;
    TextView tv_haveAccount;
    Button btn_createAccount, btn_imgPicker;

    public SignupFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup, container, false);
        bindView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        onClickItems();
    }

    private void bindView(View view) {
        et_fname = view.findViewById(R.id.et_fname);
        et_lname = view.findViewById(R.id.et_lname);
        et_email = view.findViewById(R.id.et_email);
        et_password = view.findViewById(R.id.et_password);
        et_confirmPassword = view.findViewById(R.id.et_confirmPassword);
        et_phoneNumber = view.findViewById(R.id.et_phoneNumber);

        rg_accountType = view.findViewById(R.id.rg_accountType);

        tv_haveAccount = view.findViewById(R.id.tv_haveAccount);

        btn_createAccount = view.findViewById(R.id.btn_createAccount);
        btn_imgPicker = view.findViewById(R.id.btn_imgPicker);
    }

    private void onClickItems() {
        tv_haveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(Constants.CONTAINER_ID, Constants
                        .LOGIN_FRAGMENT).addToBackStack(Constants.FRAGMENT_LOG).commit();
            }
        });
        btn_createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fname = SystemControl.getStringFromEditText(et_fname);
                String lname = SystemControl.getStringFromEditText(et_lname);
                String email = SystemControl.getStringFromEditText(et_email);
                String password = SystemControl.getStringFromEditText(et_password);
                String confirmPassword = SystemControl.getStringFromEditText(et_confirmPassword);
                String phoneNumber = SystemControl.getStringFromEditText(et_phoneNumber);
                int selectedAccountType = rg_accountType.getCheckedRadioButtonId();
                boolean isFound = false;
                for (User user : SystemControl.allUsers) {
                    if (user.getEmail().equalsIgnoreCase(email)) {
                        et_email.setError("This Email Is Taken Try another");
                        isFound = true;
                    }
                }
                if ((!isFound) && password.equals(confirmPassword) && fname.length() >= 4 && lname.length() >= 4 && email.length() >= 6 && password.length() >= 6 && phoneNumber.length() >= 10) {
                    if (selectedAccountType == R.id.rb_customer) {
                        new Customer(2, fname, lname, email, password, "https://api.androidhive.info/images/glide/large/cacw.jpg", phoneNumber);
                        Toast.makeText(getActivity(), "Create New Account has Successfully .", Toast.LENGTH_SHORT).show();
                        getActivity().getSupportFragmentManager().beginTransaction().replace(Constants.CONTAINER_ID, Constants
                                .LOGIN_FRAGMENT).addToBackStack(Constants.FRAGMENT_LOG).commit();
                    } else if (selectedAccountType == R.id.rb_owner) {
                        new Owner(2, fname, lname, email, password, "https://api.androidhive.info/images/glide/large/bourne.jpg", phoneNumber);
                        Toast.makeText(getActivity(), "Create New Account has Successfully .", Toast.LENGTH_SHORT).show();
                        getActivity().getSupportFragmentManager().beginTransaction().replace(Constants.CONTAINER_ID, Constants
                                .LOGIN_FRAGMENT).addToBackStack(Constants.FRAGMENT_LOG).commit();
                    }
                } else {
                    Toast.makeText(getActivity(), "Must Fill each Failed at minimum 6 digit .", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
