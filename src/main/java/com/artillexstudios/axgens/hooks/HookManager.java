package com.artillexstudios.axgens.hooks;

import com.artillexstudios.axgens.hooks.impl.currency.CurrencyHook;
import com.artillexstudios.axgens.hooks.impl.level.LevelsHook;
import com.artillexstudios.axgens.hooks.impl.protection.ProtectionHook;
import com.artillexstudios.axgens.hooks.impl.shop.PricesHook;
import com.artillexstudios.axgens.hooks.impl.team.TeamHook;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class HookManager {
    private static final HashSet<ProtectionHook> PROTECTION_HOOKS = new HashSet<>();
    private static CurrencyHook currency = null;
    private static final List<PricesHook> shopPrices = new ArrayList<>();
    private static LevelsHook levels = null;
    private static TeamHook teams = null;

    public void setupHooks() {
        updateHooks();
    }

    public void updateHooks() {
    }

    @SuppressWarnings("unused")
    public static void registerProtectionHook(@NotNull Plugin plugin, @NotNull ProtectionHook protectionHook) {
    }

    @SuppressWarnings("unused")
    public static void registerPriceProviderHook(@NotNull Plugin plugin, @NotNull PricesHook pricesHook) {
    }

    @SuppressWarnings("unused")
    public static void registerCurrencyHook(@NotNull Plugin plugin, @NotNull CurrencyHook currencyHook) {
    }

    @SuppressWarnings("unused")
    public static void registerLevelHook(@NotNull Plugin plugin, @NotNull LevelsHook levelHook) {
    }

    @SuppressWarnings("unused")
    public static void registerTeamHook(@NotNull Plugin plugin, @NotNull TeamHook teamHook) {
    }

    @Nullable
    public static CurrencyHook getCurrency() {
        return currency;
    }

    @NotNull
    public static List<PricesHook> getShopPrices() {
        return shopPrices;
    }

    public static double getPrice(ItemStack it) {
        return getPrice(null, it);
    }

    public static double getPrice(@Nullable Player player, ItemStack it) {
        return -1D;
    }

    @Nullable
    public static LevelsHook getLevels() {
        return levels;
    }

    @Nullable
    public static TeamHook getTeams() {
        return teams;
    }

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    public static boolean canBuildAt(@NotNull Player player, @NotNull Location location) {
        for (ProtectionHook pm : PROTECTION_HOOKS) {
            if (!pm.canPlayerBuildAt(player, location)) return false;
        }

        return true;
    }
}
