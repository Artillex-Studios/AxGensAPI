package com.artillexstudios.axgens;

import com.artillexstudios.axgens.config.AbstractConfig;
import com.artillexstudios.axgens.database.Database;
import com.artillexstudios.axgens.database.DatabaseQueue;
import dev.dejvokep.boostedyaml.YamlDocument;
import org.bukkit.plugin.java.JavaPlugin;

public final class AxGens extends JavaPlugin {
    private static AbstractConfig abstractConfig;
    private static AbstractConfig abstractMessages;
    private static AbstractConfig abstractTiers;
    public static YamlDocument MESSAGES;
    public static YamlDocument CONFIG;
    public static YamlDocument TIERS;
    private static AxGens instance;
    private static DatabaseQueue databaseQueue;
    private static Database database;

    public static AbstractConfig getAbstractConfig() {
        return abstractConfig;
    }

    public static AbstractConfig getAbstractMessages() {
        return abstractMessages;
    }

    public static AbstractConfig getAbstractTiers() {
        return abstractTiers;
    }

    public static DatabaseQueue getDatabaseQueue() {
        return databaseQueue;
    }

    public static Database getDatabase() {
        return database;
    }

    public static AxGens getInstance() {
        return instance;
    }
}
