package com.kyloka.splashAndSpat.command;

import com.kyloka.splashAndSpat.Main;
import com.kyloka.splashAndSpat.exception.PlayerOnListException;
import com.kyloka.splashAndSpat.game.GameList;
import com.kyloka.splashAndSpat.game.GameState;
import com.kyloka.splashAndSpat.objects.PlayerUser;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

import java.util.logging.Level;

/**
 * Created by Matthew on 10/16/2016.
 */
public class SSJoin implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        GameState derp = new GameState();
        if(!(sender instanceof Player)){
            sender.sendMessage(ChatColor.RED + "Cannot send this command through console");
            return false;
        }
        Player player = (Player)sender;
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
        player.sendMessage("You");
        PlayerUser test = new PlayerUser();
        try{
            test.removePlayer(player);
        }
        catch(PlayerOnListException e){
            player.sendMessage("You are already in the game");
            e.printStackTrace();
        }


        return false;
    }
}
