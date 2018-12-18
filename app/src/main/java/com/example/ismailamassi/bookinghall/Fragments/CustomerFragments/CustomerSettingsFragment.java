package com.example.ismailamassi.bookinghall.Fragments.CustomerFragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.Toast;

import com.example.ismailamassi.bookinghall.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CustomerSettingsFragment extends Fragment {

    Switch notification_switch;

    public CustomerSettingsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_customer_settings, container, false);
        bindView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        boolean boll = notification_switch.isChecked();
        if (boll) {
            Toast.makeText(getActivity(), "True", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "False", Toast.LENGTH_SHORT).show();
        }
    }

    private void bindView(View view) {
        notification_switch = view.findViewById(R.id.notification_switch);
    }

}
