package com.artillexstudios.axgens.tiers;

import it.unimi.dsi.fastutil.ints.Int2ObjectLinkedOpenHashMap;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;

public class Tiers {
    private static final Int2ObjectLinkedOpenHashMap<Tier> tierMap = new Int2ObjectLinkedOpenHashMap<>();
    private static final HashMap<ItemStack, Double> priceMap = new HashMap<>();

    @NotNull
    public static Int2ObjectLinkedOpenHashMap<Tier> getTierMap() {
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
