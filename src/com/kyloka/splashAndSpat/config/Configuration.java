package com.kyloka.splashAndSpat.config;

import com.kyloka.splashAndSpat.Main;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by Matthew on 10/22/2016.
 */
public class Configuration {
    private static File pluginFolder = Main.getInstance().getDataFolder();
    private static File dataFile = new File(pluginFolder, "data.yml");
    private static Logger logger = Main.getInstance().getLogger();
    static Configuration instance;
    private static YamlConfiguration dataConfig = new YamlConfiguration();

    public static void loadAllConfig() {

        try {
            if (!pluginFolder.exists()) {
                pluginFolder.mkdir();
            }
            if (!dataFile.exists()) {
                dataFile.createNewFile();
                dataConfig.load(dataFile);


            }
            dataConfig.load(dataFile);
        } catch (IOException io) {
            io.printStackTrace();
        } catch (InvalidConfigurationException ex) {
            ex.printStackTrace();
        }

    }

    public static void loadDataConfig(){
        try{dataConfig.load(dataFile);}catch(Exception e) {e.printStackTrace();}
    }
    public static void saveDataConfig() {
        try {
            dataConfig.save(dataFile);
        }
        catch (IOException io) {
            io.printStackTrace();
        }
    }

    public static YamlConfiguration getDataConfig() {
        return dataConfig;
    }
}
