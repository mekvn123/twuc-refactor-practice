package com.twu.refactoring;

import java.util.List;

public class Order {
    String name;
    String address;
    List<GoodItem> goodItemList;

    public Order(String name, String address, List<GoodItem> goodItemList) {
        this.name = name;
        this.address = address;
        this.goodItemList = goodItemList;
    }

    public List<GoodItem> getGoodItemList() {
        return goodItemList;
    }

    @Override
    public String toString() {
        return name + address + goodItemList.toString();
    }
}
