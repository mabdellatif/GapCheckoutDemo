/*
Author: Mahmoud Abdellatif
Date 11/09/2021
Purpose: Implementing checkout system that handles pricing schemes.
 */

package com.mahmoud.gap;

//This class is represents a key value pair.
public class QuantityPrice {
    private int quantity;
    private double price;

    public QuantityPrice(int quantity, double price){
        this.quantity = quantity;
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
