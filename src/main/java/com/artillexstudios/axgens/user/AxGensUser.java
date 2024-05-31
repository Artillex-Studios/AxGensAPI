package com.artillexstudios.axgens.user;

import com.artillexstudios.axgens.AxGens;

import java.util.UUID;

public class AxGensUser {
    private int extraSlots;
    private int placed;
    private float multiplier;
    private long level;
    private final UUID uuid;

    public AxGensUser(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }

    public int getExtraSlots() {
        return extraSlots;
    }

    public void setExtraSlots(int extraSlots) {
        this.extraSlots = extraSlots;
    }

    public int getPlaced() {
        return placed;
    }

    public void setPlaced(int placed) {
        this.placed = placed;
    }

    public void addPlaced(int amount) {
        this.placed += amount;
    }

    public void addExtraSlots(int amount) {
        this.extraSlots += amount;
    }

    public float getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(float multiplier) {
        this.multiplier = multiplier;
    }

    // note: this level is only used for the builtin level system, use the HookManager to get levels
    public long getLevel() {
        return level;
    }

    public void setLevel(long level) {
        this.level = level;
    }
}
