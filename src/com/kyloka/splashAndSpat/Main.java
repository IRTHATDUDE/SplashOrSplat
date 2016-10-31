package com.kyloka.splashAndSpat;

import com.kyloka.splashAndSpat.arena.RegisterArenas;
import com.kyloka.splashAndSpat.command.Command;
import com.kyloka.splashAndSpat.config.Configuration;
import com.kyloka.splashAndSpat.event.Event;
import com.kyloka.splashAndSpat.game.GameState;
import com.kyloka.splashAndSpat.timer.TimeRegister;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Matthew on 10/13/2016.
 */
public class Main extends JavaPlugin {
    private static Main instance;
    @Override
    public void onEnable() {


        instance = this;
        Configuration config = new Configuration();
        config.loadAllConfig();
        RegisterArenas registerArenas = new RegisterArenas();
        registerArenas.registerArena();
        Command myCmd = new Command();
        TimeRegister.registerTimedEvents();
        myCmd.registerCommands();
        Event.registerEvents();


    }


    public static void log(String log){instance.getLogger().info(log);}
    public static Main getInstance(){
        return instance;
    }
}
