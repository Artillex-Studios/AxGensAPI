package com.artillexstudios.axgens.events;

import com.artillexstudios.axapi.utils.BossBar;
import org.bukkit.entity.Player;

public abstract class Event {
    private boolean running = false;
    private final EventConfig config;
    public long endTime;
    public long startTime;
    protected BossBar bossBar;

    public Event(EventConfig config) {
        this.config = config;
    }

    protected void start() {
    }

    public void onStart() {}

    public void apply(Player player) {
    }

    public void unApply(Player player) {
    }

    public void onCancel() {
    }

    public void tick() {}

    protected void cancel() {
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
