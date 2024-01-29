package com.artillexstudios.axgens.hooks;

import com.artillexstudios.axgens.hooks.impl.currency.CurrencyHook;
import com.artillexstudios.axgens.hooks.impl.hologram.HologramHook;
import com.artillexstudios.axgens.hooks.impl.level.LevelsHook;
import com.artillexstudios.axgens.hooks.impl.protection.ProtectionHook;
import com.artillexstudios.axgens.hooks.impl.shop.PricesHook;
import com.artillexstudios.axgens.hooks.impl.team.TeamHook;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;

public class HookManager {
    private static CurrencyHook currency = null;
    private static PricesHook shopPrices = null;
    private static HologramHook holograms = null;
    private static LevelsHook levels = null;
    private static TeamHook teams = null;
    private static final HashSet<ProtectionHook> PROTECTION_HOOKS = new HashSet<>();

    public void setupHooks() {
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
    public static void registerHologramHook(@NotNull Plugin plugin, @NotNull HologramHook hologramHook) {
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

    @Nullable
    public static PricesHook getShopPrices() {
        return shopPrices;
    }

    @Nullable
    public static HologramHook getHolograms() {
        return holograms;
    }

    @Nullable
    public static LevelsHook getLevels() {
        return levels;
    }

    @Nullable
    public static TeamHook getTeams() {
        return teams;
    }

    public static boolean canBuildAt(@NotNull Player player, @NotNull Location location) {
        return true;
    }
}
