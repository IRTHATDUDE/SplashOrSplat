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
                arena1.getPlayerList().removePlayer(player);
            }catch (PlayerOnListException ex){
                ex.printStackTrace();
            }
            return true;
        }
        else if(bool4){
            player.sendMessage("You have been removed in Arena " + arena4.getName());
            try{
                arena4.getPlayerList().removePlayer(player);
            }catch (PlayerOnListException ex){
                ex.printStackTrace();
            }
            return true;
        }
        else if(bool2){
            player.sendMessage("You have been removed in Arena " + arena2.getName());
            try{
                arena2.getPlayerList().removePlayer(player);
            }catch (PlayerOnListException ex){
                ex.printStackTrace();
            }
            return true;
        }
        else if(bool3){
            player.sendMessage("You have been removed in Arena " + arena3.getName());
            try{
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
