package com.artillexstudios.axgens.api.events;

import com.artillexstudios.axgens.generators.Generator;
import com.artillexstudios.axgens.tiers.Tier;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class GeneratorPreUpgradeEvent extends Event implements Cancellable {
    private static final HandlerList handlerList = new HandlerList();
    private final Player player;
    private final Generator generator;
    private final Tier currentTier;
    private final Tier upgradedTier;
    private double price;
    private long levelNeeded;
    private boolean isCancelled = false;

    public GeneratorPreUpgradeEvent(@NotNull Player player, Generator generator, Tier currentTier, Tier upgradedTier, double price, long levelNeeded) {
        super(!Bukkit.isPrimaryThread());

        this.player = player;
        this.generator = generator;
        this.currentTier = currentTier;
        this.upgradedTier = upgradedTier;
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
    public Generator getGenerator() {
        return generator;
    }

    @NotNull
    public Tier getCurrentTier() {
        return currentTier;
    }

    @NotNull
    public Tier getUpgradedTier() {
        return upgradedTier;
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

    public void setLevelNeeded(int levelNeeded) {
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
