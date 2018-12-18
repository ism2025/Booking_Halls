package com.example.ismailamassi.bookinghall.Fragments.CustomerFragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ismailamassi.bookinghall.Model.Customer;
import com.example.ismailamassi.bookinghall.Model.Owner;
import com.example.ismailamassi.bookinghall.Model.User;
import com.example.ismailamassi.bookinghall.R;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class CustomerProfileFragment extends Fragment {
    CircleImageView iv_userPhoto;
    TextView tv_username, tv_phoneNumber, tv_userCureentBooks, tv_userEmail, tv_dif;
    Button btn_editData;

    User customer;

    public CustomerProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_customer_profile, container, false);
        bindView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        customer = (User) getActivity().getIntent().getSerializableExtra("user");
        Picasso.with(getContext()).load(customer.getPhoto()).placeholder(R.drawable.bg_circle).error(R.drawable.p16).into(iv_userPhoto);
        tv_username.setText(customer.getfName() + " " + customer.getlName());
        tv_phoneNumber.setText(customer.getPhoneNumber() + "");
        tv_userEmail.setText(customer.getEmail());
        if (customer instanceof Customer) {
            tv_dif.setText("Current Books");
            tv_userCureentBooks.setText(((Customer) customer).getBooks().size() + "");
        } else if (customer instanceof Owner) {
            tv_dif.setText("Current Books");
            tv_userCureentBooks.setText(((Owner) customer).getHalls().size() + "");
        }
    }

    private void bindView(View view) {
        iv_userPhoto = view.findViewById(R.id.iv_userPhoto);
        tv_username = view.findViewById(R.id.tv_username);
        tv_phoneNumber = view.findViewById(R.id.tv_phoneNumber);
        tv_userCureentBooks = view.findViewById(R.id.tv_userCureentBooks);
        tv_userEmail = view.findViewById(R.id.tv_userEmail);
        tv_dif = view.findViewById(R.id.tv_dif);
        btn_editData = view.findViewById(R.id.btn_editData);

    }

}
