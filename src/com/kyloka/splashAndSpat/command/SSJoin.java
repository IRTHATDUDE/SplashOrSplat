package com.kyloka.splashAndSpat.command;

import com.kyloka.splashAndSpat.Main;
import com.kyloka.splashAndSpat.arena.RegisterArenas;
import com.kyloka.splashAndSpat.config.Configuration;
import com.kyloka.splashAndSpat.exception.PlayerOnListException;
import com.kyloka.splashAndSpat.game.GameState;
import com.kyloka.splashAndSpat.objects.Arena;
import com.kyloka.splashAndSpat.objects.PlayerUser;
import com.kyloka.splashAndSpat.woolControl.ColoredWool;
import inventory.InventoryGUI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.*;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.logging.Level;

/**
 * Created by Matthew on 10/16/2016.
 */
public class SSJoin implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(!(sender instanceof Player)){
            sender.sendMessage(ChatColor.RED + "Cannot send this command through console");
            return false;
        }
        Player player = (Player)sender;
        Arena arena1 = new RegisterArenas().getArena1();
        //player.sendMessage(new RegisterArenas().getArena1().getDropLoc1().toString());
        if(args.length == 0){
            sender.sendMessage(ChatColor.RED + "You need to specify the arena you want to join in! Arenas Are: Alpha, Delta, Phi, Omega");
            return false;
        }
        Location lobby = arena1.getLobbyLoc();
        if(args[0].equalsIgnoreCase("Alpha")){
            player.teleport(new Location(lobby.getWorld(),lobby.getX(),lobby.getY(),lobby.getZ(),lobby.getYaw(),lobby.getPitch()));
        }
        else{

        }
        InventoryGUI xD = RegisterArenas.getArena1().getGui();

        player.openInventory(xD.getInv());
        player.sendMessage(ColoredWool.values().length + "");
        try {
            RegisterArenas.getArena1().getPlayerList().addPlayer(player);
        }
        catch(PlayerOnListException e){
            e.printStackTrace();
        }
        return true;
    }

}
