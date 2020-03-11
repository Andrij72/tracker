package com.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter id : ");
        String name = input.askStr("Enter name : ");
        Item bug = new Item(name);
        if (tracker.replace(id, bug)) {
            System.out.println("Item with is succeed updated with new name:  " + name + " !");
        } else {
            System.out.println("Item ==" + name + " | " + id + "== NOT updated , enter corrected id!");
        }
        return true;
    }
}
