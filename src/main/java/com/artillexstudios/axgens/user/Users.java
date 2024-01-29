package com.artillexstudios.axgens.user;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Users {
    private static final ConcurrentHashMap<UUID, AxGensUser> users = new ConcurrentHashMap<>();

    public static AxGensUser getUser(@NotNull UUID uuid) {
        if (users.containsKey(uuid)) {
            return users.get(uuid);
        }

        final AxGensUser axGensUser = new AxGensUser(uuid);
        users.put(uuid, axGensUser);
        return axGensUser;
    }

    public static AxGensUser getUser(@NotNull Player player) {
        return getUser(player.getUniqueId());
    }
}
