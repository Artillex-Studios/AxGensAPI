package com.artillexstudios.axgens.generators;

import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class Generators {
    private static final HashMap<Location, Generator> generators = new HashMap<>();

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
