package com.artillexstudios.axgens.tiers;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;

public class Tiers {
    private static final HashMap<Integer, Tier> tierMap = new HashMap<>();
    private static final HashMap<ItemStack, Double> priceMap = new HashMap<>();

    @NotNull
    public static HashMap<Integer, Tier> getTierMap() {
        return tierMap;
    }

    @NotNull
    public static HashMap<ItemStack, Double> getPriceMap() {
        return priceMap;
    }

    @Nullable
    public static Tier getTier(int tier) {
        if (!tierMap.containsKey(tier)) return null;
        return tierMap.get(tier);
    }

    @NotNull
    public static Tier getTierNotNull(int tier) {
        while (!tierMap.containsKey(tier)) {
            tier--;
            if (tier < 0) throw new RuntimeException("No tiers have been set");
        }
        return tierMap.get(tier);
    }

    public static void refreshTiers() {
    }
}
