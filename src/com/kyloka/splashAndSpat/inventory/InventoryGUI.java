package com.kyloka.splashAndSpat.inventory;

import com.kyloka.splashAndSpat.Main;
import com.kyloka.splashAndSpat.woolControl.ColoredWool;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matthew on 10/24/2016.
 */
public class InventoryGUI {
    private int inventoryAmt;
    private int guiAmt;
    private Inventory inv;
    private String name;
    List<ItemStack> listOfWool = new ArrayList<>();
    public InventoryGUI(int inventoryAmt){
        if(inventoryAmt<9){
            this.guiAmt = 9;
        }
        else{
            this.guiAmt = 18;
        }
        this.inventoryAmt = inventoryAmt;
        for(ColoredWool cw: ColoredWool.values()){
            addWool(cw);
        }

    }
    public void setName(String name){
        this.name = name;
    }

    @SuppressWarnings("deprecation")
    public void addWool(ColoredWool cw){
        listOfWool.add(cw.getColorOrder(),cw.toItemStack());
    }
    public void removeWool(ColoredWool cw){
        if(listOfWool.contains(cw.toItemStack())) {
            listOfWool.remove(cw.toItemStack());
        }
        else{
            Main.getInstance().getLogger().info("You cannot select block");
        }
    }
    public Inventory getInv(){
        Inventory inv = Bukkit.createInventory(null,guiAmt,name);
        for(int i = 0; i<listOfWool.size();i++){
            if(listOfWool.get(i) == null){
                inv.setItem(i,new ItemStack(Material.STAINED_GLASS_PANE));
            }
            else {
                inv.addItem(listOfWool.get(i));
            }
        }

        return inv;
    }




}
