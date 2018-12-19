package com.example.ismailamassi.bookinghall.Fragments.OwnerFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ismailamassi.bookinghall.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OwnerHallsFragment extends Fragment {


    public OwnerHallsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_owner_halls, container, false);
    }

}
