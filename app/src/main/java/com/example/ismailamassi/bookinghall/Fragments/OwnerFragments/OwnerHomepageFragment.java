package com.example.ismailamassi.bookinghall.Fragments.OwnerFragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ismailamassi.bookinghall.Adapters.OwnerHallsAdapter;
import com.example.ismailamassi.bookinghall.Helper.PrefManager;
import com.example.ismailamassi.bookinghall.Model.Customer;
import com.example.ismailamassi.bookinghall.Model.Owner;
import com.example.ismailamassi.bookinghall.Model.User;
import com.example.ismailamassi.bookinghall.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class OwnerHomepageFragment extends Fragment {

    RecyclerView rv_ownerHalls;
    CircleImageView iv_emptystat;
    TextView tv_emptystat;
    Owner owner;

    public OwnerHomepageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_owner_home_page, container, false);
        bindViews(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        PrefManager prefManager = new PrefManager(getContext());
        owner = (Owner) prefManager.getCurrnetUser();
        if (owner.getHalls().size() == 0) {
            rv_ownerHalls.setVisibility(View.GONE);
            iv_emptystat.setVisibility(View.VISIBLE);
            tv_emptystat.setVisibility(View.VISIBLE);
        } else if (owner.getHalls().size() > 0) {
            rv_ownerHalls.setVisibility(View.VISIBLE);
            iv_emptystat.setVisibility(View.GONE);
            tv_emptystat.setVisibility(View.GONE);
        }

        OwnerHallsAdapter adapter = new OwnerHallsAdapter(getContext(), owner.getHalls());
        rv_ownerHalls.setAdapter(adapter);
        rv_ownerHalls.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }

    private void bindViews(View view) {
        rv_ownerHalls = view.findViewById(R.id.rv_ownerHalls);
        iv_emptystat = view.findViewById(R.id.iv_emptystat);
        tv_emptystat = view.findViewById(R.id.tv_emptystat);
    }

}
