package com.artillexstudios.axgens.tiers;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Tier {
    private final int tier;
    private final double price;
    private final long levelNeeded;
    private final int speed;
    private final ItemStack genItem;
    private final ItemStack dropItem;
    private final boolean holoEnabled;
    private final double hologramHeight;
    private final List<String> holoLines;
    private final boolean hideFromShop;

    public Tier(int tier, double price, long levelNeeded, int speed, @NotNull ItemStack genItem, @NotNull ItemStack dropItem, boolean holoEnabled, double hologramHeight, @NotNull List<String> holoLines, boolean hideFromShop) {
        this.tier = tier;
        this.price = price;
        this.levelNeeded = levelNeeded;
        this.speed = speed;
        this.genItem = genItem;
        this.dropItem = dropItem;
        this.holoEnabled = holoEnabled;
        this.hologramHeight = hologramHeight;
        this.holoLines = holoLines;
        this.hideFromShop = hideFromShop;
    }

    public int getTier() {
        return tier;
    }

    public double getPrice() {
        return price;
    }

    public long getLevelNeeded() {
        return levelNeeded;
    }

    public int getSpeed() {
        return speed;
    }

    @NotNull
    public ItemStack getDropItem() {
        return dropItem.clone();
    }

    @NotNull
    public ItemStack getGenItem() {
        return genItem.clone();
    }

    public boolean isHoloEnabled() {
        return holoEnabled;
    }

    public double getHologramHeight() {
        return hologramHeight;
    }

    public boolean isHiddenFromShop() {
        return hideFromShop;
    }

    @NotNull
    public List<String> getHoloLines() {
        return holoLines;
    }
}
