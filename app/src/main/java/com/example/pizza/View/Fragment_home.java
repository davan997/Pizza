package com.example.pizza.View;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.pizza.Adapter.CollectionAdapter;
import com.example.pizza.Adapter.BannerAdapter;
import com.example.pizza.Adapter.ItemAdapter;
import com.example.pizza.Model.Collection;
import com.example.pizza.Model.Item;
import com.example.pizza.R;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class Fragment_home extends Fragment {

    //banner
    ViewPager viewPager;
    BannerAdapter bannerAdapter;
    String[] bannerurl;
    Timer timer;

    //collection
    RecyclerView recyclercollect;
    CollectionAdapter collectionAdapter;
    ArrayList<Collection> collectionArrayList;

    //item
    RecyclerView recycleritem;
    ItemAdapter itemAdapter;
    ArrayList<Item> itemArrayList;

    View view;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        initview(inflater, container);
        return view;
    }

    public void initview(@NonNull LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragmenthome, container, false);
        recyclercollect = view.findViewById(R.id.recyclevcollect);
        viewPager = view.findViewById(R.id.containerbanner);
        recycleritem = view.findViewById(R.id.containerpizza);

        //handle collection
        collectionArrayList = new ArrayList<>();
        collectionAdapter = new CollectionAdapter(getActivity(),collectionArrayList);
        recyclercollect.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        recyclercollect.setAdapter(collectionAdapter);

        //handle item
        itemArrayList = new ArrayList<>();
        itemAdapter = new ItemAdapter(getActivity(),itemArrayList);
        recycleritem.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recycleritem.setAdapter(itemAdapter);
        //init banner
        bannerurl = new String[]{
                "https://i.ytimg.com/vi/ax-DC_N1M4c/maxresdefault.jpg",
                "https://st4.depositphotos.com/14582236/30991/v/1600/depositphotos_309919246-stock-illustration-pepperoni-pizza-banner-ads.jpg",
                "https://media.istockphoto.com/vectors/best-italian-pizza-banner-with-ribbon-tomato-cheese-mozzarella-flour-vector-id1253496654?k=6&m=1253496654&s=170667a&w=0&h=5R0zsi0x3_eVpzj2aVWy6MERKUbQeGGkKPHX_G0vKpE=",
                "https://i.pinimg.com/736x/a5/70/38/a570380fc036fe2b7d9506f5e2923587.jpg",
                "https://i.pinimg.com/originals/5f/d3/cc/5fd3cc9586103ac732457afa9568b68a.jpg"
        };

        //init collection
        collectionArrayList.add(new Collection(R.drawable.collect1));
        collectionArrayList.add(new Collection(R.drawable.collect2));
        collectionArrayList.add(new Collection(R.drawable.collect3));
        collectionArrayList.add(new Collection(R.drawable.collect4));
        collectionAdapter.notifyDataSetChanged();


        //init item
        itemArrayList.add(new Item(R.drawable.collect1));
        itemArrayList.add(new Item(R.drawable.collect2));
        itemArrayList.add(new Item(R.drawable.collect3));
        itemArrayList.add(new Item(R.drawable.collect4));

        //handle Banner
        bannerAdapter = new BannerAdapter(getActivity(), bannerurl);
        viewPager.setAdapter(bannerAdapter);
        autoslide();
    }

    public void autoslide() {
        if (timer == null) {
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            int currentimage = viewPager.getCurrentItem();
                            int totalimage = bannerurl.length - 1;
                            if (currentimage < totalimage) {
                                currentimage++;
                                viewPager.setCurrentItem(currentimage);
                            } else {
                                viewPager.setCurrentItem(0);
                            }
                        }
                    });
                }
            }, 1000, 5000);
        }
    }
}