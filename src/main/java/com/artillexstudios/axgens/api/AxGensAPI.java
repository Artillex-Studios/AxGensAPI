package com.artillexstudios.axgens.api;

import com.artillexstudios.axgens.AxGens;
import com.artillexstudios.axgens.hooks.HookManager;
import com.artillexstudios.axgens.hooks.impl.currency.CurrencyHook;
import com.artillexstudios.axgens.hooks.impl.hologram.HologramHook;
import com.artillexstudios.axgens.hooks.impl.level.LevelsHook;
import com.artillexstudios.axgens.hooks.impl.shop.PricesHook;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

import static com.artillexstudios.axgens.AxGens.CONFIG;

public class AxGensAPI {

    public static int getGeneratorLimit(@NotNull Player player) {
        boolean hasBypass = false;

        int maxGenerators = CONFIG.getInt("default-max-generators");
        for (PermissionAttachmentInfo effectivePermission : player.getEffectivePermissions()) {
            if (effectivePermission.getPermission().contains("*")) {
                hasBypass = true;
                break;
            }

            if (player.isOp()) {
                hasBypass = true;
                break;
            }

            if (!effectivePermission.getPermission().startsWith("axgens.limit.")) continue;

            int value = Integer.parseInt(effectivePermission.getPermission().substring(effectivePermission.getPermission().lastIndexOf('.') + 1));

            if (value > maxGenerators) {
                maxGenerators = value;
            }
        }

        return (hasBypass ? 99999 : maxGenerators) + AxGens.getDatabase().getExtraSlots(player.getUniqueId());
    }

    public static int getGeneratorPlacedAmount(@NotNull UUID uuid) {
        return AxGens.getDatabase().getPlacedGenerators(uuid);
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
}
