package com.artillexstudios.axgens.api;

import com.artillexstudios.axgens.generators.Generator;
import com.artillexstudios.axgens.hooks.HookManager;
import com.artillexstudios.axgens.hooks.impl.currency.CurrencyHook;
import com.artillexstudios.axgens.hooks.impl.level.LevelsHook;
import com.artillexstudios.axgens.hooks.impl.shop.PricesHook;
import com.artillexstudios.axgens.hooks.impl.team.TeamHook;
import com.artillexstudios.axgens.tiers.Tier;
import org.bukkit.OfflinePlayer;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class AxGensAPI {

    public static int getPlayerGeneratorLimit(@NotNull OfflinePlayer player) {
        return 0;
    }

    public static float getPlayerMultiplier(@NotNull OfflinePlayer player) {
        return 1f;
    }

    public static int getGeneratorLimit(@NotNull Player player) {
        return 0;
    }

    public static int getPlayerGeneratorPlacedAmount(@NotNull UUID uuid) {
        return 0;
    }

    public static int getGeneratorPlacedAmount(@NotNull UUID uuid) {
        return 0;
    }

    public static long getLevel(@NotNull UUID uuid) {
        return 0;
    }

    public static void placeGenerator(@NotNull Player player, Block block, Tier tier, @Nullable ItemStack item, boolean corrupted, boolean force) {

    }

    public static void damageBlock(@NotNull Block block) {
        // used for break mode, do not remove the block when using this
    }

    public static void damageBlock(@NotNull Generator generator) {
        // used for break mode, do not remove the block when using this
    }

    @Nullable
    public static CurrencyHook getCurrency() {
        return HookManager.getCurrency();
    }

    @NotNull
    public static List<PricesHook> getShopPrices() {
        return null;
    }

    public static double getPrice(ItemStack it) {
        return -1D;
    }

    public static double getPrice(@Nullable Player player, ItemStack it) {
        return -1D;
    }

    @Nullable
    public static LevelsHook getLevels() {
        return HookManager.getLevels();
    }

    @Nullable
    public static TeamHook getTeams() {
        return HookManager.getTeams();
    }
}
