package com.artillexstudios.axgens.api.events;

import com.artillexstudios.axgens.generators.Generator;
import org.bukkit.Bukkit;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class GeneratorDropEvent extends Event implements Cancellable {
    private static final HandlerList handlerList = new HandlerList();
    private final Generator generator;
    private final ItemStack item;
    private boolean isCancelled = false;

    public GeneratorDropEvent(@NotNull Generator generator, @NotNull ItemStack item) {
        super(!Bukkit.isPrimaryThread());

        this.item = item;
        this.generator = generator;
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
    public Generator getGenerator() {
        return generator;
    }

    @NotNull
    public ItemStack getItem() {
        return item;
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
