package com.job4j.tracker;

import java.util.function.Consumer;

public class DeleteAction implements UserAction {
    private final Consumer<String> out;

    public DeleteAction(Consumer<String> out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Delete item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter id : ");
        if (tracker.delete(id)) {
            out.accept("Item with " + id + "== is succeed deleted !");
        } else {
            out.accept("Item with ==" + id + "== NOT deleted,  enter corrected id!");
        }
        return true;
    }
}
