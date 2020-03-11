package com.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class StartUI {
    private final Input input;
    private final Tracker tracker;
    private final Consumer<String> output;

    public StartUI(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker, output);
    }

    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Select: ", actions.size());
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    public void showMenu(List<UserAction> actions) {
        System.out.println("Menu.");
        for (UserAction action : actions) {
            output.accept(actions.indexOf(action) + ". " + action.name());
        }
    }

    public static void main(String[] args) {
        Input validate = new ValidateInput(new ConsoleInput());
        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(System.out::println));
        actions.add(new FindAllAction(System.out::println));
        actions.add(new ReplaceAction());
        actions.add(new DeleteAction(System.out::println));
        actions.add(new FindByIdAction(System.out::println));
        actions.add(new FindByNameAction());
        actions.add(new CloseAction(System.out::println));
        new StartUI(validate, tracker, System.out::println).init(validate, tracker, actions);
        }
        }
