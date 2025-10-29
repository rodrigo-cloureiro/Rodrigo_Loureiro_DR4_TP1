package com.gildedrose.updaters;

import com.gildedrose.Item;

import static com.gildedrose.utils.Utils.*;

public class BackstagePassUpdater implements ItemUpdater {
    @Override
    public void update(Item item) {
        item.sellIn--;

        if (item.sellIn < 0) {
            item.quality = 0;
        } else if (item.sellIn < 6) {
            item.quality = increase(item, 3, 50);
        } else if (item.sellIn < 11) {
            item.quality = increase(item, 2, 50);
        } else {
            item.quality = increase(item, 1, 50);
        }
    }
}
