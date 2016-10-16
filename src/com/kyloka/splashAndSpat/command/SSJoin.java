package com.kyloka.splashAndSpat.command;

import com.kyloka.splashAndSpat.game.GameList;
import com.kyloka.splashAndSpat.game.GameState;
import org.bukkit.command.*;
import org.bukkit.command.Command;

/**
 * Created by Matthew on 10/16/2016.
 */
public class SSJoin implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        GameState derp = new GameState();
        derp.setState(GameList.Waiting);

        if(derp.isState(GameList.Waiting)){
            sender.sendMessage("We are waiting for the players to join");
        }
        if(derp.isState(GameList.STARTING)){
            sender.sendMessage("Game is starting soon");
        }
        if(derp.isState(GameList.STARTED)){
            sender.sendMessage("The Game already started");
        }
        if(derp.isState(GameList.END)){
            sender.sendMessage("The game ended");
        }

        return false;
    }
}
