package com.artillexstudios.axgens.user;

import com.artillexstudios.axgens.AxGens;

import java.util.UUID;

public class AxGensUser {
    private int extraSlots;
    private int placed;
    private UUID uuid;

    public AxGensUser(UUID uuid) {
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
}
