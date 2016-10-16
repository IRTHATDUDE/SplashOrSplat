package com.kyloka.splashAndSpat.command;

import com.kyloka.splashAndSpat.Main;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Matthew on 10/16/2016.
 */
public class Command {
    public static void registerCommands(){
        Main instance = Main.getInstance();
        instance.getCommand("ssjoin").setExecutor(new SSJoin());
    }
}
