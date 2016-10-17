package com.kyloka.splashAndSpat.objects;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;

public class Arena {
	private String name;
	private List<PlayerUser> playerUserList = new ArrayList<>();
	private List<Block> blockList = new ArrayList<>();
	private List<BlockState> blockStateList = new ArrayList<>();
	private Location location1,location2;
	public Arena(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void setPlayerUserList(List<PlayerUser> tempList){
		this.playerUserList = tempList;
	}
	public List<PlayerUser> getPlayerUserList(){
		return playerUserList;
	}
	public void setLocation1(Location location1){
		this.location1 = location1;
	}
	public void setLocation2(Location location2){
		this.location2 = location2;
	}
	public Location getLocation1(){
		return location1;
	}
	public Location getLocation2(){
		return location2;
	}
	
}
