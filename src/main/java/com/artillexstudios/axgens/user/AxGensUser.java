package com.artillexstudios.axgens.user;

import java.util.UUID;

public class AxGensUser {

    public AxGensUser(UUID uuid) {
    }

    public UUID getUuid() {
        return null;
    }

    public int getExtraSlots() {
        return -1;
    }

    public void setExtraSlots(int extraSlots) {
    }

    public int getPlaced() {
        return -1;
    }

    public void setPlaced(int placed) {
    }

    public void addPlaced(int amount) {
    }

    public void addExtraSlots(int amount) {
    }

    public float getMultiplier() {
        return -1;
    }

    public void setMultiplier(float multiplier) {
    }

    // note: this level is only used for the builtin level system, use the HookManager to get levels
    public long getLevel() {
        return -1;
    }

    public void setLevel(long level) {
    }
}
