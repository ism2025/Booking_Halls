package com.example.ismailamassi.bookinghall.Fragments.OwnerFragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ismailamassi.bookinghall.Adapters.OwnerHallBooksAdapter;
import com.example.ismailamassi.bookinghall.Helper.Constants;
import com.example.ismailamassi.bookinghall.Model.Hall;
import com.example.ismailamassi.bookinghall.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class OwnerHallBooksFragment extends Fragment {

    RecyclerView rv_ownerHallBooks;
    TextView tv_hallName;
    CircleImageView iv_emptystat2;
    TextView tv_emptystat2;

    public OwnerHallBooksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_owner_hall_books, container, false);
        bindViews(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = Constants.OWNER_HOMEPAGE_FRAGMENT.getArguments();
        Hall hall = (Hall) bundle.getSerializable("hall");
        if (hall.getBooks().size() == 0) {
            rv_ownerHallBooks.setVisibility(View.GONE);
            iv_emptystat2.setVisibility(View.VISIBLE);
            tv_emptystat2.setVisibility(View.VISIBLE);
        } else if (hall.getBooks().size() > 0) {
            rv_ownerHallBooks.setVisibility(View.VISIBLE);
            iv_emptystat2.setVisibility(View.GONE);
            tv_emptystat2.setVisibility(View.GONE);
        }
        tv_hallName.setText(hall.getName());
        OwnerHallBooksAdapter adapter = new OwnerHallBooksAdapter(getContext(), hall.getBooks());
        rv_ownerHallBooks.setAdapter(adapter);
        rv_ownerHallBooks.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }

    private void bindViews(View view) {
        rv_ownerHallBooks = view.findViewById(R.id.rv_ownerHallBooks);
        tv_hallName = view.findViewById(R.id.tv_hallName);
        iv_emptystat2 = view.findViewById(R.id.iv_emptystat2);
        tv_emptystat2 = view.findViewById(R.id.tv_emptystat2);
    }
}
