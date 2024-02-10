package com.artillexstudios.axgens.hooks;

import com.artillexstudios.axapi.utils.StringUtils;
import com.artillexstudios.axgens.hooks.impl.currency.CurrencyHook;
import com.artillexstudios.axgens.hooks.impl.level.LevelsHook;
import com.artillexstudios.axgens.hooks.impl.protection.ProtectionHook;
import com.artillexstudios.axgens.hooks.impl.shop.PricesHook;
import com.artillexstudios.axgens.hooks.impl.team.TeamHook;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;

public class HookManager {
    private static final HashSet<ProtectionHook> PROTECTION_HOOKS = new HashSet<>();
    private static CurrencyHook currency = null;
    private static PricesHook shopPrices = null;
    private static LevelsHook levels = null;
    private static TeamHook teams = null;

    public void setupHooks() {
        updateHooks();
    }

    public void updateHooks() {
    }

    @SuppressWarnings("unused")
    public static void registerProtectionHook(@NotNull Plugin plugin, @NotNull ProtectionHook protectionHook) {
        PROTECTION_HOOKS.add(protectionHook);
        Bukkit.getConsoleSender().sendMessage(StringUtils.formatToString("&#33FF33[AxGens] Hooked into " + plugin.getName() + "!"));
    }

    @SuppressWarnings("unused")
    public static void registerPriceProviderHook(@NotNull Plugin plugin, @NotNull PricesHook pricesHook) {
        shopPrices = pricesHook;
        Bukkit.getConsoleSender().sendMessage(StringUtils.formatToString("&#33FF33[AxGens] Hooked into " + plugin.getName() + "! Note: You must set the price provider to CUSTOM or it will be overridden after reloading!"));
    }

    @SuppressWarnings("unused")
    public static void registerCurrencyHook(@NotNull Plugin plugin, @NotNull CurrencyHook currencyHook) {
        currency = currencyHook;
        Bukkit.getConsoleSender().sendMessage(StringUtils.formatToString("&#33FF33[AxGens] Hooked into " + plugin.getName() + "! Note: You must set the currency provider to CUSTOM or it will be overridden after reloading!"));
    }

    @SuppressWarnings("unused")
    public static void registerLevelHook(@NotNull Plugin plugin, @NotNull LevelsHook levelHook) {
        levels = levelHook;
        Bukkit.getConsoleSender().sendMessage(StringUtils.formatToString("&#33FF33[AxGens] Hooked into " + plugin.getName() + "! Note: You must set the level provider to CUSTOM or it will be overridden after reloading!"));
    }

    @SuppressWarnings("unused")
    public static void registerTeamHook(@NotNull Plugin plugin, @NotNull TeamHook teamHook) {
        teams = teamHook;
        Bukkit.getConsoleSender().sendMessage(StringUtils.formatToString("&#33FF33[AxGens] Hooked into " + plugin.getName() + "! Note: You must set the team provider to CUSTOM or it will be overridden after reloading!"));
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
