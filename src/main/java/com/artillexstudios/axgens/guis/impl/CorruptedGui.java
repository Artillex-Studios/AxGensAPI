package com.artillexstudios.axgens.guis.impl;

import com.artillexstudios.axgens.generators.Generator;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class CorruptedGui {
    private final static ScriptEngineManager mgr = new ScriptEngineManager();
    private final static ScriptEngine engine = mgr.getEngineByName("JavaScript");

    public CorruptedGui(Player player, @NotNull Generator generator) {
    }

    public void open() {
    }

    public static ScriptEngine getEngine() {
        return engine;
    }
}
