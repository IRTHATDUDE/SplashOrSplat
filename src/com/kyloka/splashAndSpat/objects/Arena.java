package com.kyloka.splashAndSpat.objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.kyloka.splashAndSpat.Main;
import com.kyloka.splashAndSpat.config.Configuration;
import com.kyloka.splashAndSpat.game.GameState;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.configuration.file.YamlConfiguration;

public class Arena {
	private String name;
	private List<PlayerUser> playerUserList = new ArrayList<>();
	private List<Block> blockList = new ArrayList<>();
	private List<BlockState> blockStateList = new ArrayList<>();
	private Location lobbyLoc1,lobbyLoc2,dropLoc1,dropLoc2,fallLoc1,fallLoc2;
	private Configuration config = new Configuration();
	private GameState gameState;
	//functions
	public Arena(String name){
		this.name = name;
	}
	public void setName(String name){
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

	public void setGameState(GameState gameState){
		this.gameState = gameState;
	}
	public GameState getGameState(){
		return gameState;
	}
	public void defaultConfig(){
		int loc1 = 0;
		String world = Main.getInstance().getServer().getWorlds().get(0).getName();
		config.getDataConfig().set(name + ".lobby.x",loc1);
		config.getDataConfig().set(name + ".lobby.y",loc1);
		config.getDataConfig().set(name + ".lobby.z",loc1);
		config.getDataConfig().set(name + ".lobby.world",world);
		Bukkit.getLogger().info("hi");
		config.getDataConfig().set(name + ".drop.loc1.x",loc1);
		config.getDataConfig().set(name + ".drop.loc1.y",loc1);
		config.getDataConfig().set(name + ".drop.loc1.z",loc1);
		config.getDataConfig().set(name + ".drop.loc1.world",world);
		config.getDataConfig().set(name + ".drop.loc2.x",loc1);
		config.getDataConfig().set(name + ".drop.loc2.y",loc1);
		System.out.print("idk");
		config.getDataConfig().set(name + ".drop.loc2.z",loc1);
		config.getDataConfig().set(name + ".drop.loc2.world",world);
		config.getDataConfig().set(name + ".fall.loc1.x",loc1);
		config.getDataConfig().set(name + ".fall.loc1.y",loc1);
		config.getDataConfig().set(name + ".fall.loc1.z",loc1);
		config.getDataConfig().set(name + ".fall.loc1.world",world);
		config.getDataConfig().set(name + ".fall.loc2.x",loc1);
		config.getDataConfig().set(name + ".fall.loc2.y",loc1);
		config.getDataConfig().set(name + ".fall.loc2.z",loc1);
		Bukkit.getLogger().info("hi");
		config.getDataConfig().set(name + ".fall.loc2.world",world);
		Bukkit.getLogger().info("hi");
		config.saveDataConfig();
	}
	public void registerEachLocation(){
		YamlConfiguration dataConfig = config.getDataConfig();
		String[] testArray = {"drop","fall"};
		String[] locArray = {"loc1","loc2"};
		double x = dataConfig.getDouble(name+".lobby.x");
		double y = dataConfig.getDouble(name+".lobby.y");
		double z = dataConfig.getDouble(name+".lobby.z");
		//World world = Bukkit.getServer().getWorld(config.getDataConfig().getString(name + ".lobby.world"));
		//lobbyLoc1 = new Location(world,x,y,z);

		List<Location> variableLoc = new ArrayList<>();
		//lobbyLoc1,lobbyLoc2,dropLoc1,dropLoc2,fallLoc1,fallLoc2
		/*
		variableLoc.add(dropLoc1);
		variableLoc.add(dropLoc2);
		variableLoc.add(fallLoc1);
		variableLoc.add(fallLoc2);
		for(int i = 0; i<testArray.length; i++){
			for(int h = 0; i<locArray.length; h++){
				x = dataConfig.getDouble(name +"."+ testArray[i] + "." + locArray[h] + ".x");
				y = dataConfig.getDouble(name +"."+ testArray[i] + "." + locArray[h] + ".y");
				z = dataConfig.getDouble(name +"."+ testArray[i] + "." + locArray[h] + ".z");
				world  = Bukkit.getWorld(dataConfig.getString(name +"."+ testArray[i] + "." + locArray[h] + ".world"));
				variableLoc.get(i+h).setX(x);
				variableLoc.get(i+h).setY(y);
				variableLoc.get(i+h).setZ(z);
				variableLoc.get(i+h).setWorld(world);
			}
		}*/


	}
	public void setLobbyLoc1(Location loc1){
		lobbyLoc1 = loc1;
		config.getDataConfig().set(name + ".lobby.x",loc1.getZ());
		config.getDataConfig().set(name + ".lobby.y",loc1.getBlockY());
		config.getDataConfig().set(name + ".lobby.z",loc1.getZ());
		config.getDataConfig().set(name + ".lobby.world",loc1.getWorld().getName());
		config.saveDataConfig();
	}
	public void setLobbyLoc2(Location loc2){
		lobbyLoc2 = loc2;
	}
	public void setDropLoc1(Location loc1){
		dropLoc1 = loc1;
		config.getDataConfig().set(name + ".drop.loc1.x",loc1.getZ());
		config.getDataConfig().set(name + ".drop.loc1.y",loc1.getBlockY());
		config.getDataConfig().set(name + ".drop.loc1.z",loc1.getZ());
		config.getDataConfig().set(name + ".drop.loc1.world",loc1.getWorld().getName());
		config.saveDataConfig();
	}
	public void setDropLoc2(Location loc2){
		dropLoc2 = loc2;
		config.getDataConfig().set(name + ".drop.loc2.x",loc2.getZ());
		config.getDataConfig().set(name + ".drop.loc2.y",loc2.getBlockY());
		config.getDataConfig().set(name + ".drop.loc2.z",loc2.getZ());
		config.getDataConfig().set(name + ".drop.loc2.world",loc2.getWorld().getName());
		config.saveDataConfig();
	}
	public void setFallLoc1(Location loc1){
		fallLoc1 = loc1;
		config.getDataConfig().set(name + ".fall.loc1.x",loc1.getZ());
		config.getDataConfig().set(name + ".fall.loc1.y",loc1.getBlockY());
		config.getDataConfig().set(name + ".fall.loc1.z",loc1.getZ());
		config.getDataConfig().set(name + ".fall.loc1.world",loc1.getWorld().getName());
		config.saveDataConfig();
	}
	public void setFallLoc2(Location loc2){
		fallLoc2 = loc2;
		config.getDataConfig().set(name + ".fall.loc2.x",loc2.getZ());
		config.getDataConfig().set(name + ".fall.loc2.y",loc2.getBlockY());
		config.getDataConfig().set(name + ".fall.loc2.z",loc2.getZ());
		config.getDataConfig().set(name + ".fall.loc2.world",loc2.getWorld().getName());
		config.saveDataConfig();
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
