package com.kyloka.splashAndSpat.event;

import com.kyloka.splashAndSpat.arena.RegisterArenas;
import com.kyloka.splashAndSpat.objects.Arena;
import com.kyloka.splashAndSpat.woolControl.ColoredWool;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * Created by Matthew on 10/25/2016.
 */
public class SelectBlockEvent implements Listener {
    @EventHandler
    public void SelectBlockEvent(InventoryClickEvent e){
        Arena[] arenaArray = {RegisterArenas.getArena1(), RegisterArenas.getArena2(), RegisterArenas.getArena3(), RegisterArenas.getArena4()};
        for(Arena arena:arenaArray){
            if (!ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase(arena.getName()))
                return;
            Player player = (Player) e.getWhoClicked();
            e.setCancelled(true);
            if(e.getCurrentItem()==null||e.getCurrentItem().getType() == Material.AIR||!e.getCurrentItem().hasItemMeta()){
                player.closeInventory();
                player.updateInventory();
                return;
            }
            if(e.getCurrentItem().getType()== Material.WOOL&&e.getCurrentItem().getAmount() == 1){
                for(ColoredWool cw: ColoredWool.values()){
                    if(e.getCurrentItem().getData().getData() == cw.getDataColor()){
                        arena.getGui().removeWool(cw);
                        arena.getPlayerList().assignColoredWool(player,cw);
                        player.closeInventory();
                    }
                }
            }
        }


    }

}
