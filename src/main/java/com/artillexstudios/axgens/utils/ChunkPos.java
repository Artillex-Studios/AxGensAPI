package com.artillexstudios.axgens.utils;

import com.artillexstudios.axgens.generators.Generator;
import org.bukkit.World;

import java.util.ArrayList;
import java.util.UUID;

public class ChunkPos {
    private final ArrayList<Generator> generators = new ArrayList<>(4);
    private final UUID worldUUID;
    private final int x;
    private final int z;
    private volatile boolean ticking = false;

    public ChunkPos(World world, int x, int z) {
        this.worldUUID = world.getUID();
        this.x = x;
        this.z = z;
    }

    public void addGenerator(Generator generator) {
        generators.add(generator);
    }

    public boolean removeGenerator(Generator generator) {
        this.generators.remove(generator);

        return this.generators.isEmpty();
    }

    public int getX() {
        return this.x;
    }

    public int getZ() {
        return this.z;
    }

    public UUID getWorldUUID() {
        return this.worldUUID;
    }

    public ArrayList<Generator> getGenerators() {
        return this.generators;
    }

    public boolean isTicking() {
        return this.ticking;
    }

    public void setTicking(boolean ticking) {
        this.ticking = ticking;
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ChunkPos)) return false;
        ChunkPos chunkPos = (ChunkPos) o;

        if (x != chunkPos.x) return false;
        if (z != chunkPos.z) return false;
        return getWorldUUID().equals(chunkPos.getWorldUUID());
    }

    @Override
    public int hashCode() {
        int result = getWorldUUID().hashCode();
        result = 31 * result + x;
        result = 31 * result + z;
        return result;
    }

    @Override
    public String toString() {
        return "ChunkPos{" +
                "generators=" + generators +
                ", worldUUID=" + worldUUID +
                ", x=" + x +
                ", z=" + z +
                '}';
    }
}
