package com.artillexstudios.axgens.database;

import com.artillexstudios.axgens.generators.Generator;
import com.artillexstudios.axgens.user.AxGensUser;
import org.bukkit.World;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.UUID;

public interface Database {

    String getType();

    void setup();

    void loadAllGenerators(@NotNull World world);

    void createGenerator(@NotNull Generator generator);

    void saveGenerator(@NotNull Generator generator);

    void removeGenerator(@NotNull Generator generator);

    void loadUser(@NotNull AxGensUser user);

    int getPlacedGenerators(@NotNull UUID uuid);

    void updateUser(@NotNull UUID uuid, int newSlots);

    void updateUser(@NotNull UUID uuid, long newLevel);

    void updateUser(@NotNull UUID uuid, float multiplier);

    int getExtraSlots(@NotNull UUID uuid);

    float getMultiplier(@NotNull UUID uuid);

    int getExtraSlotsTeam(@NotNull ArrayList<String> uuids);

    long getLevel(@NotNull UUID uuid);

    void disable();
}
