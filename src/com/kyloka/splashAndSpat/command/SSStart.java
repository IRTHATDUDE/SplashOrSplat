package com.kyloka.splashAndSpat.command;

import com.kyloka.splashAndSpat.arena.RegisterArenas;
import com.kyloka.splashAndSpat.game.GameState;
import com.kyloka.splashAndSpat.objects.Arena;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

/**
 * Created by Matthew on 10/25/2016.
 */
public class SSStart implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("You must be a player to start a game");
            return false;
        }
        if(args.length==0){
            sender.sendMessage(ChatColor.RED + "You need to select an Arena. Arena list: Alpha, Delta, Phi, Omega");
            return false;
        }
        Arena arena1= RegisterArenas.getArena1();
        if(args[0].equalsIgnoreCase("alpha")){
            if(arena1.getGameState()==GameState.DROPPING||arena1.getGameState()==GameState.COUNTDOWN||arena1.getGameState()==GameState.STARTING){
                sender.sendMessage("The game already started!");
                return false;
            }
            if(arena1.getGameState() == GameState.WAITING){
                sender.sendMessage("The game is starting");
                arena1.setGameState(GameState.STARTING);
            }
        }
        return true;
    }
}
