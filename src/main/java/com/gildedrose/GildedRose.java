package com.gildedrose;

import com.gildedrose.updaters.ItemUpdater;
import com.gildedrose.updaters.ItemUpdaterFactory;

public class GildedRose {
    private final Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemUpdater updater = ItemUpdaterFactory.create(item);
            updater.update(item);
        }
    }
}
