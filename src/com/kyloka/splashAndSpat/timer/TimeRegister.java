package com.kyloka.splashAndSpat.timer;

import com.kyloka.splashAndSpat.Main;
import org.bukkit.scheduler.BukkitTask;

/**
 * Created by Matthew on 10/26/2016.
 */
public class TimeRegister {
    public static void registerTimedEvents(){
        BukkitTask chooseBlock = new ChooseBlockTimedEvent().runTaskTimer(Main.getInstance(),0,10);
    }
}
