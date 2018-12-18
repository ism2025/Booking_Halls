package com.example.ismailamassi.bookinghall.Fragments.CustomerFragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.ismailamassi.bookinghall.Adapters.BooksAdapter;
import com.example.ismailamassi.bookinghall.Helper.SystemControl;
import com.example.ismailamassi.bookinghall.Model.Book;
import com.example.ismailamassi.bookinghall.Model.Customer;
import com.example.ismailamassi.bookinghall.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CustomerBooksFragment extends Fragment {
    RecyclerView rv_customerBooks;
    Customer customer;

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
        Toast.makeText(getContext(), customer.getfName() + " " + customer.getlName() + "", Toast.LENGTH_SHORT).show();
        Toast.makeText(getContext(), customer.getBooks().size()+"", Toast.LENGTH_SHORT).show();
        BooksAdapter adapter = new BooksAdapter(getContext(), customer.getBooks());
        rv_customerBooks.setAdapter(adapter);
        rv_customerBooks.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayout.VERTICAL, false));
    }

    private void bindViews(View view) {
        rv_customerBooks = view.findViewById(R.id.rv_customerBooks);
    }

}
