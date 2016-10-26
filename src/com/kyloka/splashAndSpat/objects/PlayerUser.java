package com.kyloka.splashAndSpat.objects;

import com.kyloka.splashAndSpat.Main;
import com.kyloka.splashAndSpat.exception.PlayerOnListException;
import com.kyloka.splashAndSpat.woolControl.ColoredWool;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Matthew on 10/16/2016.
 */
public class PlayerUser {
    private List<Player> listOfPlayers = new ArrayList<>();
    private HashMap<Player,Location> playerLocationHashMap = new HashMap<>();
    private HashMap<Player,ColoredWool> coloredWool = new HashMap<>();
    public void addPlayer(Player player) throws PlayerOnListException{
        if(listOfPlayers.contains(player)){
            throw new PlayerOnListException(player);
        }
        listOfPlayers.add(player);

    }
    public boolean isPlayerOnList(Player player){
        return listOfPlayers.contains(player);

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
    public List<Player> getUserList(){
        return listOfPlayers;
    }
    public Location getPrevCoords(Player player) throws PlayerOnListException{
        if(!listOfPlayers.contains(player)){
            throw new PlayerOnListException(player);
        }

        return playerLocationHashMap.get(player);
    }
    public HashMap<Player,ColoredWool> getColoredWoolList(){
        return coloredWool;
    }
    public void assignColoredWool(Player player, ColoredWool cw){
        coloredWool.put(player,cw);
    }
    public ColoredWool getColoredWool(Player player){
        return coloredWool.get(player);
    }

}
