/*
Author: Mahmoud Abdellatif
Date 11/09/2021
Purpose: Implementing checkout system that handles pricing schemes.
 */

package com.mahmoud.gapdemo;
import com.mahmoud.gap.Item;
import com.mahmoud.gap.QuantityPrice;
import org.junit.jupiter.api.Assertions;
import java.util.ArrayList;
import java.util.List;

public class TestItem {

    @org.junit.jupiter.api.Test
    void testItemScanned() {
        char item1 = 'A';
        QuantityPrice qp1 = new QuantityPrice(1, .5);
        QuantityPrice qp2 = new QuantityPrice(3, 1.3);
        List<QuantityPrice> qpList = new ArrayList<>();
        qpList.add(qp1);
        qpList.add(qp2);
        Item i1 = new Item(item1, qpList);
        Assertions.assertEquals(0.5, i1.itemScan());
        Assertions.assertEquals(1, i1.itemScan());
        Assertions.assertEquals(1.3, i1.itemScan());
        Assertions.assertEquals(1.8, i1.itemScan());
        Assertions.assertEquals(2.3, i1.itemScan());
        Assertions.assertEquals(2.6, i1.itemScan());


    }
}
