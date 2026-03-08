package com.artillexstudios.axgens.commands.subcommands;

import com.artillexstudios.axgens.enums.EventAction;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public enum Event {
    INSTANCE;

    public void execute(@NotNull CommandSender sender, @NotNull EventAction type, @Nullable com.artillexstudios.axgens.events.Event event) {
    }
}
