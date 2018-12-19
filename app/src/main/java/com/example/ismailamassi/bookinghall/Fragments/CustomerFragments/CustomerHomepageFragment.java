package com.example.ismailamassi.bookinghall.Fragments.CustomerFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ismailamassi.bookinghall.Adapters.CustomerHallsAdapter;
import com.example.ismailamassi.bookinghall.Helper.SystemControl;
import com.example.ismailamassi.bookinghall.R;


public class CustomerHomepageFragment extends Fragment {

    RecyclerView rv_customerHomepage;

    public CustomerHomepageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_customer_homepage, container, false);
        rv_customerHomepage = view.findViewById(R.id.rv_customerHomepage);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        rv_customerHomepage.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        CustomerHallsAdapter adapter = new CustomerHallsAdapter(getActivity(), SystemControl.allHalls);
//        rv_customerHomepage.
        rv_customerHomepage.setAdapter(adapter);
    }


}