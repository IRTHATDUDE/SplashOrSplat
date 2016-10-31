package com.kyloka.splashAndSpat.event;

import com.kyloka.splashAndSpat.arena.RegisterArenas;
import com.kyloka.splashAndSpat.exception.PlayerOnListException;
import com.kyloka.splashAndSpat.game.GameState;
import com.kyloka.splashAndSpat.objects.Arena;
import com.kyloka.splashAndSpat.objects.PlayerUser;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerVelocityEvent;

/**
 * Created by Matthew on 10/15/2016.
 */
public class ReplaceBlockUnderEvent implements Listener {
    @EventHandler
    public void replaceBlock(PlayerMoveEvent e){
        Player player = e.getPlayer();
        Location tempLoc = player.getLocation();
        Arena[] arenaArray = {RegisterArenas.getArena1(), RegisterArenas.getArena2(), RegisterArenas.getArena3(), RegisterArenas.getArena4()};

        Block  blockBelow = tempLoc.getBlock().getRelative(BlockFace.DOWN);

        //player.sendMessage("The block below you is a " + blockBelow.getType());
        for(Arena arena:arenaArray){
            PlayerUser playerList1 = arena.getPlayerList();

            if(arena.getGameState()==GameState.STARTED){
                if(!arena.getPlayerList().isPlayerOnList(player)){
                    return;
                }//check if they are in the Game itself

                if(arena.getPlayerList().getUserList().size()==1){
                    arena.setGameState(GameState.END);
                    Bukkit.broadcastMessage(arena.getPlayerList().getUserList().get(0).getName() + " has won the game!");
                    Player playera = playerList1.getUserList().get(0);
                    try{
                        playera.teleport(playerList1.getPrevCoords(playera));
                    }catch(PlayerOnListException ex){
                        ex.printStackTrace();
                    }
                }//If there is only one person, and the game started, then they win
                if(arena.getFallLoc1().getY()==blockBelow.getY()+1){
                    if(blockBelow.getType()==Material.SEA_LANTERN){
                        tempLoc.getBlock().setType(playerList1.getColoredWool(player).toItemStack().getType());
                        tempLoc.getBlock().setData(playerList1.getColoredWool(player).getDataColor());
                        Bukkit.broadcastMessage(player.getName());
                        player.teleport(arena.getLobbyLoc());
                        arena.getPlayerList().setLanded(player,true);
                    }//if the material is sea lantern then place shit there

                }
                else{
                    if(blockBelow.getType()==Material.WOOL){
                        if(blockBelow.getData()==arena.getPlayerList().getColoredWool(player).getDataColor()){
                            player.sendMessage("You are out");
                            Bukkit.broadcastMessage(player.getName() + " is out of Splash and Splat");
                            try{
                                player.teleport(arena.getPlayerList().getPrevCoords(player));
                                arena.getPlayerList().removePlayer(player);
                            }
                            catch(PlayerOnListException ex){
                                ex.printStackTrace();
                            }
                        }
                        else if(blockBelow.getData()==arena.getPlayerList().getColoredWool(player).getDataColor()){
                            player.teleport(arena.getLobbyLoc());
                            arena.getPlayerList().setLanded(player,true);
                        }
                    }
                }

            }

        }

    }
}
