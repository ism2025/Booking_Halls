package com.example.ismailamassi.bookinghall.Fragments.LoginSystemFragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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
public class ResetPasswordFragment extends Fragment {

    TextView tv_captcha;
    EditText et_captcha, et_newPassword;
    Button btn_saveNewPassword;
    String captcha;


    Bundle bundle;
    User user;

    public ResetPasswordFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reset_password, container, false);
        bindView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        captcha = getRandomNumberString();
        tv_captcha.setText(captcha);
        bundle = getArguments();
        user = (User) bundle.getSerializable(Constant.USER_FORGET_PASSWORD);

        onClickItems();
    }


    private void bindView(View view) {
        tv_captcha = view.findViewById(R.id.tv_captcha);
        et_captcha = view.findViewById(R.id.et_captcha);
        et_newPassword = view.findViewById(R.id.et_newPassword);
        btn_saveNewPassword = view.findViewById(R.id.btn_saveNewPassword);
    }

    private void onClickItems() {
        btn_saveNewPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enterCaptcha = SystemControl.getStringFromEditText(et_captcha);
                String newPassword = SystemControl.getStringFromEditText(et_newPassword);
                if (captcha.equals(enterCaptcha)) {
                    if (newPassword.length() < 6 || newPassword.length() > 31) {
                        Toast.makeText(getActivity(), "The Password must be between 6  and 32 digit .", Toast.LENGTH_SHORT).show();
                    } else {
                        user.setPassword(newPassword);
                        Toast.makeText(getActivity(), "Change Password is Successfully", Toast.LENGTH_SHORT).show();
                        getActivity().getSupportFragmentManager().beginTransaction().replace
                                (Constant.CONTAINER_ID, Constant.LOGIN_FRAGMENT)
                                .addToBackStack(Constant.FRAGMENT_LOG).commit();
                    }
                } else {
                    Toast.makeText(getActivity(), "Please Enter Correct Captcha ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public static String getRandomNumberString() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format(Locale.CANADA, "%06d", number);
    }

}
