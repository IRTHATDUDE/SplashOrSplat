package com.kyloka.splashAndSpat.event;

import com.kyloka.splashAndSpat.arena.RegisterArenas;
import com.kyloka.splashAndSpat.woolControl.ColoredWool;
import inventory.InventoryGUI;
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
        if (!ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase("potato"))
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
                    RegisterArenas.getArena1().getGui().removeWool(cw);
                    RegisterArenas.getArena1().getPlayerList().assignColoredWool(player,cw);
                    player.closeInventory();
                }
            }
        }


    }

}
