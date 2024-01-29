package com.artillexstudios.axgens.generators;

import com.artillexstudios.axgens.AxGens;
import com.artillexstudios.axgens.hooks.HookManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Generators {
    private static final ExecutorService executor = Executors.newSingleThreadExecutor();
    private static final HashMap<Location, Generator> generators = new HashMap<>();

    public static ExecutorService getHologramExecutor() {
        return executor;
    }

    public static HashMap<Location, Generator> getGenerators() {
        return generators;
    }

    public static void addGenerator(@NotNull Generator generator) {
    }

    public static void removeGenerator(@NotNull Generator generator) {
    }

    public static void removeGenerator(@NotNull Location location) {
    }
}
