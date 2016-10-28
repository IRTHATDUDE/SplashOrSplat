package com.kyloka.splashAndSpat.command;

import com.kyloka.splashAndSpat.Main;
import com.kyloka.splashAndSpat.objects.Arena;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Matthew on 10/16/2016.
 */
public class Command {

    public void registerCommands(){
        Main instance = Main.getInstance();
        instance.getCommand("ssjoin").setExecutor(new SSJoin());
        instance.getCommand("sspos1").setExecutor(new SSpos1());
        instance.getCommand("sspos2").setExecutor(new SSpos2());
        instance.getCommand("ssstart").setExecutor(new SSStart());
        instance.getCommand("ssstop").setExecutor(new SSStop());
        instance.getCommand("ssreset").setExecutor(new SSreset());
        instance.getCommand("ssleave").setExecutor(new SSleave());
    }


}
