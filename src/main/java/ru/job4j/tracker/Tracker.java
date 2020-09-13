package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        /* Находим индекс */
        int index = indexOf(id);
        /* Если индекс найден возвращаем item, иначе null */
        return index != -1 ? items[index] : null;
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

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            items[index].setName(item.getName());
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            int start = index + 1;
            int distPos = index;
            int length = size - index;
                System.arraycopy(items, start, items, distPos, length);
                items[size - 1] = null;
                size--;
        }
        return index != -1;
    }
}