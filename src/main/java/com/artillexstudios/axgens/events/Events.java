package com.artillexstudios.axgens.events;

import com.artillexstudios.axapi.libs.boostedyaml.boostedyaml.block.implementation.Section;
import com.artillexstudios.axgens.AxGens;
import com.artillexstudios.axgens.events.impl.DropEvent;
import com.artillexstudios.axgens.events.impl.SellEvent;
import com.artillexstudios.axgens.events.impl.SpeedEvent;
import com.artillexstudios.axgens.events.impl.UpgradeEvent;
import com.google.common.collect.MutableClassToInstanceMap;

import java.util.concurrent.ThreadLocalRandom;

public final class Events {
    private static final MutableClassToInstanceMap<Event> events = MutableClassToInstanceMap.create();
    private static Event running;

    public static void register(Event event) {
        events.put(event.getClass(), event);
    }

    public static boolean startRandom() {
        Event[] events = Events.events.values().toArray(new Event[0]);
        if (events.length == 0)  return false;
        if (running != null) return false;

        Event toStart = events[ThreadLocalRandom.current().nextInt(events.length)];

        running = toStart;
        toStart.start();
        return true;
    }

    public static boolean start(Event event) {
        if (running != null) return false;

        running = event;
        event.start();
        return true;
    }

    public static void tickRunning() {
        Event running = getRunning();
        if (running == null) return;

        running.tick();

        if (System.currentTimeMillis() >= running.endTime) {
            cancel();
        }
    }

    public static boolean cancel() {
        Event running = getRunning();
        if (running == null) return false;

        Events.running = null;

        running.cancel();
        return true;
    }

    @SuppressWarnings("DataFlowIssue")
    public static void reload() {
        if (running != null) {
            running.cancel();
        }
        running = null;

        events.clear();
        for (String key : AxGens.EVENTS.getSection("events").getRoutesAsStrings(false)) {
            Section section = AxGens.EVENTS.getSection("events." + key);
            if (section == null) continue;
            EventConfig config = EventConfig.build(section);
            if (!config.enabled()) continue;
            
            String route = section.getRouteAsString();
            if (route.contains("sell-event")) {
                register(new SellEvent(config));
            } else if (route.contains("drop-event")) {
                register(new DropEvent(config));
            } else if (route.contains("upgrade-event")) {
                register(new UpgradeEvent(config));
            } else if (route.contains("speed-event")) {
                register(new SpeedEvent(config));
            }
        }

        // TODO: EventReloadEvent
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
