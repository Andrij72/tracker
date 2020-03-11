package com.job4j.tracker.single.third;

public class TrackerThree {
    private static final TrackerThree INSTANCE_TRACKER = new TrackerThree();

    private TrackerThree() {
    }

    public static TrackerThree getInstance() {
        return INSTANCE_TRACKER;
    }
}
