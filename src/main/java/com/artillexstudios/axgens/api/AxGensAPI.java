package com.artillexstudios.axgens.api;

import com.artillexstudios.axgens.hooks.HookManager;
import com.artillexstudios.axgens.hooks.impl.currency.CurrencyHook;
import com.artillexstudios.axgens.hooks.impl.level.LevelsHook;
import com.artillexstudios.axgens.hooks.impl.shop.PricesHook;
import com.artillexstudios.axgens.hooks.impl.team.TeamHook;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class AxGensAPI {

    public static int getPlayerGeneratorLimit(@NotNull Player player) {
        return 0;
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

    @Nullable
    public static CurrencyHook getCurrency() {
        return HookManager.getCurrency();
    }

    @Nullable
    public static PricesHook getShopPrices() {
        return HookManager.getShopPrices();
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
