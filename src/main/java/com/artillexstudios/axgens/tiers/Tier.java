package com.artillexstudios.axgens.tiers;

import com.artillexstudios.axgens.utils.DropItem;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;

public class Tier {

    public Tier(int tier, double price, long levelNeeded, int speed, @NotNull ItemStack genItem, @NotNull HashMap<ItemStack, Double> dropItems, boolean holoEnabled, double hologramHeight, @NotNull List<String> holoLines, boolean hideFromShop, boolean buyable) {

    }

    public int getTier() {
        return -1;
    }

    public double getPrice() {
        return -1;
    }

    public long getLevelNeeded() {
        return -1;
    }

    public int getSpeed() {
        return -1;
    }

    @NotNull
    public ItemStack getFirstDropItem() {
        return null;
    }

    @NotNull
    public HashMap<ItemStack, Double> getDropItems() {
        return null;
    }

    @NotNull
    public HashMap<DropItem, Double> getCachedDropItems() {
        return null;
    }

    @NotNull
    public ItemStack getRandomDropItem() {
        return null;
    }

    @NotNull
    public ItemStack getGenItem() {
        return null;
    }

    public boolean isHoloEnabled() {
        return false;
    }

    public double getHologramHeight() {
        return -1;
    }

    public boolean isHiddenFromShop() {
        return false;
    }

    public boolean isBuyable() {
        return false;
    }

    @NotNull
    public List<String> getHoloLines() {
        return null;
    }

    public double getUpgradePrice() {
        return -1;
    }

    public double getRepairPrice() {
        return -1;
    }
}
