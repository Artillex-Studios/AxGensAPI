package com.artillexstudios.axgens.api.events;

import com.artillexstudios.axgens.generators.Generator;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class GeneratorPostPlaceEvent extends Event {
    private static final HandlerList handlerList = new HandlerList();
    private final Player player;
    private final Generator generator;
    private final Block block;

    public GeneratorPostPlaceEvent(@NotNull Player player, Generator generator, Block block) {
        super(!Bukkit.isPrimaryThread());

        this.player = player;
        this.generator = generator;
        this.block = block;
    }

    @NotNull
    public Generator getGenerator() {
        return generator;
    }

    @NotNull
    public Block getBlock() {
        return block;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @NotNull
    public Player getPlayer() {
        return player;
    }
}
