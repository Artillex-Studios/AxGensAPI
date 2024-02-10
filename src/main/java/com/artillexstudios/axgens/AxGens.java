package com.artillexstudios.axgens;

import com.artillexstudios.axapi.AxPlugin;
import com.artillexstudios.axapi.config.Config;
import com.artillexstudios.axapi.data.ThreadedQueue;
import com.artillexstudios.axapi.utils.MessageUtils;
import com.artillexstudios.axgens.database.Database;

public final class AxGens extends AxPlugin {
    public static Config CONFIG;
    public static Config EVENTS;
    public static Config GUIS;
    public static Config HOOKS;
    public static Config MESSAGES;
    public static Config SELLWANDS;
    public static Config TIERS;
    public static MessageUtils MESSAGEUTILS;
    private static AxPlugin instance;
    private static ThreadedQueue<Runnable> threadedQueue;
    private static Database database;

    public static ThreadedQueue<Runnable> getThreadedQueue() {
        return threadedQueue;
    }

    public static Database getDatabase() {
        return database;
    }

    public static AxPlugin getInstance() {
        return instance;
    }

    public void load() {
    }

    public void enable() {
    }

    public void disable() {
    }
}
