package com.artillexstudios.axgens.hooks.impl.team;

import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface TeamHook {
    void setup();

    List<OfflinePlayer> getTeamMembersOf(@NotNull OfflinePlayer player);
}
