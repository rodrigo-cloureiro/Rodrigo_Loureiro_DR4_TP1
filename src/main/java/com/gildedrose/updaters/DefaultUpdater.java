package com.gildedrose.updaters;

import com.gildedrose.Item;

import static com.gildedrose.utils.Utils.*;

public class DefaultUpdater implements ItemUpdater {
    @Override
    public void update(Item item) {
        item.sellIn --;

        if (item.sellIn < 0) {
            item.quality = decrease(item, 2, 0);
        } else {
            item.quality = decrease(item, 1, 0);
        }
    }
}
