package com.artillexstudios.axgens.generators;

import com.artillexstudios.axgens.hooks.HookManager;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class Generators {
    private static final HashMap<Location, Generator> generators = new HashMap<>();

    public static HashMap<Location, Generator> getGenerators() {
        return generators;
    }

    public static void addGenerator(@NotNull Generator generator) {
        generators.put(generator.getLocation(), generator);
    }

    public static void removeGenerator(@NotNull Generator generator) {
        if (HookManager.getHolograms() != null)
            HookManager.getHolograms().deleteHologram(generator);
        generators.remove(generator.getLocation());
    }

    public static void removeGenerator(@NotNull Location location) {
        generators.remove(location);
    }
}
