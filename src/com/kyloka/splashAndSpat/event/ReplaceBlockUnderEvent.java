package com.kyloka.splashAndSpat.event;

import com.kyloka.splashAndSpat.arena.RegisterArenas;
import com.kyloka.splashAndSpat.game.GameState;
import com.kyloka.splashAndSpat.objects.Arena;
import com.kyloka.splashAndSpat.objects.PlayerUser;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerVelocityEvent;

/**
 * Created by Matthew on 10/15/2016.
 */
public class ReplaceBlockUnderEvent implements Listener {
    @EventHandler
    public void replaceBlock(PlayerMoveEvent e){
        Player player = e.getPlayer();
        Location tempLoc = player.getLocation();

        Block  blockBelow = tempLoc.getBlock().getRelative(BlockFace.DOWN);

        //player.sendMessage("The block below you is a " + blockBelow.getType());
        Arena arena1 = RegisterArenas.getArena1();
        PlayerUser playerList1 = arena1.getPlayerList();

        if(blockBelow.getType()==Material.SEA_LANTERN && arena1.getPlayerList().isPlayerOnList(player)&&arena1.getGameState() == GameState.STARTED&&arena1.getFallLoc1().getY()==blockBelow.getY()+1){
            tempLoc.getBlock().setType(playerList1.getColoredWool(player).toItemStack().getType());
            tempLoc.getBlock().setData(playerList1.getColoredWool(player).getDataColor());


        }
        if(blockBelow.getType()==Material.SEA_LANTERN && arena1.getPlayerList().isPlayerOnList(player)&&arena1.getGameState() == GameState.STARTED&&arena1.getFallLoc1().getY()==blockBelow.getY()+1){
            player.teleport(arena1.getLobbyLoc());
        }
        if(blockBelow.getType()==Material.WOOL&&!(blockBelow.getData() == playerList1.getColoredWool(player).getDataColor())&&blockBelow.getY() == arena1.getFallLoc1().getY()&&arena1.getGameState() == GameState.STARTED){
            player.sendMessage("You are out");
        }
    }
}
