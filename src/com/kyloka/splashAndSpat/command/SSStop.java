package com.kyloka.splashAndSpat.command;

import com.kyloka.splashAndSpat.arena.RegisterArenas;
import com.kyloka.splashAndSpat.game.GameState;
import org.bukkit.command.*;
import org.bukkit.command.Command;

/**
 * Created by Matthew on 10/26/2016.
 */
public class SSStop implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        RegisterArenas.getArena1().setGameState(GameState.END);
        return false;
    }
}
