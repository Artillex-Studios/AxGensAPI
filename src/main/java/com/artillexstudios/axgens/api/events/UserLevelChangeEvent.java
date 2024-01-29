package com.artillexstudios.axgens.api.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class UserLevelChangeEvent extends Event {
    private static final HandlerList handlerList = new HandlerList();
    private final Player player;
    private final long oldLevel;
    private final long newLevel;

    public UserLevelChangeEvent(@NotNull Player player, long oldLevel, long newLevel) {
        super(!Bukkit.isPrimaryThread());

        this.player = player;
        this.oldLevel = oldLevel;
        this.newLevel = newLevel;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    public Player getPlayer() {
        return player;
    }

    public long getOldLevel() {
        return oldLevel;
    }

    public long getNewLevel() {
        return newLevel;
    }
}
