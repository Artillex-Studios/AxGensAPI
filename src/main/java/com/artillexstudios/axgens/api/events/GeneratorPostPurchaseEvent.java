package com.artillexstudios.axgens.api.events;

import com.artillexstudios.axgens.tiers.Tier;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class GeneratorPostPurchaseEvent extends Event {
    private static final HandlerList handlerList = new HandlerList();
    private final Player player;
    private final Tier tier;
    private final double price;
    private final long levelNeeded;

    public GeneratorPostPurchaseEvent(Player player, Tier tier, double price, long levelNeeded) {
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
}
