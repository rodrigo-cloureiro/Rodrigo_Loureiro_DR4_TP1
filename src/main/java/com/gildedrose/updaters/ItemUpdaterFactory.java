package com.gildedrose.updaters;

import com.gildedrose.Item;

public class ItemUpdaterFactory {
    public static ItemUpdater create(Item item) {
        return switch (item.name) {
            case "Aged Brie" -> new AgedBrieUpdater();
            case "Backstage passes to a TAFKAL80ETC concert" -> new BackstagePassUpdater();
            case "Sulfuras, Hand of Ragnaros" -> new SulfurasUpdater();
            default -> new DefaultUpdater();
        };
    }
}
