package com.example.ismailamassi.bookinghall.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ismailamassi.bookinghall.Activites.CustomerMainActivity;
import com.example.ismailamassi.bookinghall.Activites.OwnerMainActivity;
import com.example.ismailamassi.bookinghall.Helper.Constant;
import com.example.ismailamassi.bookinghall.Model.Hall;
import com.example.ismailamassi.bookinghall.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class OwnerHallsAdapter extends RecyclerView.Adapter<OwnerHallsAdapter.MyViewHolder> {
    Context context;
    ArrayList<Hall> list;

    public OwnerHallsAdapter(Context context, ArrayList<Hall> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_owner_hall, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Hall hall = list.get(position);

        Picasso.with(context).load(
                hall.getPhoto()).placeholder(R.drawable.bg_circle)
                .error(R.drawable.p16).into(holder.iv_hallPhoto);
        holder.tv_hallName.setText(hall.getName());
        holder.tv_numBook.setText(hall.getBooks().size() + "");
        holder.card_ownerHall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("hall", hall);
                Constant.OWNER_HOMEPAGE_FRAGMENT.setArguments(bundle);
                ((OwnerMainActivity) context).getSupportFragmentManager().beginTransaction().replace(Constant.OWNER_CONTENT_ID, Constant.OWNER_HALL_BOOKS_FRAGMENT).addToBackStack(Constant.FRAGMENT_LOG).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CardView card_ownerHall;
        ImageView iv_hallPhoto;
        TextView tv_hallName, tv_numBook;

        public MyViewHolder(View itemView) {
            super(itemView);
            card_ownerHall = itemView.findViewById(R.id.card_ownerHall);
            iv_hallPhoto = itemView.findViewById(R.id.iv_hallPhoto);
            tv_hallName = itemView.findViewById(R.id.tv_hallName);
            tv_numBook = itemView.findViewById(R.id.tv_numBook);
        }
    }
}
