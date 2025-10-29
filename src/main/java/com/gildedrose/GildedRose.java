package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!item.name.equals("Aged Brie")
                    && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.quality > 0) {
                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        item.quality = item.quality - 1;
                    }
                }
            } else {
                if (item.quality < 50) {
                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        handleBackstagePasses(item);
                    } else {
                        handleAgedBrie(item);
                    }
                }
            }

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals("Aged Brie")) {
                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.quality > 0) {
                            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
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
        backstagePasses.quality += 1;

        if (backstagePasses.sellIn < 11) {
            if (backstagePasses.quality < 50) {
                backstagePasses.quality += 1;
            }
        }

        if (backstagePasses.sellIn < 6) {
            if (backstagePasses.quality < 50) {
                backstagePasses.quality += 1;
            }
        }
    }
}
