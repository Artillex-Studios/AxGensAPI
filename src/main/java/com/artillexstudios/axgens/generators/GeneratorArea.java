package com.artillexstudios.axgens.generators;

import com.artillexstudios.axgens.utils.ChunkPos;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;
import org.spigotmc.CustomTimingsHandler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Consumer;

public class GeneratorArea {
    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private static final ArrayList<ChunkPos> chunks = new ArrayList<>();

    public static void startTicking(Chunk chunk) {
        int x = chunk.getX();
        int z = chunk.getZ();
        UUID worldUUID = chunk.getWorld().getUID();

        lock.readLock().lock();
        try {
            ArrayList<ChunkPos> chunks = GeneratorArea.chunks;
            int chunksSize = chunks.size();

            for (int i = 0; i < chunksSize; i++) {
                ChunkPos pos = chunks.get(i);
                if (pos.getX() == x && pos.getZ() == z && pos.getWorldUUID().equals(worldUUID)) {
                    pos.setTicking(true);
                    break;
                }
            }
        } finally {
            lock.readLock().unlock();
        }
    }

    public static void stopTicking(Chunk chunk) {
        int x = chunk.getX();
        int z = chunk.getZ();
        UUID worldUUID = chunk.getWorld().getUID();

        lock.readLock().lock();
        try {
            ArrayList<ChunkPos> chunks = GeneratorArea.chunks;
            int chunksSize = chunks.size();

            for (int i = 0; i < chunksSize; i++) {
                ChunkPos pos = chunks.get(i);
                if (pos.getX() == x && pos.getZ() == z && pos.getWorldUUID().equals(worldUUID)) {
                    pos.setTicking(false);
                    break;
                }
            }
        } finally {
            lock.readLock().unlock();
        }
    }

    public static void load(Generator generator) {
        Location location = generator.getLocation();
        World world = location.getWorld();
        if (world == null) return;

        int x = (int) Math.round(location.getX()) >> 4;
        int z = (int) Math.round(location.getZ()) >> 4;
        UUID worldUUID = world.getUID();

        lock.writeLock().lock();
        try {
            ArrayList<ChunkPos> chunks = GeneratorArea.chunks;
            int chunksSize = chunks.size();

            ChunkPos chunkPos = null;

            for (int i = 0; i < chunksSize; i++) {
                ChunkPos pos = chunks.get(i);
                if (pos.getX() == x && pos.getZ() == z && pos.getWorldUUID().equals(worldUUID)) {
                    chunkPos = pos;
                    break;
                }
            }

            if (chunkPos == null) {
                chunkPos = new ChunkPos(world, x, z);
                chunks.add(chunkPos);
            }

            chunkPos.addGenerator(generator);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public static void remove(Generator generator) {
        Location location = generator.getLocation();
        World world = location.getWorld();
        if (world == null) return;

        int x = (int) Math.round(location.getX()) >> 4;
        int z = (int) Math.round(location.getZ()) >> 4;
        UUID worldUUID = world.getUID();

        lock.writeLock().lock();
        try {
            ArrayList<ChunkPos> chunks = GeneratorArea.chunks;

            Iterator<ChunkPos> iterator = chunks.iterator();
            while (iterator.hasNext()) {
                ChunkPos next = iterator.next();

                if (next.getX() == x && next.getZ() == z && next.getWorldUUID().equals(worldUUID)) {
                    if (next.removeGenerator(generator)) {
                        iterator.remove();
                    }

                    break;
                }
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    public static List<Generator> getGenerators() {
        ArrayList<Generator> generators = new ArrayList<>(chunks.size());

        lock.readLock().lock();
        try {
            for (ChunkPos pos : GeneratorArea.chunks) {
                generators.addAll(pos.getGenerators());
            }

            return generators;
        } finally {
            lock.readLock().unlock();
        }
    }

    public static Generator getGeneratorAt(Location location) {
        World world = location.getWorld();
        if (world == null) return null;

        UUID worldUUID = world.getUID();
        int x = (int) Math.round(location.getX()) >> 4;
        int z = (int) Math.round(location.getZ()) >> 4;

        lock.readLock().lock();
        try {
            ArrayList<ChunkPos> chunks = GeneratorArea.chunks;
            int chunksSize = chunks.size();

            for (int i = 0; i < chunksSize; i++) {
                ChunkPos pos = chunks.get(i);
                // There's no way that someone is interacting with a generator
                // In a chunk that's not tracked by us
                if (!pos.isTicking()) continue;

                if (pos.getX() == x && pos.getZ() == z && pos.getWorldUUID().equals(worldUUID)) {
                    ArrayList<Generator> generators = pos.getGenerators();
                    int generatorSize = generators.size();

                    for (int j = 0; j < generatorSize; j++) {
                        Generator generator = generators.get(j);
                        if (!generator.getLocation().equals(location)) continue;

                        return generator;
                    }

                    return null;
                }
            }
        } finally {
            lock.readLock().unlock();
        }

        return null;
    }

    public static void getChunks(Consumer<ArrayList<ChunkPos>> consumer) {
        lock.readLock().lock();
        try {
            consumer.accept(chunks);
        } finally {
            lock.readLock().unlock();
        }
    }
}
