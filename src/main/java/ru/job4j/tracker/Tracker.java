package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        int size = 0;
        Item[] r_items = new Item[items.length];
        for (int index = 0; index < items.length; index++) {
            if (items[index].getName() != null) {
                r_items[size++] = items[index];
            }
        }
        return Arrays.copyOf(r_items, size);
    }

    public Item[] findByName(String key) {
        int size = 0;
        Item[] r_items = new Item[items.length];
        for (int index = 0; index < items.length; index++) {
            if (items[index].getName().equals(key)) {
                r_items[size++] = items[index];
            }
        }
        return Arrays.copyOf(r_items, size);
    }
}