package com.example.pizza.View;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

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
import com.example.pizza.MainActivity;
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

    ImageButton btcart;
    View view;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        initview(inflater, container);

        //handle Banner
        bannerAdapter = new BannerAdapter(getActivity(), bannerurl);
        viewPager.setAdapter(bannerAdapter);
        autoslide();

        //handle collection
        collectionAdapter = new CollectionAdapter(getActivity());
        collectionAdapter.setData(collectionArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false);
        recyclercollect.setLayoutManager(linearLayoutManager);
        recyclercollect.setAdapter(collectionAdapter);

        //handle item
        itemAdapter = new ItemAdapter(getActivity(), itemArrayList, new IFPickItem() {
            @Override
            public void OnPickItem(Item item) {
                Intent intent = new Intent(getActivity(), PickItemView.class);
                Bundle bundle = new Bundle();
                bundle.putString("name",item.getName());
                bundle.putInt("image",item.getHinhanh());
                bundle.putString("infor",item.getInfor());
                bundle.putString("price",item.getPrice());
                bundle.putString("componet",item.getComponent());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        itemAdapter.notifyDataSetChanged();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        recycleritem.setLayoutManager(gridLayoutManager);
        recycleritem.setAdapter(itemAdapter);

        //handle btcart
        btcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;
    }

    public void initview(@NonNull LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragmenthome, container, false);

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
                "Pizza Rau C???",
                R.drawable.pizza1,
                "Thanh nh??? v???i ?? liu ??en tuy???t h???o, c?? chua bi t????i ngon, n????m, th??m, b???p, b?? ng??i va?? ph?? mai Mozzarella cho b???n b???a ti???c rau c??? tr??n v???",
                "$12.42",
                "T??m, cua, m???c v?? b??ng c???i xanh t????i ngon tr??n n???n s???t Pesto Xanh"
                ));
        itemArrayList.add(new Item(
                "Pizza H???i S???n S??t Pesto",
                R.drawable.pizza2,
                "Pizza H???i S???n X???t Pesto v???i h???i s???n (t??m, m???c) nh??n ????i c??ng v???i n???m tr??n n???n x???t Pesto ?????c tr??ng, ph??? ph?? mai Mozzarella t??? New Zealand v?? qu??? t??y.",
                "$18.25",
                "T??m, Gi??m b??ng, ????o ho?? quy???n b??ng n??? c??ng s???t Thousand Island"
                ));
        itemArrayList.add(new Item(
                "Pizza H???i S???n S???t Ti??u ??en",
                R.drawable.pizza3,
                "T??m, m???c v?? n???m tr??n n???n x???t Pesto ?????c tr??ng, ph??? ph?? mai Mozzarella",
                "$15.75",
                "Th???t ngu???i, x??c x??ch ti??u cay v?? d???a h??a quy???n v???i s???t Thousand Island"
                ));
        itemArrayList.add(new Item(
                "Pizza G?? L?????ng",
                R.drawable.pizza4,
                "T??m, m???c, thanh cua, h??nh t??y, th??m ph??? x???t ti??u ??en th??m n??ng v?? ph?? mai Mozzarella",
                "$15.75",
                "Th???t gi??m b??ng, th???t x??ng kh??i v?? hai lo???i rau c???a ???t xanh, c?? chua"
                ));
        itemArrayList.add(new Item(
                "Pizza Hawaiian",
                R.drawable.pizza5,
                "Ph??? gi??m b??ng v?? th??m ng???t d???u tr??n n???n s???t c?? chua truy???n th???ng",
                "$12.04",
                "X??c x??ch l???n v?? b?? ?????c tr??ng c???a ??, gi??m b??ng, th???t x??ng kh??i"
                ));
        itemArrayList.add(new Item(
                "Pizza C?? Ng???",
                R.drawable.pizza6,
                "Mang h????ng v??? bi???n c??? nh??? nh??ng v???i c?? ng???, thanh cua, ha??nh t??y, th??m tr??n n????n x????t Pesto",
                "$12.04",
                "Th???t g?? mang v??? ng???t c???a d???a k???t h???p v???i v??? cay n??ng c???a ???t"
                ));

        //init button cart
        btcart = view.findViewById(R.id.btcart);
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