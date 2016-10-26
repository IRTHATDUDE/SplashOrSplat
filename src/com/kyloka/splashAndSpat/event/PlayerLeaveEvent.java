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
    public void playerLeaveEvent(PlayerQuitEvent e){
        Player player = e.getPlayer();
        Arena arena1 = RegisterArenas.getArena1();
        if(arena1.getPlayerList().isPlayerOnList(player)){
            ColoredWool cw = arena1.getPlayerList().getColoredWool(player);
            arena1.getGui().addWool(cw);
            try {
                arena1.getPlayerList().removePlayer(player);
                Bukkit.broadcastMessage(player.getName() + " has left Splash And Splat");
            }catch(PlayerOnListException ex){
                ex.printStackTrace();
            }
        }
    }
}
