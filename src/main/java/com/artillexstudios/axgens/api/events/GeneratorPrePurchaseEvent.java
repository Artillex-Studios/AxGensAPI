package com.artillexstudios.axgens.api.events;

import com.artillexstudios.axgens.tiers.Tier;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class GeneratorPrePurchaseEvent extends Event implements Cancellable {
    private static final HandlerList handlerList = new HandlerList();
    private final Player player;
    private final Tier tier;
    private double price;
    private long levelNeeded;
    private boolean isCancelled = false;

    public GeneratorPrePurchaseEvent(Player player, Tier tier, double price, long levelNeeded) {
        this.player = player;
        this.tier = tier;
        this.price = price;
        this.levelNeeded = levelNeeded;
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
    public Player getPlayer() {
        return player;
    }

    @NotNull
    public Tier getTier() {
        return tier;
    }

    public double getPrice() {
        return price;
    }

    public long getLevelNeeded() {
        return levelNeeded;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setLevelNeeded(long levelNeeded) {
        this.levelNeeded = levelNeeded;
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
