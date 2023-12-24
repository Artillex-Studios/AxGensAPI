package com.artillexstudios.axgens.api;

import com.artillexstudios.axgens.AxGens;
import com.artillexstudios.axgens.hooks.HookManager;
import com.artillexstudios.axgens.hooks.impl.currency.CurrencyHook;
import com.artillexstudios.axgens.hooks.impl.hologram.HologramHook;
import com.artillexstudios.axgens.hooks.impl.level.LevelsHook;
import com.artillexstudios.axgens.hooks.impl.shop.PricesHook;
import com.artillexstudios.axgens.hooks.impl.team.TeamHook;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

import static com.artillexstudios.axgens.AxGens.CONFIG;

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
        return AxGens.getDatabase().getLevel(uuid);
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
    public static HologramHook getHolograms() {
        return HookManager.getHolograms();
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
