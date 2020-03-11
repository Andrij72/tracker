package com.job4j.tracker;

import java.util.List;
import java.util.function.Consumer;

public class FindAllAction implements UserAction {
    private final Consumer<String> output;

    public FindAllAction(Consumer<String> output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "=== Show all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        List<Item> items = tracker.findAll();
        if (items.size() != 0) {
            for (Item item : items) {
                output.accept(String.format("Your keep item:  {%s|%s}%n", item.getName(), item.getId()));
            }
        }
        return true;
    }
}
