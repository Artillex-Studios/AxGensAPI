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

public class UpgradeEvent extends Event {
    private BossBar bossBar;
    private final int bonusTier;


    public UpgradeEvent(EventConfig config) {
        super(config);

        bonusTier = ((Number) config.options().get("bonus-tiers")).intValue();
    }

    @Override
    public void apply(Player player) {
        bossBar.addPlayer(player);
    }

    @Override
    public void onStart() {
        final HashMap<String, String> replacements = new HashMap<>();
        replacements.put("%multiplier%", "" + bonusTier);
        replacements.put("%time%", String.valueOf(Integer.parseInt(getConfig().options().getOrDefault("duration-seconds", "180").toString())));

        for (Player player : Bukkit.getOnlinePlayers()) {
            MESSAGEUTILS.sendFormatted(player, getConfig().chatStart(), replacements);
        }

        startTime = System.currentTimeMillis();
        endTime = startTime + (1_000L * Integer.parseInt(getConfig().options().getOrDefault("duration-seconds", "180").toString()));

        bossBar = Bukkit.createBossBar(
                StringUtils.formatToString(getConfig().bossBar().replace("%multiplier%", "" + bonusTier).replace("%bonus-tiers%", "" + bonusTier).replace("%time%", "" + ((endTime - System.currentTimeMillis()) / 1_000L))),
                BarColor.valueOf(getConfig().bossBarColor().toUpperCase()),
                BarStyle.valueOf(getConfig().bossBarStyle().toUpperCase().replace("PROGRESS", "SOLID").replace("NOTCHED", "SEGMENTED")));
    }

    @Override
    public void onCancel() {
        bossBar = null;
        Map<String, String> replacements = Collections.singletonMap("%multiplier%", String.valueOf(bonusTier));

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
        bossBar.setTitle(StringUtils.formatToString(getConfig().bossBar().replace("%multiplier%", String.valueOf(bonusTier)).replace("%bonus-tiers%", String.valueOf(bonusTier)).replace("%time%", "" + ((endTime - System.currentTimeMillis()) / 1_000L))));
        bossBar.setProgress(Math.max(0.0f, ((float) (endTime - System.currentTimeMillis()) / 1_000.0f) / ((Number) getConfig().options().get("duration-seconds")).intValue()));
    }

    public int getBonusTier() {
        return bonusTier;
    }
}
