package com.artillexstudios.axgens.api.events;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class UserLevelChangeEvent extends Event {
    private static final HandlerList handlerList = new HandlerList();
    private final OfflinePlayer player;
    private final long oldLevel;
    private final long newLevel;

    public UserLevelChangeEvent(@NotNull OfflinePlayer player, long oldLevel, long newLevel) {
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

    public OfflinePlayer getOfflinePlayer() {
        return player;
    }

    @Nullable
    @Deprecated(forRemoval = true)
    public Player getPlayer() {
        return player.getPlayer();
    }

    public long getOldLevel() {
        return oldLevel;
    }

    public long getNewLevel() {
        return newLevel;
    }
}
