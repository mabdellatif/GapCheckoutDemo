/*
Author: Mahmoud Abdellatif
Date 11/09/2021
Purpose: Implementing checkout system that handles pricing schemes.
 */

package com.mahmoud.gap;
import java.util.Iterator;
import java.util.Map;

public class Checkout {
    private Map<Character, Item> rules;
    private double total = 0;


public Checkout(Map<Character, Item> rules) {
this.rules = rules;

}

    public double getTotal() {
        return total;
    }

    public double scan(char scannedItem){
    try {
        this.total = 0;
        Item i = (Item) rules.get(scannedItem);

        //calculates how many times this item was scanned and sets the total price just for this item
        i.itemScan();
        Iterator iterator = this.rules.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry me = (Map.Entry)iterator.next();
            Item currentItem = (Item)me.getValue();
            this.total += currentItem.getTotalprice();
        }

    } catch (NullPointerException e) {
       System.out.println(e.getMessage());
    }
        return total;
    }
}
