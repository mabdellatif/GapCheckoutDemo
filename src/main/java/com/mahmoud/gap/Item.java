/*
Author: Mahmoud Abdellatif
Date 11/09/2021
Purpose: Implementing checkout system that handles pricing schemes.
 */


package com.mahmoud.gap;
import java.util.ArrayList;
import java.util.List;

public class Item {
    private char name;
    private List<QuantityPrice> priceMap;
    private int count = 0;
    private double totalprice = 0;

//This class represents a scanned item. contains pricing information based on quantity.
    public Item(char name, List<QuantityPrice> priceMap){
        this.name = name;
        //priceMap is set through the rules property in the Checkout class.
        this.priceMap = new ArrayList<QuantityPrice>(priceMap);
    }
    public char getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public double itemScan() {
        double totalPrice = 0;
        this.count +=1;
        int remainingCount = this.count;
        int index = priceMap.size() -1;

        while (remainingCount > 0 && index >-1) {
            QuantityPrice qp = priceMap.get(index);
            totalPrice += Math.floor(remainingCount/ qp.getQuantity())* qp.getPrice();
            remainingCount = remainingCount % qp.getQuantity();
            index--;
        }
        this.totalprice = totalPrice;
        return this.totalprice;
    }

    public double getTotalprice(){
        return this.totalprice;
    }
}