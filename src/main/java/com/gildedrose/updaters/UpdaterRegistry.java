package com.gildedrose.updaters;

public class UpdaterRegistry {
    public static void registerUpdaters(ItemUpdaterFactory factory) {
        factory.register("Aged Brie", AgedBrieUpdater::new);
        factory.register("Backstage passes to a TAFKAL80ETC concert", BackstagePassUpdater::new);
        factory.register("Sulfuras, Hand of Ragnaros", SulfurasUpdater::new);
        factory.register("Conjured Mana Cake", ConjuredUpdater::new);
    }
}
