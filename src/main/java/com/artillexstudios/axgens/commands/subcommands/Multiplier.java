package com.artillexstudios.axgens.commands.subcommands;

import com.artillexstudios.axgens.enums.ModifyType;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public enum Multiplier {
    INSTANCE;

    public void execute(@NotNull CommandSender sender, @NotNull OfflinePlayer offlinePlayer, @NotNull ModifyType type, float amount) {
    }
}
