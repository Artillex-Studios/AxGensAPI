package com.artillexstudios.axgens.api.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ItemSellEvent extends Event {
    private static final HandlerList handlerList = new HandlerList();
    private final Player player;
    private final ItemStack soldItem;
    private double money;

    public ItemSellEvent(@NotNull Player player, @NotNull ItemStack soldItem, double money) {
        super(!Bukkit.isPrimaryThread());

        this.player = player;
        this.soldItem = soldItem;
        this.money = money;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @NotNull
    public Player getPlayer() {
        return player;
    }

    @NotNull
    public ItemStack getSoldItem() {
        return soldItem;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
