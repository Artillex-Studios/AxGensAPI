package com.artillexstudios.axgens.tiers;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;

public class Tier {
    private int tier;
    private double price;
    private long levelNeeded;
    private int speed;
    private ItemStack genItem;
    private HashMap<ItemStack, Double> dropItems;
    private ItemStack firstDropItem;
    private boolean holoEnabled;
    private double hologramHeight;
    private List<String> holoLines;
    private boolean hideFromShop;

    public Tier(int tier, double price, long levelNeeded, int speed, @NotNull ItemStack genItem, @NotNull HashMap<ItemStack, Double> dropItems, boolean holoEnabled, double hologramHeight, @NotNull List<String> holoLines, boolean hideFromShop) {
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
    @Deprecated(forRemoval = true)
    public ItemStack getDropItem() {
        return getFirstDropItem();
    }

    @NotNull
    public ItemStack getFirstDropItem() {
        return firstDropItem;
    }

    @NotNull
    public HashMap<ItemStack, Double> getDropItems() {
        return dropItems;
    }

    @NotNull
    public ItemStack getRandomDropItem() {
        return null;
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
