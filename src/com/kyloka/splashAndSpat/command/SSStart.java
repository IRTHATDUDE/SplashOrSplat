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
        Arena[] arenaArray = {RegisterArenas.getArena1(), RegisterArenas.getArena2(), RegisterArenas.getArena3(), RegisterArenas.getArena4()};
        if(args.length==0){
            sender.sendMessage(ChatColor.RED + "You need to select an Arena. Arena list: Alpha, Delta, Phi, Omega");
            return false;
        }

        for(Arena arena:arenaArray){
            if(args[0].equalsIgnoreCase(arena.getName())){
                if(arena.getGameState()==GameState.STARTED){
                    sender.sendMessage("The game already started!");
                    return false;
                }
                if(arena.getGameState() == GameState.WAITING){
                    sender.sendMessage("The game is starting");
                    arena.setGameState(GameState.STARTED);
                }
            }
        }
        return true;
    }
}
