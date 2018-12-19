package com.example.ismailamassi.bookinghall.Fragments.CommonFragments;


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
import com.example.ismailamassi.bookinghall.R;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {
    CircleImageView iv_userPhoto;
    TextView tv_username, tv_phoneNumber, tv_userCureentBooks, tv_userEmail,
            tv_dif, tv_typeAccount, tv_numAllBooks, tv_numberAllBooks;
    Button btn_editData;


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        bindView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        if (getActivity().getIntent() != null && getActivity().getIntent().hasExtra("customer")) {
            Customer customer = (Customer) getActivity().getIntent().getSerializableExtra("user");
            Picasso.with(getContext()).load(customer.getPhoto()).placeholder(R.drawable.bg_circle).error(R.drawable.p16).into(iv_userPhoto);
            tv_username.setText(customer.getfName() + " " + customer.getlName());
            tv_phoneNumber.setText(customer.getPhoneNumber() + "");
            tv_userEmail.setText(customer.getEmail());
            tv_dif.setText("Current Books :");
            tv_userCureentBooks.setText(customer.getBooks().size() + "");
            tv_typeAccount.setText("Customer");
            tv_numberAllBooks.setVisibility(View.GONE);
            tv_numAllBooks.setVisibility(View.GONE);
        } else if (getActivity().getIntent() != null && getActivity().getIntent().hasExtra("owner")) {
            Owner owner = (Owner) getActivity().getIntent().getSerializableExtra("user");
            Picasso.with(getContext()).load(owner.getPhoto()).placeholder(R.drawable.bg_circle).error(R.drawable.p16).into(iv_userPhoto);
            tv_username.setText(owner.getfName() + " " + owner.getlName());
            tv_phoneNumber.setText(owner.getPhoneNumber() + "");
            tv_userEmail.setText(owner.getEmail());
            tv_dif.setText("Number Halls :");
            tv_userCureentBooks.setText(owner.getHalls().size() + "");
            tv_typeAccount.setText("Owner");
            int count = 0;
            for (int i = 0; i < owner.getHalls().size(); i++) {
                count += owner.getHalls().get(i).getBooks().size();
            }
            tv_numberAllBooks.setText(count + " Book .");
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
        tv_typeAccount = view.findViewById(R.id.tv_typeAccount);
        tv_numAllBooks = view.findViewById(R.id.tv_numAllBooks);
        tv_numberAllBooks = view.findViewById(R.id.tv_numberAllBooks);
    }

}
