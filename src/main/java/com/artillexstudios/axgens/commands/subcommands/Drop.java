package com.artillexstudios.axgens.commands.subcommands;

import com.artillexstudios.axgens.tiers.Tier;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public enum Drop {
    INSTANCE;

    public void execute(@NotNull CommandSender sender, Player player, Tier tier, @Nullable Integer amount) {
    }
}
