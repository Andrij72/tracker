package com.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    private final List<Item> items = new ArrayList<>(100);

    /**
     * Метод реализующий добавление заявки в хранилище
     *
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     *
     * @return Уникальный ключ.
     */
    private String generateId() {
        Random rm = new Random();
        return String.valueOf(Math.abs(System.currentTimeMillis() + rm.nextLong()));
    }

    public List<Item> findByName(String key) {
        List<Item> arr = new ArrayList<>();
        int i = 0;
        for (Item item : items) {
            if (item.getName().equals(key)) {
                arr.add(item);
            }
        }
        return arr;
    }

    public Item findById(String id) {
        Item rs = null;
        int indexOf = getIndexOf(id);
        if (indexOf != -1) {
            rs = items.get(indexOf);
        }
        return rs;
    }

    public List<Item> findAll() {
        List<Item> arr = new ArrayList<>();
        for (Item item : items) {
            arr.add(item);
        }
        return arr;
    }

    public boolean delete(String id) {
        boolean rslt = false;
        int index = getIndexOf(id);
        if (index != -1) {
            items.remove(index);
            rslt = true;
        }
        return rslt;
    }

    public boolean replace(String id, Item item) {
        boolean rs = false;
        int indexOf = getIndexOf(id);
        if (indexOf != -1) {
            item.setId(id);
            items.set(indexOf, item);
            rs = true;
        }
        return rs;
    }

    public int getIndexOf(String id) {
        int index = 0;
        int rsl = -1;
        for (Item item : items) {
            if (item.getId().equals(id)) {
                rsl = index;
                break;
            }
            index++;
        }
        return rsl;
    }
}
