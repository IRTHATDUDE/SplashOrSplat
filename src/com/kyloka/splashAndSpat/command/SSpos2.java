package com.kyloka.splashAndSpat.command;

import com.kyloka.splashAndSpat.Main;
import com.kyloka.splashAndSpat.arena.RegisterArenas;
import com.kyloka.splashAndSpat.objects.Arena;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.*;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

import java.util.logging.Level;

/**
 * Created by Matthew on 10/22/2016.
 */
public class SSpos2 implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(!(sender instanceof Player)){
            Main.getInstance().getLogger().log(Level.WARNING,"You cannot run this command in console");
            return false;
        }

        Player player = (Player) sender;
        Location loc = player.getLocation();
        com.kyloka.splashAndSpat.command.Command myCmd = new com.kyloka.splashAndSpat.command.Command();
        Arena arena1 = RegisterArenas.getArena1();
        if(args.length==0){
            sender.sendMessage(ChatColor.RED + "available arguments are: lobby, drop, fall");
            return false;
        }
        if(args[0].equalsIgnoreCase("lobby")){
            sender.sendMessage(ChatColor.RED + "It's not necessary to register a second position for a lobby");
        }
        if(args[0].equalsIgnoreCase("drop")){
            arena1.setDropLoc2(loc);
            sender.sendMessage(ChatColor.GREEN + "Drop location 2 for Arena 1 has been set.");
            arena1.registerEachLocation();
        }
        if(args[0].equalsIgnoreCase("fall")){
            arena1.setFallLoc2(loc);
            sender.sendMessage(ChatColor.GREEN + "Fall location 2 for Arena 1 has been set.");
            arena1.registerEachLocation();
        }



        return false;
    }
}
