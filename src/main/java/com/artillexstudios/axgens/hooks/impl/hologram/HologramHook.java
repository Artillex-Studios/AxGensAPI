package com.artillexstudios.axgens.hooks.impl.hologram;

import com.artillexstudios.axgens.generators.Generator;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface HologramHook {

    void createHologram(@NotNull Generator generator, @NotNull List<String> lines);

    void deleteHologram(@NotNull Generator generator);

    void updateHologram(@NotNull Generator generator, @NotNull List<String> lines);
    void updateHologram(@NotNull Generator generator, int line, @NotNull String str);
}
