package com.example.pizza.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;

import com.squareup.picasso.Picasso;

public class ImageAdapter extends PagerAdapter {
    Context context;
    String[] imageurl;

    public ImageAdapter(Context context, String[] imageurl) {
        this.context = context;
        this.imageurl = imageurl;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(context);
        Picasso.get().load(imageurl[position]).fit().into(imageView);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public int getCount() {
        if (imageurl.length != 0) {
            return imageurl.length;
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
