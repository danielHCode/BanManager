package me.daniel.banmanager.config;

import me.daniel.banmanager.log.Logger;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.HashMap;

public class ConfigManager {
    private final String fileName;
    private final ConfigDefaultHandler error;

    public ConfigManager(String fileName, ConfigDefaultHandler error) {
        this.fileName = fileName;
        this.error = error;
    }

    public HashMap<String, Object> parseConfig() {
        return new Yaml().load(readConfig());
    }



    private void handleFileNotExist(File f) {
        try {
            f.createNewFile();
            var fos = new FileOutputStream(f);
            error.writeError(fos);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
            Logger.error("could not create config File '"+fileName+"'");
        }
    }

    private String readConfig() {
        File f = new File(fileName);

        if (!f.exists()) {
            Logger.warn("Config '"+fileName+"' does not exist. It will be created");
            handleFileNotExist(f);
        }

        try {
            var fis = new FileInputStream(f);
            var temp = new String(fis.readAllBytes());
            fis.close();
            return temp;
        } catch (Exception e) {
            e.printStackTrace();
            Logger.error("could not read config File '" + fileName + "'");
            return "";
        }
    }
}
