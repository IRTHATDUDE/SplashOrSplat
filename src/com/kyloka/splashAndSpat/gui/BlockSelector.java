package com.kyloka.splashAndSpat.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;

/**
 * Created by Matthew on 10/16/2016.
 */
public class BlockSelector {

    public void openGUI(){
        Inventory inv = Bukkit.createInventory(null,3, ChatColor.AQUA+"Pick a block!");

    }
}
