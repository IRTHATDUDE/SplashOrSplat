package com.kyloka.splashAndSpat.event;

import com.kyloka.splashAndSpat.Main;
import org.bukkit.plugin.PluginManager;

/**
 * Created by Matthew on 10/15/2016.
 */
public class Event  {
    public static void registerEvents(){

        PluginManager pm = Main.getInstance().getServer().getPluginManager();
        pm.registerEvents(new ReplaceBlockUnderEvent(), Main.getInstance());
        pm.registerEvents(new SelectBlockEvent(), Main.getInstance());

    }

}
