package com.example.pizza.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pizza.Model.Collection;
import com.example.pizza.R;

import java.util.List;

public class CollectionAdapter extends RecyclerView.Adapter<CollectionAdapter.imageviewholder> {

    Context context;
    List<Collection> lcollection;

    public CollectionAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<Collection> collection){
        this.lcollection = collection;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public imageviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_1,parent,false);
        return new imageviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull imageviewholder holder, int position) {
        Glide.with(context).load(lcollection.get(position).getCollecturl()).centerCrop().fitCenter().into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        if (lcollection != null)
        {
            return lcollection.size();
        }
        return 0;
    }

    public class imageviewholder extends RecyclerView.ViewHolder{

        ImageView imageView;

        public imageviewholder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.cardview1);
        }
    }
}
