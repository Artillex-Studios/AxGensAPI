package com.artillexstudios.axgens.generators;

import com.artillexstudios.axapi.hologram.Hologram;
import com.artillexstudios.axgens.api.events.GeneratorLoadEvent;
import com.artillexstudios.axgens.tiers.Tier;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

import static com.artillexstudios.axgens.AxGens.CONFIG;

public class Generator {
    private static final Vector ZERO_VECTOR = new Vector(0, 0, 0);
    private int tick = 0;
    private int id;
    private int tier;
    private final Location location;
    private final Location dropLocation;
    private final UUID owner;
    private final int x;
    private final int z;
    private Tier cTier;
    private Tier nTier;
    private Hologram hologram = null;
    private boolean broken = false;
    private Hologram brokenHologram = null;
    public boolean ownerOnline;

    public Generator(int id, int tier, @NotNull Location location, @NotNull UUID owner, boolean broken) {
        this.id = id;
        this.tier = tier;
        this.location = location;
        this.dropLocation = location.clone().add(0.5, 1, 0.5);
        this.owner = owner;
        x = location.getBlockX() >> 4;
        z = location.getBlockZ() >> 4;
        this.ownerOnline = Bukkit.getPlayer(owner) != null;
        if (CONFIG.getBoolean("corrupted-generators.enabled", false)) setBroken(broken);

        GeneratorArea.load(this);

        updateTiers();

        final GeneratorLoadEvent generatorLoadEvent = new GeneratorLoadEvent(this);
        Bukkit.getPluginManager().callEvent(generatorLoadEvent);
    }

    public void tick() {
        tick(1);
    }

    public void tick(double multiplier) {
    }

    public void updateTiers() {
    }

    public void openGuiFor(@NotNull Player player) {
    }

    public void tryRepair(@NotNull Player player) {
    }

    public void tryUpgrade(@NotNull Player player) {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Location getLocation() {
        return location.clone();
    }

    public int getTier() {
        return tier;
    }

    public UUID getOwner() {
        return owner;
    }

    public Tier getcTier() {
        return cTier;
    }

    public Tier getnTier() {
        return nTier;
    }

    public Generator getGenerator() {
        return this;
    }

    public boolean isOwnerOnline() {
        return ownerOnline;
    }

    public Hologram getHologram() {
        return hologram;
    }

    public boolean isBroken() {
        return broken;
    }

    public void setBroken(boolean broken) {
    }

    public Hologram getBrokenHologram() {
        return brokenHologram;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Generator generator = (Generator) o;

        if (id != generator.id) return false;
        return location.equals(generator.location);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + location.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Generator{"
                + "location=" + location
                + "}";
    }
}