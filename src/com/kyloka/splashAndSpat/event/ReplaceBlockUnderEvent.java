package com.kyloka.splashAndSpat.event;

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

        if(blockBelow.getType().equals(Material.GLOWSTONE)&&blockBelow.getY() == 3){
            blockBelow.setType(Material.WOOL);
        }
        if(blockBelow.getType().equals(Material.WOOL)&&blockBelow.getY() == 3){
            player.teleport(new Location(tempLoc.getWorld(),-421,3,121));
        }
    }
}
