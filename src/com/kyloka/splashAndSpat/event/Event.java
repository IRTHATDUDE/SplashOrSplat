package com.kyloka.splashAndSpat.event;

import com.kyloka.splashAndSpat.Main;
import org.bukkit.plugin.PluginManager;

/**
 * Created by Matthew on 10/15/2016.
 */
public class Event  {
    public static void registerEvents(){
        Main instance = Main.getInstance();
        PluginManager pm = Main.getInstance().getServer().getPluginManager();
        pm.registerEvents(new ReplaceBlockUnderEvent(), instance);
        pm.registerEvents(new SelectBlockEvent(), instance);
        pm.registerEvents(new PlayerLeaveEvent(), instance);

    }

}
