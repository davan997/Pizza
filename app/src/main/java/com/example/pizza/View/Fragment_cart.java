package com.example.pizza.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pizza.Adapter.CartAdapter;
import com.example.pizza.R;

public class Fragment_cart extends Fragment {

    View view;
    CartAdapter cartAdapter;
    RecyclerView cartview;
    TextView subtotal,fee,tax,totalmount;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        innit(inflater,container);
        return view;
    }

    public void innit(LayoutInflater inflater,ViewGroup container){
        view = inflater.inflate(R.layout.fragmentcart,container,false);

        //innit
        cartview = view.findViewById(R.id.listcart);
        subtotal = view.findViewById(R.id.subtotal);
        fee = view.findViewById(R.id.shippingfee);
        tax = view.findViewById(R.id.textTax);
        totalmount = view.findViewById(R.id.totalamount);
    }
}