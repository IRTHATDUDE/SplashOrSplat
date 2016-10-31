package com.kyloka.splashAndSpat.command;

import com.kyloka.splashAndSpat.arena.RegisterArenas;
import com.kyloka.splashAndSpat.game.GameState;
import com.kyloka.splashAndSpat.objects.Arena;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

/**
 * Created by Matthew on 10/26/2016.
 */
public class SSreset implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage(ChatColor.RED + "Cannot send command in Console");
            return false;
        }
        Player player = (Player) sender;
        Arena[] arenaArray = {RegisterArenas.getArena1(), RegisterArenas.getArena2(), RegisterArenas.getArena3(), RegisterArenas.getArena4()};

        if(args.length==0){
            sender.sendMessage("You need to specify a arena. Available arenas are: "+ arenaArray[0].getName() + ", " +
                    arenaArray[1].getName() + ", "
                    + arenaArray[2].getName() + ", "
                    + arenaArray[3].getName());
            return false;
        }
        for(Arena arena:arenaArray){
            if(args[0].equalsIgnoreCase(arena.getName())){
                arena.resetArena();
                arena.setGameState(GameState.WAITING);
            }
        }
        return false;
    }
}
