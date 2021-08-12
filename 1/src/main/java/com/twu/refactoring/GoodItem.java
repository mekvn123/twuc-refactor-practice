package com.twu.refactoring;

public class GoodItem {
    private String description;
    private double price;
    private int quantity;

    public GoodItem(String description, double price, int quantity) {
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }


    double totalItemPrice() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return description + "\t" + price + "\t" + quantity + "\t" + totalItemPrice() + "\n";
    }
}
