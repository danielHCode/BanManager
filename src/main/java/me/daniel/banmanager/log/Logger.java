package me.daniel.banmanager.log;

import me.daniel.banmanager.BanManager;

import java.util.logging.Level;

public class Logger {

    public static String plPrefix = "[BanManager] ";

    public static void warn(String message) {
        BanManager.getPlugin().getLogger().warning(plPrefix+message);
    }

    public static void error(String message) {
        BanManager.getPlugin().getLogger().log(Level.FINEST,plPrefix+message);

    }

    public static void log(String message) {
        BanManager.getPlugin().getLogger().log(Level.INFO,plPrefix+message);
    }
}
