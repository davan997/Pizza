package com.example.pizza.Model;

import java.io.Serializable;

public class Item implements Serializable {
    int hinhanh;
    String infor,price,name,component;

    public Item(String name,int hinhanh, String infor, String price, String component) {
        this.name = name;
        this.hinhanh = hinhanh;
        this.infor = infor;
        this.price = price;
        this.component = component;
    }

    public Item() {
    }

    public int getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(int hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getInfor() {
        return infor;
    }

    public void setInfor(String infor) {
        this.infor = infor;
    }

    public String getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}