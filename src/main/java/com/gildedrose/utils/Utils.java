package com.gildedrose.utils;

import com.gildedrose.Item;

public class Utils {
    public static int increase(Item item, int amount, int max) {
        return Math.min(item.quality + amount, max);
    }

    public static int decrease(Item item, int amount, int min) {
        return Math.max(item.quality - amount, min);
    }
}
