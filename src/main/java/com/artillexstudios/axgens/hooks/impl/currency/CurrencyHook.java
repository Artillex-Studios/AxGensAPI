package com.artillexstudios.axgens.hooks.impl.currency;

import org.bukkit.entity.Player;

public interface CurrencyHook {
    void setup();

    double getBalance(Player p);

    void giveBalance(Player p, double amount);

    void takeBalance(Player p, double amount);
}
