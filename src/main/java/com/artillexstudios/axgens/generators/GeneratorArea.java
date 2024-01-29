package com.artillexstudios.axgens.generators;

import com.artillexstudios.axgens.utils.ChunkPos;
import org.bukkit.Chunk;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Consumer;

public class GeneratorArea {
    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private static final ArrayList<ChunkPos> chunks = new ArrayList<>();

    public static void startTicking(Chunk chunk) {
    }

    public static void stopTicking(Chunk chunk) {
    }

    public static void load(Generator generator) {
    }

    public static void remove(Generator generator) {
    }

    public static List<Generator> getGenerators() {
        return new ArrayList<>();
    }

    public static Generator getGeneratorAt(Location location) {
        return null;
    }

    public static void getChunks(Consumer<ArrayList<ChunkPos>> consumer) {
    }
}
