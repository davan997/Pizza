package com.example.pizza.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pizza.R;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolderCart> {

    Context context;

    @NonNull
    @Override
    public ViewHolderCart onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_view,parent,false);
        return new ViewHolderCart(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderCart holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolderCart extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name,each,components,price;
        Button btmi,btpl;

        public ViewHolderCart(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.cartimage);
            name = itemView.findViewById(R.id.cartname);
            each = itemView.findViewById(R.id.carteach);
            price = itemView.findViewById(R.id.cartprice);
            components = itemView.findViewById(R.id.componentitem);
            btmi = itemView.findViewById(R.id.cartminus);
            btpl = itemView.findViewById(R.id.cartplus);
        }
    }
}