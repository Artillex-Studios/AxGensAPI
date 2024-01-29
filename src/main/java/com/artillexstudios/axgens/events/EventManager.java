package com.artillexstudios.axgens.events;

import net.kyori.adventure.bossbar.BossBar;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

import static com.artillexstudios.axgens.AxGens.CONFIG;

public class EventManager {
    private static String currentEvent = "---";
    private static String lastEvent = null;
    private static BossBar bossBar = null;
    private static String boostMsg;
    private static long startTime;
    private static long endTime;
    private static double priceMultipier = 1.0D;
    private static int extraDrop = 0;
    private static int extraTiers = 0;
    private static double speedMultiplier = 1.0D;

    public static boolean startEvent(@Nullable String eventType) {
        return true;
    }

    public static boolean endEvent(boolean force) {
        return true;
    }

    @NotNull
    public static String getCurrentEvent() {
        return currentEvent;
    }

    @Nullable
    public static BossBar getBossBar() {
        return bossBar;
    }

    public static double getPriceMultipier() {
        return priceMultipier;
    }

    public static double getSpeedMultiplier() {
        return speedMultiplier;
    }

    public static int getExtraDrop() {
        return extraDrop;
    }

    public static int getExtraTiers() {
        return extraTiers;
    }

    public static String[] getEvents() {
        final ArrayList<String> events = new ArrayList<>();
        if (CONFIG.getBoolean("events.sell-event.enabled")) events.add("sell-event");
        if (CONFIG.getBoolean("events.drop-event.enabled")) events.add("drop-event");
        if (CONFIG.getBoolean("events.upgrade-event.enabled")) events.add("upgrade-event");
        if (CONFIG.getBoolean("events.speed-event.enabled")) events.add("speed-event");

        final String[] ar = new String[events.size()];
        events.toArray(ar);
        return ar;
    }
}
