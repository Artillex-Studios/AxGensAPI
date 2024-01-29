package com.artillexstudios.axgens.api.events;

import com.artillexstudios.axgens.generators.Generator;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerInteractEvent;
import org.jetbrains.annotations.NotNull;

public class GeneratorInteractEvent extends Event implements Cancellable {
    private static final HandlerList handlerList = new HandlerList();
    private final Player player;
    private final Generator generator;
    private final PlayerInteractEvent playerInteractEvent;
    private boolean isCancelled = false;

    public GeneratorInteractEvent(@NotNull Player player, Generator generator, @NotNull PlayerInteractEvent playerInteractEvent) {
        super(!Bukkit.isPrimaryThread());

        this.player = player;
        this.generator = generator;
        this.playerInteractEvent = playerInteractEvent;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @NotNull
    public Generator getGenerator() {
        return generator;
    }

    @NotNull
    public PlayerInteractEvent getPlayerInteractEvent() {
        return playerInteractEvent;
    }

    @NotNull
    public Player getPlayer() {
        return player;
    }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean isCancelled) {
        this.isCancelled = isCancelled;
    }
}
