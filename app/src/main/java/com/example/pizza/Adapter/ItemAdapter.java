package com.example.pizza.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pizza.Interface.IFPickItem;
import com.example.pizza.Model.Item;
import com.example.pizza.R;
import com.example.pizza.View.PickItemView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    Context context;
    List<Item> litem;
    IFPickItem ifPickItem;

    public ItemAdapter(Context context, List<Item> litem,IFPickItem ifPickItem) {
        this.context = context;
        this.litem = litem;
        this.ifPickItem = ifPickItem;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_view_2,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Item item = litem.get(position);
        if (item == null){
            return;
        }
        holder.imageView.setImageResource(item.getHinhanh());
        holder.layoutclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ifPickItem.OnPickItem(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (litem != null){
            return litem.size();
        }
        return 0;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        CardView layoutclick;
        ImageView imageView;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.itempizza);
            layoutclick = itemView.findViewById(R.id.clickselectpizza);
        }
    }
}
