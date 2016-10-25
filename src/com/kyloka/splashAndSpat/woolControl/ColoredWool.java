package com.kyloka.splashAndSpat.woolControl;

import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Created by Matthew on 10/24/2016.
 */
@SuppressWarnings("deprecation")
public enum ColoredWool {

        RED(0, DyeColor.RED.getWoolData()),
        ORANGE(1, DyeColor.ORANGE.getWoolData()),
        YELLOW(2, DyeColor.YELLOW.getWoolData()),
        GREEN(3, DyeColor.GREEN.getWoolData()),
        BLUE(4, DyeColor.BLUE.getWoolData()),
        LIGHTBLUE(5, DyeColor.LIGHT_BLUE.getWoolData()),
        PURPLE(6, DyeColor.PURPLE.getWoolData()),
        WHITE(7, DyeColor.WHITE.getWoolData()),
        BROWN(8, DyeColor.BROWN.getWoolData()),
        BLACK(9, DyeColor.BLACK.getWoolData());
    private int colorOrder;
    private byte dataColor;
    private ColoredWool(int order,byte color){
        colorOrder = order;
        dataColor = color;
    }

    public int getColorOrder() {
        return colorOrder;
    }

    public byte getDataColor() {
        return dataColor;
    }
    public ItemStack toItemStack(){
        ItemStack wool;
        wool = new ItemStack(Material.WOOL,1,dataColor);
        ItemMeta woolMeta = wool.getItemMeta();
        woolMeta.setDisplayName(colorOrder + "");
        wool.setItemMeta(woolMeta);

        return wool;
    }
}
