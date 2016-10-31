package com.kyloka.splashAndSpat.command;

import com.kyloka.splashAndSpat.arena.RegisterArenas;
import com.kyloka.splashAndSpat.exception.PlayerOnListException;
import com.kyloka.splashAndSpat.objects.Arena;
import org.bukkit.command.*;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

/**
 * Created by Matthew on 10/28/2016.
 */
public class SSleave implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("You cannot leave an arena in console, why?");
            return false;
        }
        Arena arena1 = RegisterArenas.getArena1();
        Arena arena2 = RegisterArenas.getArena2();
        Arena arena3 = RegisterArenas.getArena3();
        Arena arena4 = RegisterArenas.getArena4();
        Player player = (Player) sender;
        boolean bool1= arena1.getPlayerList().isPlayerOnList(player);
        boolean bool2= arena2.getPlayerList().isPlayerOnList(player);
        boolean bool3= arena3.getPlayerList().isPlayerOnList(player);
        boolean bool4= arena4.getPlayerList().isPlayerOnList(player);
        player.sendMessage(bool1 + " " + bool2 + " " + bool3 +  " "+ bool4);
        if(bool1){
            player.sendMessage("You have been removed in Arena " + arena1.getName());
            try{
                player.teleport(arena1.getPlayerList().getPrevCoords(player));
                arena1.getGui().addWool(arena1.getPlayerList().getColoredWool(player));
                arena1.getPlayerList().removeColoredWool(player);
                arena1.getPlayerList().removePlayer(player);

            }catch (PlayerOnListException ex){
                ex.printStackTrace();
            }

            return true;
        }
        else if(bool4){
            player.sendMessage("You have been removed in Arena " + arena4.getName());
            try{
                player.teleport(arena4.getPlayerList().getPrevCoords(player));
                arena4.getGui().addWool(arena4.getPlayerList().getColoredWool(player));
                arena4.getPlayerList().removeColoredWool(player);
                arena4.getPlayerList().removePlayer(player);

            }catch (PlayerOnListException ex){
                ex.printStackTrace();
            }
            return true;
        }
        else if(bool2){
            player.sendMessage("You have been removed in Arena " + arena2.getName());
            try{
                player.teleport(arena2.getPlayerList().getPrevCoords(player));
                arena2.getGui().addWool(arena2.getPlayerList().getColoredWool(player));
                arena2.getPlayerList().removeColoredWool(player);
                arena2.getPlayerList().removePlayer(player);
            }catch (PlayerOnListException ex){
                ex.printStackTrace();
            }
            return true;
        }
        else if(bool3){
            player.sendMessage("You have been removed in Arena " + arena3.getName());
            try{
                player.teleport(arena1.getPlayerList().getPrevCoords(player));
                arena3.getGui().addWool(arena3.getPlayerList().getColoredWool(player));
                arena3.getPlayerList().removeColoredWool(player);
                arena3.getPlayerList().removePlayer(player);

            }catch (PlayerOnListException ex){
                ex.printStackTrace();
            }
            return true;
        }
        else{
            player.sendMessage("You are not in a game!");
        }
        return false;
    }
}
