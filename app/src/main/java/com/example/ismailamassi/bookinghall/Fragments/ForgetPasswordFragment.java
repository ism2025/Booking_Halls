package com.example.ismailamassi.bookinghall.Fragments;


import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ismailamassi.bookinghall.Helper.Constant;
import com.example.ismailamassi.bookinghall.Helper.SystemControl;
import com.example.ismailamassi.bookinghall.Model.User;
import com.example.ismailamassi.bookinghall.R;

import java.util.Locale;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class ForgetPasswordFragment extends Fragment {

    EditText et_email;
    Button btn_sendCode;

    Bundle bundle = new Bundle();

    public ForgetPasswordFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forget_password, container, false);
        bindView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        onClickItems();
    }

    private void bindView(View view) {
        et_email = view.findViewById(R.id.et_email);
        btn_sendCode = view.findViewById(R.id.btn_sendCode);
    }

    private void onClickItems() {
        btn_sendCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = SystemControl.getUserByEmail(SystemControl.getStringFromEditText(et_email));
                if (user != null) {
                    bundle.putSerializable(Constant.USER_FORGET_PASSWORD, user);
                    Constant.RESET_PASSWORD_FRAGMENT.setArguments(bundle);
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(Constant.CONTAINER_ID, Constant.RESET_PASSWORD_FRAGMENT)
                            .addToBackStack(Constant.FRAGMENT_LOG).commit();
                } else {
                    Toast.makeText(getActivity(), "This Email Not Sign before try sign Up ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
