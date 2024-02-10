package com.artillexstudios.axgens.events;

import com.artillexstudios.axapi.libs.boostedyaml.boostedyaml.block.implementation.Section;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public record EventConfig(Section section, boolean enabled, Map<String, Object> options, String name, String bossBar, String bossBarColor, String bossBarStyle, String chatStart, String chatEnd) {

    @NotNull
    public static EventConfig build(@NotNull Section section) {
        Section displaySection = section.getSection("display");
        return new EventConfig(section, section.getBoolean("enabled"), section.getSection("options").getStringRouteMappedValues(false), displaySection.getString("name"), displaySection.getString("bossbar"), displaySection.getString("bossbar-color"), displaySection.getString("bossbar-style"), displaySection.getString("chat-start"), displaySection.getString("chat-end"));
    }
}
