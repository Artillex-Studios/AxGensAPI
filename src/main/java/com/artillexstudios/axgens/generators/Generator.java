package com.artillexstudios.axgens.generators;

import com.artillexstudios.axgens.hooks.HookManager;
import com.artillexstudios.axgens.tiers.Tier;
import com.artillexstudios.axgens.tiers.Tiers;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Generator {
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
    private final ArrayList<String> holoLines = new ArrayList<>();
    private final HashMap<Integer, String> updatingHoloLines = new HashMap<>();

    public Generator(int id, int tier, @NotNull Location location, @NotNull UUID owner) {
        this.id = id;
        this.tier = tier;
        this.location = location;
        this.dropLocation = location.clone().add(0.5, 1, 0.5);
        this.owner = owner;
        x = location.getBlockX() >> 4;
        z = location.getBlockZ() >> 4;
        updateTiers();

        if (HookManager.getHolograms() != null)
            HookManager.getHolograms().createHologram(this, cTier.getHoloLines());
        updateHologram(true);
    }

    public void tick() {

    }

    public void run() {

    }

    public void updateTiers() {
        cTier = Tiers.getTier(tier);
        nTier = Tiers.getTier(tier + 1);
        holoLines.clear();

        for (int i = 0; i < cTier.getHoloLines().size(); i++) {
            if (cTier.getHoloLines().get(i).contains("%next-spawn%")) {
                updatingHoloLines.put(i, cTier.getHoloLines().get(i));
            } else {
                holoLines.add(cTier.getHoloLines().get(i));
            }
        }

        updateHologram(true);
    }

    private void updateHologram(boolean full) {
        // updates the hologram
    }

    public void openGuiFor(@NotNull Player player) {
        // opens the generator gui
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

    public Generator getGenerator() {
        return this;
    }
}
