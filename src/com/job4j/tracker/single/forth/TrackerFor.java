package com.job4j.tracker.single.forth;

public class TrackerFor {

    private TrackerFor() {
    }

    public static TrackerFor getInstance() {
        return Holder.INSTANCE;
    }

    public static final class Holder {
        private static final TrackerFor INSTANCE = new TrackerFor();
    }
}
