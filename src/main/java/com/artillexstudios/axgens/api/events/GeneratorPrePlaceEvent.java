package com.artillexstudios.axgens.api.events;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class GeneratorPrePlaceEvent extends Event implements Cancellable {
    private static final HandlerList handlerList = new HandlerList();
    private final Player player;
    private final Block block;
    private final ItemStack item;
    private final int generatorTier;
    private boolean isCancelled = false;

    public GeneratorPrePlaceEvent(@NotNull Player player, Block block, ItemStack item, int generatorTier) {
        super(!Bukkit.isPrimaryThread());

        this.player = player;
        this.block = block;
        this.item = item;
        this.generatorTier = generatorTier;
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

    @NotNull
    public Block getBlock() {
        return block;
    }

    @NotNull
    public ItemStack getItem() {
        return item;
    }

    public int getGeneratorTier() {
        return generatorTier;
    }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean isCancelled) {
        this.isCancelled = isCancelled;
    }
}
