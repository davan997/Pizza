package com.example.pizza.View;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.pizza.Adapter.CollectionAdapter;
import com.example.pizza.Adapter.ImageAdapter;
import com.example.pizza.MainActivity;
import com.example.pizza.Model.Collection;
import com.example.pizza.Model.Image;
import com.example.pizza.R;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class Fragment_home extends Fragment {

    ViewPager viewPager;
    ImageAdapter imageAdapter;
    GridView gridView1;
    RecyclerView recyclerView;
    CollectionAdapter collectionAdapter;
    ArrayList<Collection> collectionArrayList;
    String[] image;
    Timer timer;
    View view;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        initview(inflater,container);
        imageAdapter = new ImageAdapter(getActivity(),image);
        collectionAdapter = new CollectionAdapter(getActivity());
        collectionAdapter.setData(collectionArrayList);
        viewPager.setAdapter(imageAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),3);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(collectionAdapter);
        autoslide();
        return view;
    }

    public void initview(@NonNull LayoutInflater inflater, ViewGroup container){
        view = inflater.inflate(R.layout.fragmenthome,container,false);
        viewPager = view.findViewById(R.id.containerbanner);
        gridView1 = view.findViewById(R.id.gridcollection2);
        recyclerView = view.findViewById(R.id.recycleview);

        image = new String[]{
                "https://i.ytimg.com/vi/ax-DC_N1M4c/maxresdefault.jpg",
                "https://st4.depositphotos.com/14582236/30991/v/1600/depositphotos_309919246-stock-illustration-pepperoni-pizza-banner-ads.jpg",
                "https://media.istockphoto.com/vectors/best-italian-pizza-banner-with-ribbon-tomato-cheese-mozzarella-flour-vector-id1253496654?k=6&m=1253496654&s=170667a&w=0&h=5R0zsi0x3_eVpzj2aVWy6MERKUbQeGGkKPHX_G0vKpE=",
                "https://i.pinimg.com/736x/a5/70/38/a570380fc036fe2b7d9506f5e2923587.jpg",
                "https://i.pinimg.com/originals/5f/d3/cc/5fd3cc9586103ac732457afa9568b68a.jpg"
        };
        collectionArrayList = new ArrayList<>();
        collectionArrayList.add(new Collection("https://vicogroup.vn/images/upload/images/43dbc6853dec85bb573d941a68927367.jpg"));
        collectionArrayList.add(new Collection("https://graphicriver.img.customer.envatousercontent.com/files/323212535/Preview.jpg?auto=compress%2Cformat&fit=crop&crop=top&w=590&h=590&s=319670ed35a857c94ae8fa7b809cdf2e"));
        collectionArrayList.add(new Collection("https://graphicriver.img.customer.envatousercontent.com/files/297442410/590.jpg?auto=compress%2Cformat&fit=crop&crop=top&w=590&h=590&s=961605433290d0e04967908a68ac3416"));
        collectionArrayList.add(new Collection("https://d1csarkz8obe9u.cloudfront.net/posterpreviews/pizza-banner-advertising-design-template-d442c4deeb024c0d9f066a4b0915840a_screen.jpg?ts=1595913950"));
    }
    public void autoslide(){
        if(timer == null){
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            int currentimage = viewPager.getCurrentItem();
                            int totalimage = image.length - 1;
                            if(currentimage < totalimage){
                                currentimage++;
                                viewPager.setCurrentItem(currentimage);
                            }
                            else {
                                viewPager.setCurrentItem(0);
                            }
                        }
                    });
                }
            },1000 , 5000);
        }
    }
}
