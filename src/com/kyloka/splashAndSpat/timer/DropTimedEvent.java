package com.kyloka.splashAndSpat.timer;

import com.kyloka.splashAndSpat.arena.RegisterArenas;
import com.kyloka.splashAndSpat.game.GameState;
import com.kyloka.splashAndSpat.objects.Arena;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Created by Matthew on 10/27/2016.
 */
public class DropTimedEvent extends BukkitRunnable {
    @Override
    public void run() {
        Arena arena1 = RegisterArenas.getArena1();
        if(arena1.getGameState()== GameState.STARTED){
            //if player is number 1, then after they fall the next one gets tped
        }
    }
}
