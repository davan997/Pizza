package com.example.pizza.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pizza.Model.Collection;
import com.example.pizza.R;

import java.util.List;

public class CollectionAdapter extends RecyclerView.Adapter<CollectionAdapter.collectViewHolder> {

    Context context;
    List<Collection> lcollection;

    public CollectionAdapter(Context context, List<Collection> lcollection) {
        this.context = context;
        this.lcollection = lcollection;
    }


    @NonNull
    @Override
    public collectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_1, parent, false);
        return new collectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull collectViewHolder holder, int position) {
        Collection collection = lcollection.get(position);
        if (collection == null) {
            return;
        }
        Log.e("TAG", "onBindViewHolder");
        holder.imageView.setImageResource(collection.getCollect());

    }

    @Override
    public int getItemCount() {
        return lcollection.size();
    }

    public class collectViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public collectViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.cardview1);
        }
    }
}
