package com.example.ismailamassi.bookinghall.Fragments.CommonFragments;


import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ismailamassi.bookinghall.Helper.Constant;
import com.example.ismailamassi.bookinghall.Model.Book;
import com.example.ismailamassi.bookinghall.Model.Customer;
import com.example.ismailamassi.bookinghall.Model.Hall;
import com.example.ismailamassi.bookinghall.Model.User;
import com.example.ismailamassi.bookinghall.R;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class HallPageFragment extends Fragment implements DatePickerDialog.OnDateSetListener {

    TextView tv_hallName, tv_hallRate, tv_locationDesc, tv_phoneNumberDesc;
    ImageView iv_hallPhoto;
    Button btn_bookNow;

    String bookDate;

    Customer customer;
    Hall hall;

    public HallPageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hall_page, container, false);
        bindViews(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle hallBundle = Constant.HALL_PAGE_FRAGMENT.getArguments();
        customer = (Customer) getActivity().getIntent().getSerializableExtra("user");
        hall = (Hall) hallBundle.getSerializable("hall");
        tv_hallName.setText(hall.getName());
        tv_hallRate.setText(hall.getRate() + "");
        tv_locationDesc.setText(hall.getLocation());
        tv_phoneNumberDesc.setText(hall.getPhoneNumber());
        Picasso.with(getContext()).load(hall.getPhoto()).placeholder(R.drawable.bg_circle).error(R.drawable.p16).into(iv_hallPhoto);
        onClickItems();
    }

    private void onClickItems() {
        final DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), this, 1999, 1, 1);
        btn_bookNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });
    }

    void bindViews(View view) {
        tv_hallName = view.findViewById(R.id.tv_hallName);
        tv_hallRate = view.findViewById(R.id.tv_hallRate);
        tv_locationDesc = view.findViewById(R.id.tv_locationDesc);
        tv_phoneNumberDesc = view.findViewById(R.id.tv_phoneNumberDesc);
        btn_bookNow = view.findViewById(R.id.btn_bookNow);
        iv_hallPhoto = view.findViewById(R.id.iv_hallPhoto);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        bookDate = (dayOfMonth + "-" + month + "-" + year);
        Book book = new Book(1, bookDate, customer.getId(), hall.getId());
        Toast.makeText(getActivity(), "Mission Successfully. Done Add Book Hall "
                + hall.getName() + " for " + customer.getfName() + " " + customer.getlName() + " ",
                Toast.LENGTH_SHORT).show();
        customer.getBooks().add(book);
        getActivity().getSupportFragmentManager().beginTransaction().replace(Constant.CONTENT_ID, Constant.CUSTMOR_HOMEPAGE_FRAGMENT).commit();
    }
}
