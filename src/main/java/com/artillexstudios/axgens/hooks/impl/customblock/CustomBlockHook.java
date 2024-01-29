package com.artillexstudios.axgens.hooks.impl.customblock;

import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

public interface CustomBlockHook {
    void removeBlock(@NotNull Location location);

    void placeBlock(@NotNull String itemId, @NotNull Location location);
}
