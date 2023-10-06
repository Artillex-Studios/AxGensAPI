package com.artillexstudios.axgens.database;

import com.artillexstudios.axgens.generators.Generator;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public interface Database {

    String getType();

    void setup();

    void loadAllGenerators();

    int createGenerator(@NotNull Generator generator);

    void saveGenerator(@NotNull Generator generator);

    void removeGenerator(int id);

    int getPlacedGenerators(@NotNull UUID uuid);

    void updateUser(@NotNull UUID uuid, int newSlots);

    void updateUser(@NotNull UUID uuid, long newLevel);

    int getExtraSlots(@NotNull UUID uuid);

    long getLevel(@NotNull UUID uuid);

    void disable();
}
