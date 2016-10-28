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
        Arena arena1 = RegisterArenas.getArena1();
        GameState arena1GameState = arena1.getGameState();
        if((arena1GameState == GameState.WAITING)){
            PlayerUser playerUser = arena1.getPlayerList();
            List<Player> playerList = playerUser.getUserList();
            int i = 0;
            for(Player p: playerList){
                i++;
                    if(arena1.getGameState()==GameState.WAITING){
                        if(i==1 && playerUser.getColoredWoolList().get(p)== null&&playerList.size()!=1){
                            p.openInventory(arena1.getGui().getInv());
                            playerUser.setTurn(p,false);
                            playerUser.setTurn(playerList.get(i),true);
                            break;
                        }

                        if(playerUser.isTurn(p)){
                            Bukkit.broadcastMessage("hi:5");
                            p.openInventory(arena1.getGui().getInv());
                            playerUser.setTurn(p,false);
                            playerUser.setTurn(playerList.get(i).getPlayer(),true);
                        }
                    }


            }
        }
    }
}
