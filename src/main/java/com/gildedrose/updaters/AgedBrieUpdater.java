package com.gildedrose.updaters;

import com.gildedrose.Item;

import static com.gildedrose.utils.Utils.*;

public class AgedBrieUpdater implements ItemUpdater {
    @Override
    public void update(Item item) {
        item.sellIn--;

        if (item.sellIn < 0) {
            item.quality = increase(item, 2, 50);
        } else {
            item.quality = increase(item, 1, 50);
        }
    }
}
