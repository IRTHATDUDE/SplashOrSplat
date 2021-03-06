package com.kyloka.splashAndSpat.command;

import com.kyloka.splashAndSpat.arena.RegisterArenas;
import com.kyloka.splashAndSpat.objects.Arena;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.*;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

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
        Arena arena1 = RegisterArenas.getArena1();
        Arena arena2 = RegisterArenas.getArena2();
        Arena arena3 = RegisterArenas.getArena3();
        Arena arena4 = RegisterArenas.getArena4();
        //player.sendMessage(new RegisterArenas().getArena1().getDropLoc1().toString());
        if(args.length == 0){
            sender.sendMessage(ChatColor.RED + "You need to specify the arena you want to join in! Arenas Are: Alpha, Delta, Phi, Omega");
            return false;
        }
        Location lobby = arena1.getLobbyLoc();
        Arena[] arenaArray = {RegisterArenas.getArena1(), RegisterArenas.getArena2(), RegisterArenas.getArena3(), RegisterArenas.getArena4()};
        for(Arena arena:arenaArray){
            if(args[0].equalsIgnoreCase(arena.getName())){
                arena.getPlayerList().setPrevCoords(player,player.getLocation());
                arena.registerEachLocation();
                player.teleport(arena.getLobbyLoc());
                arena.getPlayerList().addPlayer(player);
                arena.getPlayerList().setLanded(player,true);
                return true;
            }

        }
        /*if(args[0].equalsIgnoreCase("Alpha")){
            arena1.getPlayerList().setPrevCoords(player,player.getLocation());
            player.teleport(new Location(lobby.getWorld(),lobby.getX(),lobby.getY(),lobby.getZ(),lobby.getYaw(),lobby.getPitch()));

            arena1.getPlayerList().addPlayer(player);
            arena1.getPlayerList().setLanded(player,true);
        }
        else if(args[0].equalsIgnoreCase("Delta")){
            arena2.getPlayerList().setPrevCoords(player,player.getLocation());
            player.teleport(new Location(lobby.getWorld(),lobby.getX(),lobby.getY(),lobby.getZ(),lobby.getYaw(),lobby.getPitch()));
            arena2.getPlayerList().addPlayer(player);
            arena2.getPlayerList().setLanded(player,true);
        }
        else if(args[0].equalsIgnoreCase("Phi")){
            arena3.getPlayerList().setPrevCoords(player,player.getLocation());
            player.teleport(new Location(lobby.getWorld(),lobby.getX(),lobby.getY(),lobby.getZ(),lobby.getYaw(),lobby.getPitch()));
            arena3.getPlayerList().addPlayer(player);
            arena3.getPlayerList().setLanded(player,true);
        }
        else if(args[0].equalsIgnoreCase("Omega")){
            arena4.getPlayerList().setPrevCoords(player,player.getLocation());
            player.teleport(new Location(lobby.getWorld(),lobby.getX(),lobby.getY(),lobby.getZ(),lobby.getYaw(),lobby.getPitch()));
            arena4.getPlayerList().addPlayer(player);
            arena4.getPlayerList().setLanded(player,true);
        }
        */

            player.sendMessage("That Arena doesn't exist ;L");



        return true;
    }

}
