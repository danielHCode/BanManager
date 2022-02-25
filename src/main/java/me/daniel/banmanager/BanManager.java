package me.daniel.banmanager;

import me.daniel.banmanager.log.Logger;
import org.bukkit.plugin.java.JavaPlugin;

public final class BanManager extends JavaPlugin {

    private static BanManager plugin;

    public static BanManager getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;
        Logger.log("Plugin loading");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
