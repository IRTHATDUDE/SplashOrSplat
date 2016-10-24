package com.kyloka.splashAndSpat.command;

import com.kyloka.splashAndSpat.Main;
import com.kyloka.splashAndSpat.arena.RegisterArenas;
import com.kyloka.splashAndSpat.exception.SenderNotAPlayerException;
import com.kyloka.splashAndSpat.objects.Arena;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.*;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

import java.util.logging.Level;

/**
 * Created by Matthew on 10/20/2016.
 */
public class SSpos1 implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(!(sender instanceof Player)){
            Main.getInstance().getLogger().log(Level.WARNING,"You cannot run this command in console");
            return false;
        }

        Player player = (Player) sender;
        Location loc = player.getLocation();
        com.kyloka.splashAndSpat.command.Command myCmd = new com.kyloka.splashAndSpat.command.Command();
        Arena arena1 = new RegisterArenas().getArena1();
        if(args.length==0){
            sender.sendMessage(ChatColor.RED + "available arguments are: lobby, drop, fall");
            return false;
        }
        if(args[0].equals("lobby")){
            arena1.setLobbyLoc(loc);
            sender.sendMessage(ChatColor.GREEN + "Lobby join location has been set");
        }


        return false;
    }


}
