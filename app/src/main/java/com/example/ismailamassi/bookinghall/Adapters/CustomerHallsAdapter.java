package com.example.ismailamassi.bookinghall.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.ismailamassi.bookinghall.Activites.CustomerMainActivity;
import com.example.ismailamassi.bookinghall.Helper.Constant;
import com.example.ismailamassi.bookinghall.Model.Hall;
import com.example.ismailamassi.bookinghall.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomerHallsAdapter extends RecyclerView.Adapter<CustomerHallsAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<Hall> halls;

    public CustomerHallsAdapter(Context context, ArrayList<Hall> halls) {
        this.context = context;
        this.halls = halls;
    }

//    @Override
//    public int getItemViewType(int position) {
//        if (position == 0) return 1;
//        else return 2;
//    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        if (viewType == 1) {
//            // inflate your first item layout & return that viewHolder
//        } else {
//            // inflate your second item layout & return that viewHolder
//        }
        View view = LayoutInflater.from(context).inflate(R.layout.item_customer_hall, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Hall hall = halls.get(position);
        Picasso.with(context).load(
                hall.getPhoto()).placeholder(R.drawable.bg_circle)
                .error(R.drawable.p16).into(holder.iv_hallPhoto);

        holder.tv_hallName.setText(hall.getName());
        holder.rb_hallRate.setRating(hall.getRate());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("hall", hall);
                Constant.HALL_PAGE_FRAGMENT.setArguments(bundle);
                ((CustomerMainActivity) context).getSupportFragmentManager().beginTransaction().replace(Constant.CUSTOMER_CONTENT_ID, Constant.HALL_PAGE_FRAGMENT).addToBackStack(Constant.FRAGMENT_LOG).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return halls.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_hallPhoto;
        TextView tv_hallName;
        RatingBar rb_hallRate;
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv_hallPhoto = itemView.findViewById(R.id.iv_hallPhoto);
            tv_hallName = itemView.findViewById(R.id.tv_hallName);
            rb_hallRate = itemView.findViewById(R.id.rb_hallRate);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }

}
