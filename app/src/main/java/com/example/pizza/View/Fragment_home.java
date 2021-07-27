package com.example.pizza.View;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.pizza.Adapter.CollectionAdapter;
import com.example.pizza.Adapter.BannerAdapter;
import com.example.pizza.Adapter.ItemAdapter;
import com.example.pizza.Interface.IFPickItem;
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
        initview(inflater,container);

        //handle Banner
        bannerAdapter = new BannerAdapter(getActivity(),bannerurl);
        viewPager.setAdapter(bannerAdapter);
        autoslide();

        //handle collection
        collectionAdapter = new CollectionAdapter(getActivity());
        collectionAdapter.setData(collectionArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
        recyclercollect.setLayoutManager(linearLayoutManager);
        recyclercollect.setAdapter(collectionAdapter);

        //handle item
        itemAdapter = new ItemAdapter(getActivity(), itemArrayList, new IFPickItem() {
            @Override
            public void OnPickItem(Item item) {
                Intent intent = new Intent(getActivity(),PickItemView.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", item.getName());
                bundle.putInt("image", item.getHinhanh());
                bundle.putString("info", item.getInfor());
                bundle.putString("price", item.getPrice());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        itemAdapter.notifyDataSetChanged();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        recycleritem.setLayoutManager(gridLayoutManager);
        recycleritem.setAdapter(itemAdapter);
        return view;
    }
    public void initview(@NonNull LayoutInflater inflater, ViewGroup container){
        view = inflater.inflate(R.layout.fragmenthome,container,false);

        //init banner
        viewPager = view.findViewById(R.id.containerbanner);
        bannerurl = new String[]{
                "https://st4.depositphotos.com/14582236/30991/v/1600/depositphotos_309919246-stock-illustration-pepperoni-pizza-banner-ads.jpg",
                "https://i.pinimg.com/736x/a5/70/38/a570380fc036fe2b7d9506f5e2923587.jpg",
                "https://i.pinimg.com/originals/5f/d3/cc/5fd3cc9586103ac732457afa9568b68a.jpg"
        };

        //init collection
        recyclercollect = view.findViewById(R.id.recyclevcollect);
        collectionArrayList = new ArrayList<>();
        collectionArrayList.add(new Collection(R.drawable.collect1));
        collectionArrayList.add(new Collection(R.drawable.collect2));
        collectionArrayList.add(new Collection(R.drawable.collect3));
        collectionArrayList.add(new Collection(R.drawable.collect4));

        //init item
        recycleritem = view.findViewById(R.id.containerpizza);
        itemArrayList = new ArrayList<>();
        itemArrayList.add(new Item(
                "Pizza Rau Củ",
                R.drawable.pizza1,
                "Thanh nhẹ với ô liu đen tuyệt hảo, cà chua bi tươi ngon, nấm, thơm, bắp, bí ngòi và phô mai Mozzarella cho bạn bữa tiệc rau củ tròn vị",
                "$12.42"));
        itemArrayList.add(new Item(
                "Pizza Hải Sản Sót Pesto",
                R.drawable.pizza2,
                "Pizza Hải Sản Xốt Pesto với hải sản (tôm, mực) nhân đôi cùng với nấm trên nền xốt Pesto đặc trưng, phủ phô mai Mozzarella từ New Zealand và quế tây.",
                "$18.25"));
        itemArrayList.add(new Item(
                "Pizza Hải Sản Sốt Tiêu Đen",
                R.drawable.pizza3,
                "Tôm, mực và nấm trên nền xốt Pesto đặc trưng, phủ phô mai Mozzarella",
                "$15.75"));
        itemArrayList.add(new Item(
                "Pizza Gà Lướng",
                R.drawable.pizza4,
                "Tôm, mực, thanh cua, hành tây, thơm phủ xốt tiêu đen thơm nóng và phô mai Mozzarella",
                "$15.75"));
        itemArrayList.add(new Item(
                "Pizza Hawaiian",
                R.drawable.pizza5,
                "Phủ giăm bông và thơm ngọt dịu trên nền sốt cà chua truyền thống",
                "$12.04"));
        itemArrayList.add(new Item(
                "Pizza Cá Ngừ",
                R.drawable.pizza6,
                "Mang hương vị biển cả nhẹ nhàng với cá ngừ, thanh cua, hành tây, thơm trên nền xốt Pesto",
                "$12.04"));
    }
    public void autoslide() {
        if(timer == null){
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
            },1000 , 5000);
        }
    }
}