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
        Arena[] arenaArray = {RegisterArenas.getArena1(), RegisterArenas.getArena2(), RegisterArenas.getArena3(), RegisterArenas.getArena4()};
        for(Arena arena:arenaArray){
            if(args.length==0){
                sender.sendMessage(ChatColor.RED + "available arguments are: lobby, drop, fall");
                return false;
            }
            if(args.length==1){
                sender.sendMessage(ChatColor.RED + "available argument are: "+ arenaArray[0].getName() + ", " +
                        arenaArray[1].getName() + ", "
                        + arenaArray[2].getName() + ", "
                        + arenaArray[3].getName());
                return false;
            }
            if(args[1].equalsIgnoreCase(arena.getName())){
                if(args[0].equalsIgnoreCase("lobby")){
                    arena.setLobbyLoc(loc);
                    sender.sendMessage(ChatColor.GREEN + "Lobby join location has been set");
                    arena.registerEachLocation();
                }
                if(args[0].equalsIgnoreCase("drop")){
                    arena.setDropLoc1(loc);
                    sender.sendMessage(ChatColor.GREEN + "Drop location 1 for Arena 1 has been set.");
                    arena.registerEachLocation();
                }
                if(args[0].equalsIgnoreCase("fall")){
                    arena.setFallLoc1(loc);
                    sender.sendMessage(ChatColor.GREEN + "Fall location 1 for Arena 1 has been set.");
                    arena.registerEachLocation();
                }
            }




        }
        return false;
    }


}
