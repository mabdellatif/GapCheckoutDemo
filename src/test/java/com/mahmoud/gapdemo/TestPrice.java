/*
Author: Mahmoud Abdellatif
Date 11/09/2021
Purpose: Implementing checkout system that handles pricing schemes.
 */

package com.mahmoud.gapdemo;
import com.mahmoud.gap.Checkout;
import com.mahmoud.gap.Item;
import com.mahmoud.gap.QuantityPrice;
import org.junit.jupiter.api.Assertions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestPrice {

    public static Map<Character, Item> getRules (){
        Map<Character, Item> Rules = new HashMap<>();

        char item1 = 'A';
        QuantityPrice qp1 = new QuantityPrice(1, .5);
        QuantityPrice qp2 = new QuantityPrice(3, 1.3);
        List<QuantityPrice> qpList1 = new ArrayList<>();
        qpList1.add(qp1);
        qpList1.add(qp2);
        Item i1 = new Item(item1, qpList1);

        char item2 = 'B';
        QuantityPrice qp21 = new QuantityPrice(1, .3);
        QuantityPrice qp22 = new QuantityPrice(2, .45);
        List<QuantityPrice> qpList2 = new ArrayList<>();
        qpList2.add(qp21);
        qpList2.add(qp22);
        Item i2 = new Item(item2, qpList2);


        char item3 = 'C';
        QuantityPrice qp31 = new QuantityPrice(1, .2);
        List<QuantityPrice> qpList3 = new ArrayList<>();
        qpList3.add(qp31);
        Item i3 = new Item(item3, qpList3);


        char item4 = 'D';
        QuantityPrice qp41 = new QuantityPrice(1, .15);
        List<QuantityPrice> qpList4 = new ArrayList<>();
        qpList4.add(qp41);
        Item i4 = new Item(item4, qpList4);


        Rules.put(item1, i1);
        Rules.put(item2, i2);
        Rules.put(item3, i3);
        Rules.put(item4, i4);
        return Rules;
    }

    public double price(String goods) {
        Map<Character, Item> testRules = getRules();


        char item1 = 'A';
        QuantityPrice qp1 = new QuantityPrice(1, .5);
        QuantityPrice qp2 = new QuantityPrice(3, 1.3);
        List<QuantityPrice> qpList1 = new ArrayList<>();
        qpList1.add(qp1);
        qpList1.add(qp2);
        Item i1 = new Item(item1, qpList1);

        char item2 = 'B';
        QuantityPrice qp21 = new QuantityPrice(1, .3);
        QuantityPrice qp22 = new QuantityPrice(2, .45);
        List<QuantityPrice> qpList2 = new ArrayList<>();
        qpList2.add(qp21);
        qpList2.add(qp22);
        Item i2 = new Item(item2, qpList2);


        char item3 = 'C';
        QuantityPrice qp31 = new QuantityPrice(1, .2);
        List<QuantityPrice> qpList3 = new ArrayList<>();
        qpList3.add(qp31);
        Item i3 = new Item(item3, qpList3);


        char item4 = 'D';
        QuantityPrice qp41 = new QuantityPrice(1, .15);
        List<QuantityPrice> qpList4 = new ArrayList<>();
        qpList4.add(qp41);
        Item i4 = new Item(item4, qpList4);

        testRules.put(item1, i1);
        testRules.put(item2, i2);
        testRules.put(item3, i3);
        testRules.put(item4, i4);

        Checkout co = new Checkout(testRules);
        for (int i = 0; i < goods.length(); i++) {
            char A = goods.charAt(i);
            co.scan(goods.charAt(i));
        }

        return co.getTotal();
    }


    @org.junit.jupiter.api.Test
    void testTotals() {
        Assertions.assertEquals(0, price(""));
        Assertions.assertEquals(.50, price("A"));
        Assertions.assertEquals(.80, price("AB"));
        Assertions.assertEquals(1.15, price("CDBA"));

        Assertions.assertEquals(1.00, price("AA"));
        Assertions.assertEquals(1.30, price("AAA"));
        Assertions.assertEquals(1.80, price("AAAA"));
        Assertions.assertEquals(2.30, price("AAAAA"));
        Assertions.assertEquals(2.60, price("AAAAAA"));

        Assertions.assertEquals(1.60, price("AAAB"));
        Assertions.assertEquals(1.75, price("AAABB"));
        Assertions.assertEquals(1.90, price("AAABBD"));
        Assertions.assertEquals(1.90, price("DABABA"));
    }

    @org.junit.jupiter.api.Test
    void testIncremental() {
        Map<Character, Item> testRules = getRules();
        Checkout co = new Checkout(testRules);
        Assertions.assertEquals(0, co.getTotal());
        co.scan('A');
        Assertions.assertEquals(.50, co.getTotal());
        co.scan('B');
        Assertions.assertEquals(.80, co.getTotal());
        co.scan('A');
        Assertions.assertEquals(1.30, co.getTotal());
        co.scan('A');
        Assertions.assertEquals(1.60, co.getTotal());
        co.scan('B');
        Assertions.assertEquals(1.75, co.getTotal());
    }
}
