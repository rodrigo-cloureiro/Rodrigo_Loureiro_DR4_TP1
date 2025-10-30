package com.gildedrose.updaters;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ItemUpdaterFactory {
    private final Map<String, Supplier<ItemUpdater>> registry = new HashMap<>();

    public void register(String itemName, Supplier<ItemUpdater> supplier) {
        registry.put(itemName, supplier);
    }

    public ItemUpdater create(String itemName) {
        return registry.getOrDefault(itemName, DefaultUpdater::new).get();
    }
}
