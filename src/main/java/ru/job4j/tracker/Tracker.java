package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        size++;
        items.add(item);
        return item;
    }

    public List<Item> findAll() {
        return List.copyOf(items.subList(0, size));
    }

    public List<Item> findByName(String key) {
        List<Item> find = new ArrayList<>();
        int temp = 0;
        for (Item element: items) {
            if (element.getName().equals(key)) {
                find.add(element);
                temp++;
            }
        }
        return List.copyOf(find.subList(0, temp));
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            item.setId(id);
            items.get(index).setName(item.getName());
        }
        return result;
    }

    public void delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            items.remove(index);
            size--;
        }
    }

    private int indexOf(int id) {
        int result = -1;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
                result = i;
                break;
            }
        }
        return result;
    }
}