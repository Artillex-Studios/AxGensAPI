package com.artillexstudios.axgens.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public abstract class Event {
    private boolean running = false;
    private final EventConfig config;
    public long endTime;
    public long startTime;

    public Event(EventConfig config) {
        this.config = config;
    }

    protected void start() {
        setRunning(true);

        onStart();

        for (Player player : Bukkit.getOnlinePlayers()) {
            apply(player);
        }

    }

    public void onStart() {}

    public void apply(Player player) {}

    public void unApply(Player player) {}

    public void onCancel() {}

    public void tick() {}

    protected void cancel() {
        setRunning(false);

        for (Player player : Bukkit.getOnlinePlayers()) {
            unApply(player);
        }

        onCancel();
    }

    public boolean isRunning() {
        return running;
    }

    private void setRunning(boolean running) {
        this.running = running;
    }

    public EventConfig getConfig() {
        return config;
    }
}
