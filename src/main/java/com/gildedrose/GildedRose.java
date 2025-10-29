package com.gildedrose;

public class GildedRose {
    private final Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                // updateSulfuras(item); // Não sofrem alterações
                continue;
            }

            item.sellIn -= 1;

            switch (item.name) {
                case "Backstage passes to a TAFKAL80ETC concert":
                    updateBackstagePasses(item);
                    break;
                case "Aged Brie":
                    updateAgedBrie(item);
                    break;
                default:
                    updateNormalItems(item);
            }
        }
    }

    private void updateAgedBrie(Item agedBrie) {
        if (agedBrie.sellIn < 0) {
            agedBrie.quality = increase(agedBrie, 2, 50);
        } else {
            agedBrie.quality = increase(agedBrie, 1, 50);
        }
    }

    private void updateSulfuras(Item sulfuras) {
        // Não sofrem alterações
    }

    private void updateBackstagePasses(Item backstagePasses) {
        if (backstagePasses.sellIn < 0) {
            backstagePasses.quality = 0;
        } else if (backstagePasses.sellIn < 6) {
            backstagePasses.quality = increase(backstagePasses, 3, 50);
        } else if (backstagePasses.sellIn < 11) {
            backstagePasses.quality = increase(backstagePasses, 2, 50);
        } else {
            backstagePasses.quality = increase(backstagePasses, 1, 50);
        }
    }

    private void updateNormalItems(Item item) {
        if (item.sellIn < 0) {
            item.quality = decrease(item, 2, 0);
        } else {
            item.quality = decrease(item, 1, 0);
        }
    }

    private int increase(Item item, int amount, int min) {
        return Math.min(item.quality + amount, min);
    }

    private int decrease(Item item, int amount, int max) {
        return Math.max(item.quality - amount, max);
    }
}
