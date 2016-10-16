package com.kyloka.splashAndSpat.exception;

import org.bukkit.entity.Player;

/**
 * Created by Matthew on 10/16/2016.
 */
public class PlayerOnListException extends Exception {
    private Player player;
    public PlayerOnListException(Player player){
        this.player = player;
    }
    public Player getPlayer(){
        return player;
    }
}
