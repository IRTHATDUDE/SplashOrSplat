package com.kyloka.splashAndSpat.exception;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Matthew on 10/22/2016.
 */
public class SenderNotAPlayerException extends Exception {
    private CommandSender sender;
    public SenderNotAPlayerException(CommandSender sender){
            this.sender = sender;
    }
    public CommandSender getSender(){
        return sender;
    }

}
