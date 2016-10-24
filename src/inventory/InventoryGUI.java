package inventory;

import com.kyloka.splashAndSpat.Main;
import com.kyloka.splashAndSpat.woolControl.ColoredWool;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
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
    public InventoryGUI(int inventoryAmt){
        if(inventoryAmt<9){
            this.guiAmt = 9;
        }
        else{
            this.guiAmt = 18;
        }
        this.inventoryAmt = inventoryAmt;
    }
    @SuppressWarnings("deprecation")
    public void setInventory(){

        Inventory tempInv = Bukkit.createInventory(null,guiAmt,"Choose a block!");
        List<ItemStack> listOfWool = new ArrayList<>();
        for(ColoredWool cw: ColoredWool.values()){
            listOfWool.add(cw.getColorOrder(),cw.toItemStack());
            tempInv.setItem(cw.getColorOrder(),cw.toItemStack());
        }
        ItemStack[] placeHolderList;
        switch(inventoryAmt) {
            case 10:
                //{
                 placeHolderList = listOfWool.toArray(new ItemStack[listOfWool.size()]);

                Bukkit.getPlayer("nayoshi12").sendMessage(placeHolderList[0].toString());
                break;
                // }
            case 9:

                placeHolderList = listOfWool.toArray(new ItemStack[listOfWool.size()]);

                Bukkit.getPlayer("nayoshi12").sendMessage(placeHolderList[0].toString());
            default:
                Main.getInstance().getLogger().info("Error in ln 46");
                break;
        }

        inv = tempInv;

    }
    public Inventory getInv(){
        return inv;
    }




}
