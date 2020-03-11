package com.job4j.tracker;

import java.util.function.Consumer;

public class CreateAction implements UserAction {
    private final Consumer<String> output;

    public CreateAction(Consumer<String> output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "=== Create a new Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        output.accept("You succeed add item <<" + name + ">>");
        return true;
    }
}
