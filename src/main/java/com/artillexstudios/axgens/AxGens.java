package com.artillexstudios.axgens;

import com.artillexstudios.axapi.AxPlugin;
import com.artillexstudios.axapi.config.Config;
import com.artillexstudios.axapi.dependencies.DependencyManagerWrapper;
import com.artillexstudios.axapi.executor.ThreadedQueue;
import com.artillexstudios.axapi.utils.MessageUtils;
import com.artillexstudios.axgens.database.Database;

public final class AxGens extends AxPlugin {
    public AxGens() {
    }

    public static Config CONFIG;
    public static Config EVENTS;
    public static Config GUIS;
    public static Config HOOKS;
    public static Config MESSAGES;
    public static Config SELLWANDS;
    public static Config TIERS;
    public static MessageUtils MESSAGEUTILS;

    public static ThreadedQueue<Runnable> getThreadedQueue() {
        return null;
    }

    public static Database getDatabase() {
        return null;
    }

    public static AxPlugin getInstance() {
        return null;
    }

    @Override
    public void dependencies(DependencyManagerWrapper manager) {
    }

    public void enable() {
    }

    public void disable() {
    }

    public void updateFlags() {
    }

    public void reload() {
    }
}
