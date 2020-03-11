package com.job4j.tracker.single.first;

public class TrackerOne {
    private static TrackerOne instance;

    private TrackerOne() {
    }

    public static TrackerOne getInstance() {
        if (instance == null) {
            instance = new TrackerOne();
        }
        return instance;
    }
}
