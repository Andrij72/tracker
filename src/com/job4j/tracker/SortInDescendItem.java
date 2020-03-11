package com.job4j.tracker;

import java.util.Comparator;

public class SortInDescendItem implements Comparator<Item> {
        @Override
        public int compare(Item first, Item second) {
            return second.getName().compareTo(first.getName());
        }
    }