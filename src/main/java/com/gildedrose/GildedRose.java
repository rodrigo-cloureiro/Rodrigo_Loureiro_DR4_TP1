package com.gildedrose;

import com.gildedrose.updaters.ItemUpdater;
import com.gildedrose.updaters.ItemUpdaterFactory;

public class GildedRose {
    private final Item[] items;
    private final ItemUpdaterFactory factory;

    public GildedRose(Item[] items, ItemUpdaterFactory factory) {
        this.items = items;
        this.factory = factory;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemUpdater updater = factory.create(item.name);
            updater.update(item);
        }
    }
}
