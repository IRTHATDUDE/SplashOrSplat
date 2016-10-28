package com.kyloka.splashAndSpat.command;

import com.kyloka.splashAndSpat.arena.RegisterArenas;
import org.bukkit.command.*;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

/**
 * Created by Matthew on 10/26/2016.
 */
public class SSreset implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        Player player = (Player) sender;
        player.sendMessage("hi");
        RegisterArenas.getArena1().resetArena();
        return false;
    }
}
