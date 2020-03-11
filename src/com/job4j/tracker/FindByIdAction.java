package com.job4j.tracker;

import java.util.function.Consumer;

public class FindByIdAction implements UserAction {
    private final Consumer<String> output;

    public FindByIdAction(Consumer<String> output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "=== Find item by Id ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter Id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            output.accept(String.format("=== Find item  is: // %s //====", item.getName()));
        } else {
            output.accept("Item with Id " + id + " is't found");
        }
        return true;
    }
}
