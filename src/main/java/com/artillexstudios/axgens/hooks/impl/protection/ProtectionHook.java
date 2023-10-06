package com.artillexstudios.axgens.hooks.impl.protection;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public interface ProtectionHook {

    boolean canPlayerBuildAt(@NotNull Player player, @NotNull Location location);
}
