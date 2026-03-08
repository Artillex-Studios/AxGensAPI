package com.artillexstudios.axgens.events;

import com.google.common.collect.MutableClassToInstanceMap;

public final class Events {
    private static final MutableClassToInstanceMap<Event> events = MutableClassToInstanceMap.create();
    private static Event running;

    public static void register(Event event) {
    }

    public static boolean startRandom() {
        return true;
    }

    public static boolean start(Event event) {
        return true;
    }

    public static void tickRunning() {
    }

    public static boolean cancel() {
        return true;
    }

    public static void reload() {
    }

    public static <T extends Event> T getEvent(Class<T> eventClass) {
        return (T) events.get(eventClass);
    }

    public static <T extends Event> T getRunning() {
        return (T) running;
    }

    public static boolean isRunning(Class<? extends Event> eventClass) {
        return getEvent(eventClass).isRunning();
    }

    public static MutableClassToInstanceMap<Event> getEvents() {
        return events;
    }
}
