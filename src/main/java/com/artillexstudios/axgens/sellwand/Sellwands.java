package com.artillexstudios.axgens.sellwand;

import com.artillexstudios.axapi.libs.boostedyaml.boostedyaml.block.implementation.Section;

import java.util.HashMap;

import static com.artillexstudios.axgens.AxGens.SELLWANDS;

public class Sellwands {
    private static final HashMap<String, Sellwand> sellwands = new HashMap<>();

    public static void reload() {
    }

    public static HashMap<String, Sellwand> getSellwands() {
        return sellwands;
    }
}
