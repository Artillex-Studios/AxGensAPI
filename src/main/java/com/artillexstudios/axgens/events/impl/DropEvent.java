package com.artillexstudios.axgens.events.impl;

import com.artillexstudios.axapi.utils.StringUtils;
import com.artillexstudios.axgens.events.Event;
import com.artillexstudios.axgens.events.EventConfig;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static com.artillexstudios.axgens.AxGens.MESSAGEUTILS;

public class DropEvent extends Event {
    private BossBar bossBar;
    private final int bonusDrops;

    public DropEvent(EventConfig config) {
        super(config);

        bonusDrops = ((Number) config.options().get("multiplier")).intValue();
    }

    @Override
    public void apply(Player player) {
        bossBar.addPlayer(player);
    }

    @Override
    public void onStart() {
        final HashMap<String, String> replacements = new HashMap<>();
        String multiplier = String.valueOf(1 + ((Number) getConfig().options().get("multiplier")).intValue());
        replacements.put("%multiplier%", multiplier);
        replacements.put("%time%", String.valueOf(((Number) getConfig().options().getOrDefault("duration-seconds", 180)).intValue()));

        Bukkit.getOnlinePlayers().forEach(player -> MESSAGEUTILS.sendFormatted(player, getConfig().chatStart(), replacements));

        startTime = System.currentTimeMillis();
        endTime = startTime + (1_000L * Integer.parseInt(getConfig().options().getOrDefault("duration-seconds", "180").toString()));

        bossBar = Bukkit.createBossBar(
                StringUtils.formatToString(getConfig().bossBar().replace("%multiplier%", multiplier).replace("%bonus-tiers%", multiplier).replace("%time%", "" + ((endTime - System.currentTimeMillis()) / 1_000L))),
                BarColor.valueOf(getConfig().bossBarColor().toUpperCase()),
                BarStyle.valueOf(getConfig().bossBarStyle().toUpperCase().replace("PROGRESS", "SOLID").replace("NOTCHED", "SEGMENTED")));
    }

    @Override
    public void onCancel() {
        bossBar.removeAll();
        bossBar = null;

        Map<String, String> replacements = Collections.singletonMap("%multiplier%", String.valueOf(bonusDrops));

        for (Player player : Bukkit.getOnlinePlayers()) {
            MESSAGEUTILS.sendFormatted(player, getConfig().chatEnd(), replacements);
        }
    }

    @Override
    public void unApply(Player player) {
        bossBar.removePlayer(player);
    }

    @Override
    public void tick() {
        bossBar.setTitle(StringUtils.formatToString(getConfig().bossBar().replace("%multiplier%", String.valueOf(bonusDrops)).replace("%bonus-tiers%", String.valueOf(bonusDrops)).replace("%time%", "" + ((endTime - System.currentTimeMillis()) / 1_000L))));
        bossBar.setProgress(Math.max(0.0f, ((float) (endTime - System.currentTimeMillis()) / 1_000.0f) / ((Number) getConfig().options().get("duration-seconds")).intValue()));
    }

    public int getBonusDrops() {
        return bonusDrops;
    }
}
