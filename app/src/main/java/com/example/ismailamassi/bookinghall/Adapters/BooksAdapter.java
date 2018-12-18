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
import android.widget.Toast;

import com.example.ismailamassi.bookinghall.Activites.CustomerMainActivity;
import com.example.ismailamassi.bookinghall.Helper.Constant;
import com.example.ismailamassi.bookinghall.Model.Book;
import com.example.ismailamassi.bookinghall.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<Book> list;

    public BooksAdapter(Context context, ArrayList<Book> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_book, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Book book = list.get(position);
        Picasso.with(context).load(book.getHall().getPhoto()).placeholder(R.drawable.bg_circle).error(R.drawable.p16).into(holder.iv_hallPhoto);
        holder.tv_hallName.setText(book.getHall().getName());
        holder.tv_bookDate.setText(book.getDate());
        holder.btn_deleteBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.remove(book);
                notifyDataSetChanged();
            }
        });
        holder.cardViewBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("hall", book.getHall());
                ((CustomerMainActivity) context).getSupportFragmentManager().beginTransaction().replace(Constant.CONTENT_ID, Constant.HALL_PAGE_FRAGMENT).addToBackStack(Constant.FRAGMENT_LOG).commit();
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
