package com.kyloka.splashAndSpat.event;

import com.kyloka.splashAndSpat.arena.RegisterArenas;
import com.kyloka.splashAndSpat.exception.PlayerOnListException;
import com.kyloka.splashAndSpat.objects.Arena;
import com.kyloka.splashAndSpat.woolControl.ColoredWool;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Created by Matthew on 10/25/2016.
 */
public class PlayerLeaveEvent implements Listener {
    @EventHandler
    public void playerLeaveEvent(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        Arena[] arenaArray = {RegisterArenas.getArena1(), RegisterArenas.getArena2(), RegisterArenas.getArena3(), RegisterArenas.getArena4()};
        for (Arena arena : arenaArray) {
            if (arena.getPlayerList().isPlayerOnList(player)) {
                ColoredWool cw = arena.getPlayerList().getColoredWool(player);
                arena.getGui().addWool(cw);
                try {
                    arena.getPlayerList().removePlayer(player);
                    Bukkit.broadcastMessage(player.getName() + " has left Splash And Splat");
                } catch (PlayerOnListException ex) {
                    ex.printStackTrace();
                }

            }
        }
    }
}
