package com.artillexstudios.axgens.hooks.impl.level;

import org.bukkit.entity.Player;

public interface LevelsHook {
    void setup();

    long getLevel(Player player);
}
