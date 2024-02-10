package com.artillexstudios.axgens.sellwand;

import com.artillexstudios.axapi.libs.boostedyaml.boostedyaml.block.implementation.Section;
import org.jetbrains.annotations.NotNull;

public class Sellwand {
    private final String type;
    private final float multiplier;
    private final int uses;
    private final long cooldownMilis;
    private final Section itemSection;

    public Sellwand(String type, float multiplier, int uses, long cooldownMilis, Section section) {
        this.type = type;
        this.multiplier = multiplier;
        this.uses = uses;
        this.cooldownMilis = cooldownMilis;
        this.itemSection = section;
    }

    @NotNull
    public String getType() {
        return type;
    }

    public float getMultiplier() {
        return multiplier;
    }

    public int getUses() {
        return uses;
    }

    public long getCooldownMilis() {
        return cooldownMilis;
    }

    public Section getItemSection() {
        return itemSection;
    }
}
