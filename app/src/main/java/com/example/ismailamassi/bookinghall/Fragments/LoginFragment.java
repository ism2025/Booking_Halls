package com.example.ismailamassi.bookinghall.Fragments;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ismailamassi.bookinghall.Activites.CustomerMainActivity;
import com.example.ismailamassi.bookinghall.Helper.Constant;
import com.example.ismailamassi.bookinghall.Model.Customer;
import com.example.ismailamassi.bookinghall.Model.Owner;
import com.example.ismailamassi.bookinghall.Model.User;
import com.example.ismailamassi.bookinghall.R;

import com.example.ismailamassi.bookinghall.Helper.SystemControl;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {


    EditText et_username, et_password;
    TextView tv_forgetPassword, tv_createAccount;
    Button btn_login;

    Intent customerIntent;

    public LoginFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        bindView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        onClickItems();
    }

    void bindView(View view) {
        et_username = view.findViewById(R.id.et_username);
        et_password = view.findViewById(R.id.et_password);
        tv_forgetPassword = view.findViewById(R.id.tv_forgetPassword);
        tv_createAccount = view.findViewById(R.id.tv_createAccount);
        btn_login = view.findViewById(R.id.btn_login);
    }

    void onClickItems() {
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = SystemControl.getStringFromEditText(et_username);
                String password = SystemControl.getStringFromEditText(et_password);
                Customer customer = SystemControl.getCustomerByEmail(username);
                Owner owner = SystemControl.getOwnerByEmail(username);
                if (customer != null) {
                    if (customer.getPassword().equals(password)) {
                        customerIntent = new Intent(getActivity(), CustomerMainActivity.class);
                        customerIntent.putExtra("user", customer);
                        startActivityForResult(customerIntent, 2);
                    } else {
                        Toast.makeText(getActivity(), "Password is not match please check Password .", Toast.LENGTH_SHORT).show();
                    }
                } else if (owner != null) {
                    if (owner.getPassword().equals(password)) {
                        customerIntent = new Intent(getActivity(), CustomerMainActivity.class);
                        customerIntent.putExtra("user", owner);
//                        startActivityForResult(customerIntent, 2);
                    } else {
                        Toast.makeText(getActivity(), "Password is not match please check Password .", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getActivity(), "email or username not match please check Username .", Toast.LENGTH_SHORT).show();
                }

            }


        });

        tv_createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(Constant.CONTAINER_ID, Constant.SIGN_UP_FRAGMENT).addToBackStack(Constant.FRAGMENT_LOG).commit();
            }
        });

        tv_forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(Constant.CONTAINER_ID, Constant.FORGET_PASSWORD_FRAGMENT).addToBackStack(Constant.FRAGMENT_LOG).commit();
            }
        });

    }
}
