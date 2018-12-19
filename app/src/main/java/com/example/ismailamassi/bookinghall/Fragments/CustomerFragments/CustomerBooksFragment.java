package com.example.ismailamassi.bookinghall.Fragments.CustomerFragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ismailamassi.bookinghall.Adapters.CustomerBooksAdapter;
import com.example.ismailamassi.bookinghall.Helper.Constant;
import com.example.ismailamassi.bookinghall.Model.Customer;
import com.example.ismailamassi.bookinghall.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class CustomerBooksFragment extends Fragment {
    RecyclerView rv_customerBooks;
    Customer customer;
    CircleImageView iv_emptystat;
    TextView tv_emptystat;
    Button btn_viewHalls;

    public CustomerBooksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_customer_books, container, false);
        bindViews(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        customer = (Customer) getActivity().getIntent().getSerializableExtra("user");
        if (customer.getBooks().size() == 0) {
            rv_customerBooks.setVisibility(View.GONE);
            iv_emptystat.setVisibility(View.VISIBLE);
            tv_emptystat.setVisibility(View.VISIBLE);
            btn_viewHalls.setVisibility(View.VISIBLE);
        } else if (customer.getBooks().size() > 0) {
            rv_customerBooks.setVisibility(View.VISIBLE);
            iv_emptystat.setVisibility(View.GONE);
            tv_emptystat.setVisibility(View.GONE);
            btn_viewHalls.setVisibility(View.GONE);
        }
        CustomerBooksAdapter adapter = new CustomerBooksAdapter(getContext(), customer.getBooks());
        rv_customerBooks.setAdapter(adapter);
        rv_customerBooks.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayout.VERTICAL, false));
        btn_viewHalls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(Constant.CUSTOMER_CONTENT_ID, Constant.CUSTMOR_HOMEPAGE_FRAGMENT).addToBackStack(Constant.FRAGMENT_LOG).commit();
            }
        });
    }

    private void bindViews(View view) {
        rv_customerBooks = view.findViewById(R.id.rv_customerBooks);
        iv_emptystat = view.findViewById(R.id.iv_emptystat);
        tv_emptystat = view.findViewById(R.id.tv_emptystat);
        btn_viewHalls = view.findViewById(R.id.btn_viewHalls);

    }

}
