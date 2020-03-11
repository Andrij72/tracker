package com.job4j.tracker;

import java.util.function.Consumer;

public class CloseAction implements UserAction {
    private final Consumer<String> output;

    public CloseAction(Consumer<String> output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "=== Close program ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.accept("Program is closed !");
        return false;
    }
}
