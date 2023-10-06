package com.artillexstudios.axgens.config;

import com.artillexstudios.axgens.AxGens;
import dev.dejvokep.boostedyaml.YamlDocument;
import dev.dejvokep.boostedyaml.dvs.versioning.BasicVersioning;
import dev.dejvokep.boostedyaml.settings.dumper.DumperSettings;
import dev.dejvokep.boostedyaml.settings.general.GeneralSettings;
import dev.dejvokep.boostedyaml.settings.loader.LoaderSettings;
import dev.dejvokep.boostedyaml.settings.updater.UpdaterSettings;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public abstract class AbstractConfig {
    protected final String fileName;

    public AbstractConfig(@NotNull String fileName) {
        this.fileName = fileName;
    }

    protected YamlDocument file = null;

    public void setup() {
        try {
            file = YamlDocument.create(new File(AxGens.getInstance().getDataFolder(), fileName), AxGens.getInstance().getResource(fileName), GeneralSettings.builder().setUseDefaults(false).build(), LoaderSettings.DEFAULT, DumperSettings.DEFAULT, UpdaterSettings.builder().setVersioning(new BasicVersioning("version")).build());
            file.update();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public YamlDocument getConfig() {
        return file;
    }

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    public boolean reloadConfig() {
        if (file.getFile() == null) return false;

        try {
            file.reload();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
