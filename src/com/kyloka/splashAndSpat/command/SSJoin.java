package com.kyloka.splashAndSpat.command;

import com.kyloka.splashAndSpat.Main;
import com.kyloka.splashAndSpat.arena.RegisterArenas;
import com.kyloka.splashAndSpat.config.Configuration;
import com.kyloka.splashAndSpat.exception.PlayerOnListException;
import com.kyloka.splashAndSpat.game.GameList;
import com.kyloka.splashAndSpat.game.GameState;
import com.kyloka.splashAndSpat.objects.PlayerUser;
import org.bukkit.Bukkit;
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

        if(!(sender instanceof Player)){
            sender.sendMessage(ChatColor.RED + "Cannot send this command through console");
            return false;
        }
        Player player = (Player)sender;
        new Configuration().loadDataConfig();
        //player.sendMessage(new RegisterArenas().getArena1().getDropLoc1().toString());
        player.sendMessage("hi");
        player.sendMessage(new Configuration().getDataConfig().getInt("Alpha.lobby.x") + "");

        return true;
    }
}
