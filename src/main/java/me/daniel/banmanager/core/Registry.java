package me.daniel.banmanager.core;

import me.daniel.banmanager.config.ConfigManager;
import me.daniel.banmanager.log.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class Registry {

    public static HashMap<String, Object> defaultConfig;

    public static void readDefaultConfigs() {
        try {
            defaultConfig = loadConfig("./plugins/BanManagerConfig.yml", new String(Registry.class.getResourceAsStream("defaultConfig.yml").readAllBytes()));
        } catch (IOException e) {
            e.printStackTrace();
            Logger.error("Can not load default config");
        }
    }

    private static void checkConfig() {

    }

    private static HashMap<String, Object> loadConfig(String name, String defaultCode) {
        return new ConfigManager(name, (fos -> {
            try {
                fos.write(defaultCode.getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                e.printStackTrace();
            }
        })).parseConfig();
    }
}
