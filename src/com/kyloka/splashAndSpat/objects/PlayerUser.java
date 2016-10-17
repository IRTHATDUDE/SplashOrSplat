package com.kyloka.splashAndSpat.objects;

import com.kyloka.splashAndSpat.Main;
import com.kyloka.splashAndSpat.exception.PlayerOnListException;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Matthew on 10/16/2016.
 */
public class PlayerUser {
    private List<Player> listOfPlayers = new ArrayList<>();
    private HashMap<Player,Location> playerLocationHashMap = new HashMap<>();
    public void addPlayer(Player player) throws PlayerOnListException{
        if(listOfPlayers.contains(player)){
            throw new PlayerOnListException(player);
        }
        listOfPlayers.add(player);

    }
    public void removePlayer(Player player)throws PlayerOnListException{
        if(!listOfPlayers.contains(player)){
            throw new PlayerOnListException(player);
        }
        int tempInt = listOfPlayers.indexOf(player);
        listOfPlayers.remove(tempInt);

    }
    public void setPrevCoords(Location loc,Player player)throws PlayerOnListException{
        if(!listOfPlayers.contains(player)){
            throw new PlayerOnListException(player);
        }
        playerLocationHashMap.put(player,loc);

    }
    public Location getPrevCoords(Player player) throws PlayerOnListException{
        if(!listOfPlayers.contains(player)){
            throw new PlayerOnListException(player);
        }

        return playerLocationHashMap.get(player);
    }

}
