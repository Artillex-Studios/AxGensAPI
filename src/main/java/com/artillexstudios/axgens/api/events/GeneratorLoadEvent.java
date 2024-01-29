package com.artillexstudios.axgens.api.events;

import com.artillexstudios.axgens.generators.Generator;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class GeneratorLoadEvent extends Event {
    private static final HandlerList handlerList = new HandlerList();
    private final Generator generator;

    public GeneratorLoadEvent(Generator generator) {
        super(!Bukkit.isPrimaryThread());

        this.generator = generator;
    }

    @NotNull
    public Generator getGenerator() {
        return generator;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }
}
