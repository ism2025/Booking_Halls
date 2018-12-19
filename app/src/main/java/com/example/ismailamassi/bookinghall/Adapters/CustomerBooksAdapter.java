package com.example.ismailamassi.bookinghall.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ismailamassi.bookinghall.Activites.CustomerMainActivity;
import com.example.ismailamassi.bookinghall.Helper.Constants;
import com.example.ismailamassi.bookinghall.Model.Book;
import com.example.ismailamassi.bookinghall.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomerBooksAdapter extends RecyclerView.Adapter<CustomerBooksAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<Book> list;

    public CustomerBooksAdapter(Context context, ArrayList<Book> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_customer_book, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Book book = list.get(position);
        Picasso.with(context).load(book.getHall().getPhoto()).placeholder(R.drawable.placeholder).error(R.drawable.error).into(holder.iv_hallPhoto);
        holder.tv_hallName.setText(book.getHall().getName());
        holder.tv_bookDate.setText(book.getDate());
        holder.btn_deleteBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                book.getHall().getBooks().remove(book);
                book.getCustomer().getBooks().remove(book);
                list.remove(book);
                notifyDataSetChanged();
            }
        });
        holder.cardViewBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("hall", book.getHall());
                ((CustomerMainActivity) context).getSupportFragmentManager().beginTransaction().replace(Constants.CUSTOMER_CONTENT_ID, Constants.HALL_PAGE_FRAGMENT).addToBackStack(Constants.FRAGMENT_LOG).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_hallPhoto;
        TextView tv_hallName, tv_bookDate;
        Button btn_deleteBook;
        CardView cardViewBook;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv_hallPhoto = itemView.findViewById(R.id.iv_hallPhoto);
            tv_hallName = itemView.findViewById(R.id.tv_hallName);
            tv_bookDate = itemView.findViewById(R.id.tv_bookDate);
            btn_deleteBook = itemView.findViewById(R.id.btn_deleteBook);
            cardViewBook = itemView.findViewById(R.id.cardViewBook);
        }
    }
}
