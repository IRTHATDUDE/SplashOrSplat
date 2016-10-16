package com.kyloka.splashAndSpat;

import com.kyloka.splashAndSpat.command.Command;
import com.kyloka.splashAndSpat.event.Event;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Matthew on 10/13/2016.
 */
public class Main extends JavaPlugin {
    private static Main instance;
    @Override
    public void onEnable() {
        instance = this;
        Event.registerEvents();
        Command.registerCommands();
    }
    public static Main getInstance(){
        return instance;
    }
}
