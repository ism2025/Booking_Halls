package com.example.ismailamassi.bookinghall.Fragments.OwnerFragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ismailamassi.bookinghall.Helper.Constants;
import com.example.ismailamassi.bookinghall.Helper.PrefManager;
import com.example.ismailamassi.bookinghall.Model.Hall;
import com.example.ismailamassi.bookinghall.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OwnerNewHallFragment extends Fragment {

    EditText et_hallName, et_hallDesc, et_hallPhoneNumber, et_hallLocation, et_hallPrice;
    Button btn_save, btn_loadPhoto;

    String name;
    String desc;
    String loca;
    String phnu;
    String pric;

    int userId;
    PrefManager prefManager;

    public OwnerNewHallFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_owner_new_hall, container, false);
        bindViews(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        prefManager = new PrefManager(getContext());

        userId = prefManager.getCurrnetUser().getId();
        onClickItems();
    }

    private void bindViews(View view) {
        et_hallName = view.findViewById(R.id.et_hallName);
        et_hallDesc = view.findViewById(R.id.et_hallDesc);
        et_hallPhoneNumber = view.findViewById(R.id.et_hallPhoneNumber);
        et_hallLocation = view.findViewById(R.id.et_hallLocation);
        et_hallPrice = view.findViewById(R.id.et_hallPrice);
        btn_loadPhoto = view.findViewById(R.id.btn_loadPhoto);
        btn_save = view.findViewById(R.id.btn_save);
    }

    private void onClickItems() {
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFall()) {
                    new Hall(555, name, phnu, "https://i.ibb.co/nMRtxny/17.jpg", loca, 0, Integer.parseInt(pric), userId);
                    Toast.makeText(getActivity(), "Done . Mission Successfully.", Toast.LENGTH_SHORT).show();
                    getActivity().getSupportFragmentManager().beginTransaction().replace(Constants.OWNER_CONTENT_ID, Constants.OWNER_HOMEPAGE_FRAGMENT).commit();
                }
            }
        });
    }

    private boolean isFall() {
        name = et_hallName.getText().toString();
        desc = et_hallDesc.getText().toString();
        loca = et_hallLocation.getText().toString();
        phnu = et_hallPhoneNumber.getText().toString();
        pric = et_hallPrice.getText().toString();
        if (name.isEmpty()) {
            et_hallName.setError("Required Failed");
            return false;
        } else if (loca.isEmpty()) {
            et_hallLocation.setError("Required Failed");
            return false;
        } else if (phnu.isEmpty()) {
            et_hallPhoneNumber.setError("Required Failed");
            return false;
        } else if (pric.isEmpty()) {
            et_hallPrice.setError("Required Failed");
            return false;
        } else if (desc.isEmpty()) {
            desc = "";
            return true;
        } else {
            return true;
        }
    }
}
