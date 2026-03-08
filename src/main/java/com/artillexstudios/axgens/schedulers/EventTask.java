package com.artillexstudios.axgens.schedulers;

public class EventTask {
    private static long lastEvent = System.currentTimeMillis();
    private static long nextEvent = 0;

    public static void start() {
    }

    public static void stop() {
    }

    public static long getLastEvent() {
        return lastEvent;
    }

    public static long getNextEvent() {
        return nextEvent;
    }
}
