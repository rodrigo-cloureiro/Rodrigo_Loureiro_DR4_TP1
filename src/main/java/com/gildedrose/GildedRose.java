package com.gildedrose;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                continue;
            }

            item.sellIn -= 1;

            if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                handleBackstagePasses(item);
            } else if (item.name.equals("Aged Brie")) {
                handleAgedBrie(item);
            } else {
                handleNormalItems(item);
            }
        }
    }

    private void handleAgedBrie(Item agedBrie) {
        if (agedBrie.sellIn < 0) {
            agedBrie.quality = Math.min(agedBrie.quality + 2, 50);
        } else {
            agedBrie.quality = Math.min(agedBrie.quality + 1, 50);
        }
    }

    private void handleSulfuras(Item sulfuras) {
        // Não sofrem alterações
    }

    private void handleBackstagePasses(Item backstagePasses) {
        if (backstagePasses.sellIn < 0) {
            backstagePasses.quality = 0;
        } else if (backstagePasses.sellIn < 6) {
            backstagePasses.quality = Math.min(backstagePasses.quality + 3, 50);
        } else if (backstagePasses.sellIn < 11) {
            backstagePasses.quality = Math.min(backstagePasses.quality + 2, 50);
        } else {
            backstagePasses.quality = Math.min(backstagePasses.quality + 1, 50);
        }
    }

    private void handleNormalItems(Item item) {
        if (item.sellIn < 0) {
            item.quality = Math.max(item.quality - 2, 0);
        } else {
            item.quality = Math.max(item.quality - 1, 0);
        }
    }
}
