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

    public Item[] findAll() {
        Item[] all = new Item[size];
        int temp = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].getName() != null) {
                all[temp] = items[i];
                temp++;
            }
        }
        all = Arrays.copyOf(all, temp);
        return all;
    }

    public Item[] findByName(String key) {
        Item[] find = new Item[size];
        int temp = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(key)) {
                find[temp] = items[i];
                temp++;
            }
        }
        find = Arrays.copyOf(find, temp);
        return find;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean changed = false;
        if (index != -1) {
            items[index].setName(item.getName());
            changed = true;
        }
        return changed;
    }

    private int indexOf(int id) {
        int result = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                result = index;
                break;
            }
        }
        return result;
    }
}