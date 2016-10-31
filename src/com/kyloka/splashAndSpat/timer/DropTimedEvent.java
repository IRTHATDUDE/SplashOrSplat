package com.kyloka.splashAndSpat.timer;

import com.kyloka.splashAndSpat.Main;
import com.kyloka.splashAndSpat.arena.RegisterArenas;
import com.kyloka.splashAndSpat.game.GameState;
import com.kyloka.splashAndSpat.objects.Arena;
import com.kyloka.splashAndSpat.objects.PlayerUser;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;
import java.util.Random;

/**
 * Created by Matthew on 10/27/2016.
 */
public class DropTimedEvent extends BukkitRunnable {
    boolean x = false;
    Arena[] arenaArray = {RegisterArenas.getArena1(),RegisterArenas.getArena2(),RegisterArenas.getArena3(),RegisterArenas.getArena4()};

    @Override
    public void run() {

        for(int g = 0; g<arenaArray.length; g++){
            PlayerUser playerUser = arenaArray[g].getPlayerList();
            List<Player> playerList = arenaArray[g].getPlayerList().getUserList();
            if (arenaArray[g].getGameState() == GameState.STARTED) {
                int i = 0;
                for (Player player : playerList) {
                    i++;
                    if (!x && i == 1) {

                        if (arenaArray[g].getFirstTurn()) {
                            arenaArray[g].setFirstTurn(false);
                            playerUser.setTurn(playerList.get(i), true);
                            playerUser.setTurn(player, false);
                            x = routine(arenaArray[g],player,i);
                            break;
                        }
                    }
                    if (!x && playerUser.isTurn(player) && playerUser.hasLanded(player)) {
                        x = routine(arenaArray[g],player,i);
                        break;
                    }
                }
                if (x) {
                    arenaArray[g].removeDropBlocks();
                    final int gg = i;
                    x = false;Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                        @Override
                        public void run() {
                            if (gg == playerList.size()) {
                                playerUser.setTurn(playerList.get(0), true);

                            } else {
                                playerUser.setTurn(playerList.get(gg), true);

                            }


                        }
                    },20*5);

                }
            }

        }
    }
    public boolean routine(Arena arena,Player player,int i){
        final int b =  i;
        PlayerUser playerUser = arena.getPlayerList();
        List<Player> playerList = arena.getPlayerList().getUserList();
        int one = 20;
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage(player.getName() + " is dropping in 3");
            }
        }, one * 1);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage("2");
            }
        }, one * 2);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage("1");
            }
        }, one * 3);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {

                Bukkit.broadcastMessage(player.getName() + " is dropping");
                arena.resetDropArea();
                playerUser.setLanded(player, false);
                playerUser.setTurn(player, false);
                player.teleport(arena.getDropLoc1());

            }
        }, one * 4);

        return true;
    }
}
