package com.kyloka.splashAndSpat.timer;

import com.kyloka.splashAndSpat.arena.RegisterArenas;
import com.kyloka.splashAndSpat.game.GameState;
import com.kyloka.splashAndSpat.objects.Arena;
import com.kyloka.splashAndSpat.objects.PlayerUser;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

/**
 * Created by Matthew on 10/26/2016.
 */
public class ChooseBlockTimedEvent extends BukkitRunnable {
    @Override
    public void run() {
        Arena[] arenaArray = {RegisterArenas.getArena1(),RegisterArenas.getArena2(),RegisterArenas.getArena3(),RegisterArenas.getArena4()};
        for(Arena arena:arenaArray){
            GameState arena1GameState = arena.getGameState();
            if((arena1GameState == GameState.WAITING)){
                PlayerUser playerUser = arena.getPlayerList();
                List<Player> playerList = playerUser.getUserList();
                int i = 0;
                for(Player p: playerList){
                    i++;
                    if(arena.getGameState()==GameState.WAITING){
                        if(i==1 && playerUser.getColoredWool(p)==null &&playerList.size()!=1){
                            p.openInventory(arena.getGui().getInv());
                            break;
                        }
                        if(i>1&&
                                playerUser.getColoredWool(p)==null&&
                                playerList.size()==i){
                            p.openInventory(arena.getGui().getInv());
                            break;
                        }
                    }


                }
            }
        }

    }
}
