package com.kyloka.splashAndSpat.command;

import com.kyloka.splashAndSpat.Main;
import com.kyloka.splashAndSpat.objects.Arena;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Matthew on 10/16/2016.
 */
public class Command {
    private Arena arena0 = new Arena("1");
    public void registerCommands(){
        Main instance = Main.getInstance();
        instance.getCommand("ssjoin").setExecutor(new SSJoin());
        instance.getCommand("sspos1").setExecutor(new SSpos1());
    }

    public Arena getArena0(){
        return arena0;
    }
}
