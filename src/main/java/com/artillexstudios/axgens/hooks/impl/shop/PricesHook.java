package com.artillexstudios.axgens.hooks.impl.shop;

import org.bukkit.inventory.ItemStack;

public interface PricesHook {
    void setup();

    double getPrice(ItemStack it);
}
