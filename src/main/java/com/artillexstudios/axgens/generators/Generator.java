package com.artillexstudios.axgens.generators;

import com.artillexstudios.axapi.hologram.Hologram;
import com.artillexstudios.axgens.tiers.Tier;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

public class Generator {

    public Generator(int id, int tier, @NotNull Object location, @NotNull UUID owner, boolean broken) {
    }

    public void tick() {
        tick(1);
    }

    public void tick(double multiplier) {
    }

    public void updateTiers() {
    }

    public void onLoad() {
    }

    public void onUnload() {
    }

    public void openGuiFor(@NotNull Player player) {
    }

    public void tryRepair(@NotNull Player player) {
    }

    public void tryUpgrade(@NotNull Player player) {
    }

    public void setId(int id) {
    }

    public int getId() {
        return -1;
    }

    public int getTick() {
        return -1;
    }

    public Object getLocation() {
        return null;
    }

    public void setOwnerOnline(boolean ownerOnline) {
    }

    public Object getLayer() {
        return null;
    }

    public int getTier() {
        return -1;
    }

    public AtomicBoolean getTicking() {
        return null;
    }

    public void setTicking(AtomicBoolean ticking) {
    }

    public UUID getOwner() {
        return null;
    }

    public Tier getcTier() {
        return null;
    }

    public Tier getnTier() {
        return null;
    }

    public Generator getGenerator() {
        return this;
    }

    public boolean isOwnerOnline() {
        return false;
    }

    public Hologram getHologram() {
        return null;
    }

    public boolean isBroken() {
        return false;
    }

    public double getUpgradePrice() {
        return -1;
    }

    public double getRepairPrice() {
        return -1;
    }

    public void setBroken(boolean broken) {
    }

    public void updateBrokenHologram() {
    }

    public Hologram getBrokenHologram() {
        return null;
    }

    public Object dropLocation() {
        return null;
    }

}