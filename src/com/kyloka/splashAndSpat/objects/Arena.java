package com.kyloka.splashAndSpat.objects;

import java.util.ArrayList;
import java.util.List;

import com.kyloka.splashAndSpat.config.Configuration;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;

public class Arena {
	private String name;
	private List<PlayerUser> playerUserList = new ArrayList<>();
	private List<Block> blockList = new ArrayList<>();
	private List<BlockState> blockStateList = new ArrayList<>();
	private Location lobbyLoc1,lobbyLoc2,dropLoc1,dropLoc2,fallLoc1,fallLoc2;
	public Arena(String name){
		this.name = name;
	}
	private Configuration config = new Configuration();
	public String getName(){
		return name;
	}
	public void setPlayerUserList(List<PlayerUser> tempList){
		this.playerUserList = tempList;
	}
	public List<PlayerUser> getPlayerUserList(){
		return playerUserList;
	}

	public void setLobbyLoc1(Location loc1){
		lobbyLoc1 = loc1;
		config.getDataConfig().set("0.lobby.x","lmao");
		config.getDataConfig().set("0.lobby.y","lmao");
		config.getDataConfig().set("0.lobby.z",loc1.getZ());
		config.getDataConfig().set("0.lobby.world",loc1.getWorld());
		config.saveDataConfig();
	}
	public void setLobbyLoc2(Location loc2){
		lobbyLoc2 = loc2;
	}
	public void setDropLoc1(Location loc1){
		dropLoc1 = loc1;
	}
	public void setDropLoc2(Location loc2){
		dropLoc2 = loc2;
	}
	public void setFallLoc1(Location loc1){
		fallLoc1 = loc1;
	}
	public void setFallLoc2(Location loc2){
		fallLoc2 = loc2;
	}
	public Location getLobbyLoc1(){
		return lobbyLoc1;
	}
	public Location getLobbyLoc2(){
		return lobbyLoc2;
	}
	public Location getDropLoc1(){
		return dropLoc1;
	}
	public Location getDropLoc2(){
		return dropLoc2;
	}
	public Location getFallLoc1(){
		return fallLoc1;
	}
	public Location getFallLoc2(){
		return fallLoc2;
	}
	
}
