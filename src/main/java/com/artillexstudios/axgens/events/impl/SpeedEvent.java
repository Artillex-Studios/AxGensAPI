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

public class SpeedEvent extends Event {
    private BossBar bossBar;
    private final double boost;

    public SpeedEvent(EventConfig config) {
        super(config);

        boost = ((Number) config.options().get("multiplier")).doubleValue();
    }

    @Override
    public void apply(Player player) {
        bossBar.addPlayer(player);
    }

    @Override
    public void onStart() {
        final HashMap<String, String> replacements = new HashMap<>();
        String multiplier = String.valueOf((Math.round(100 + 100 * Double.parseDouble(getConfig().options().get("multiplier").toString()))));
        replacements.put("%multiplier%", multiplier);
        replacements.put("%time%", String.valueOf(Integer.parseInt(getConfig().options().getOrDefault("duration-seconds", "180").toString())));

        for (Player player : Bukkit.getOnlinePlayers()) {
            MESSAGEUTILS.sendFormatted(player, getConfig().chatStart(), replacements);
        }

        startTime = System.currentTimeMillis();
        endTime = startTime + (1_000L * Integer.parseInt(getConfig().options().getOrDefault("duration-seconds", "180").toString()));

        bossBar = Bukkit.createBossBar(
                StringUtils.formatToString(getConfig().bossBar().replace("%multiplier%", multiplier).replace("%bonus-tiers%", multiplier).replace("%time%", "" + ((endTime - System.currentTimeMillis()) / 1_000L))),
                BarColor.valueOf(getConfig().bossBarColor().toUpperCase()),
                BarStyle.valueOf(getConfig().bossBarStyle().toUpperCase().replace("PROGRESS", "SOLID").replace("NOTCHED", "SEGMENTED")));
    }

    @Override
    public void onCancel() {
        bossBar = null;

        Map<String, String> replacements = Collections.singletonMap("%multiplier%", String.valueOf(boost));

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
        String multiplier = String.valueOf((Math.round(100 + 100 * Double.parseDouble(getConfig().options().get("multiplier").toString()))));
        bossBar.setTitle(StringUtils.formatToString(getConfig().bossBar().replace("%multiplier%", multiplier).replace("%bonus-tiers%", String.valueOf(boost)).replace("%time%", "" + ((endTime - System.currentTimeMillis()) / 1_000L))));
        bossBar.setProgress(Math.max(0.0f, ((float) (endTime - System.currentTimeMillis()) / 1_000.0f) / ((Number) getConfig().options().get("duration-seconds")).intValue()));
    }

    public double getBoost() {
        return boost;
    }
}
