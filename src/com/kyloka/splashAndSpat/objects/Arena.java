package com.kyloka.splashAndSpat.objects;

import java.util.ArrayList;
import java.util.List;

import com.kyloka.splashAndSpat.Main;
import com.kyloka.splashAndSpat.config.Configuration;
import com.kyloka.splashAndSpat.game.GameState;
import com.kyloka.splashAndSpat.woolControl.ColoredWool;
import com.kyloka.splashAndSpat.inventory.InventoryGUI;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.configuration.file.YamlConfiguration;

public class Arena {
	private String name;
	private PlayerUser playerUser;
	private List<Block> blockList = new ArrayList<>();
	private List<BlockState> blockStateList = new ArrayList<>();
	private Location lobbyLoc,dropLoc1,dropLoc2,fallLoc1,fallLoc2;
	private YamlConfiguration config = Configuration.getDataConfig();
	private GameState gameState;
	private List<Block> blockListFall = new ArrayList<>();

	private boolean firstTurn = true;
	public Arena(String name){
		this.name = name;

	}
	public void setName(String name){
		this.name = name;
		gui.setName(name);
	}
	public String getName(){
		return name;
	}
	private InventoryGUI gui = new InventoryGUI(10);
	//functions
	public boolean getFirstTurn(){ return firstTurn;}
	public void setFirstTurn(boolean bool){firstTurn = bool;}

	public InventoryGUI getGui(){return gui;}


	public void setPlayerUser(PlayerUser playerUser){
		this.playerUser = playerUser;
	}
	public PlayerUser getPlayerList(){
		return playerUser;
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
		config.set(name + ".lobby.x",loc1);
		config.set(name + ".lobby.y",loc1);
		config.set(name + ".lobby.z",loc1);
		config.set(name + ".lobby.world",world);
		Bukkit.getLogger().info("hi");
		config.set(name + ".drop.loc1.x",loc1);
		config.set(name + ".drop.loc1.y",loc1);
		config.set(name + ".drop.loc1.z",loc1);
		config.set(name + ".drop.loc1.world",world);
		config.set(name + ".drop.loc2.x",loc1);
		config.set(name + ".drop.loc2.y",loc1);
		System.out.print("idk");
		config.set(name + ".drop.loc2.z",loc1);
		config.set(name + ".drop.loc2.world",world);
		config.set(name + ".fall.loc1.x",loc1);
		config.set(name + ".fall.loc1.y",loc1);
		config.set(name + ".fall.loc1.z",loc1);
		config.set(name + ".fall.loc1.world",world);
		config.set(name + ".fall.loc2.x",loc1);
		config.set(name + ".fall.loc2.y",loc1);
		config.set(name + ".fall.loc2.z",loc1);
		Bukkit.getLogger().info("hi");
		config.set(name + ".fall.loc2.world",world);
		Bukkit.getLogger().info("hi");
		Configuration.saveDataConfig();
	}
	public void resetArena(){
		double x1 = fallLoc1.getX();
		double y1 = fallLoc1.getY();
		double z1 = fallLoc1.getZ();
		double x2 = fallLoc2.getX();
		double y2 = fallLoc2.getY();
		double z2 = fallLoc2.getZ();
		double lessX, moreX, lessZ, moreZ;
		if (x1 > x2) {
			lessX = x2;
			moreX = x1;
		} else {
			lessX = x1;
			moreX = x2;
		}
		if (z1 > z2) {
			lessZ = z2;
			moreZ =  z1;
		} else {
			lessZ = z1;
			moreZ = z2;
		}
		double length = (int) (moreX - lessX);
		double width = (int) (moreZ - lessZ);

		World loc1World = fallLoc1.getWorld();
		double area = Math.abs((length + 1) * (width + 1));

		for (double li = lessX; li < moreX; li++) {
			for (double wi = lessZ; wi < moreZ; wi++) {
				Location placeholderLoc = new Location(loc1World, li, y1, wi);

				Block placeholderBlock = loc1World.getBlockAt(placeholderLoc);
				placeholderBlock.setType(Material.STATIONARY_WATER);

			}
		}


	}
	public void registerEachLocation(){
		YamlConfiguration dataConfig = config;
		String[] testArray = {"drop","fall"};
		String[] locArray = {"loc1","loc2"};
		double x = dataConfig.getDouble(name+".lobby.x");
		double y = dataConfig.getDouble(name+".lobby.y");
		double z = dataConfig.getDouble(name+".lobby.z");
		float yaw = (float)dataConfig.getDouble(name+".lobby.yaw");
		float pitch = (float)dataConfig.getDouble(name+".lobby.pitch");
		World world = Bukkit.getServer().getWorld(config.getString(name + ".lobby.world"));
		lobbyLoc = new Location(world,x,y,z,yaw,pitch);


		//lobbyLoc1,lobbyLoc2,dropLoc1,dropLoc2,fallLoc1,fallLoc2
		x = dataConfig.getDouble(name+".drop.loc1.x");
		 y = dataConfig.getDouble(name+".drop.loc1.y");
		 z = dataConfig.getDouble(name+".drop.loc1.z");

		world = Bukkit.getServer().getWorld(config.getString(name + ".drop.loc1.world"));
		dropLoc1 = new Location(world,x,y,z);
		x = dataConfig.getDouble(name+".drop.loc2.x");
		y = dataConfig.getDouble(name+".drop.loc2.y");
		z = dataConfig.getDouble(name+".drop.loc2.z");
		world = Bukkit.getServer().getWorld(config.getString(name + ".drop.loc2.world"));
		dropLoc2 = new Location(world,x,y,z);
		x = dataConfig.getDouble(name+".fall.loc1.x");
		y = dataConfig.getDouble(name+".fall.loc1.y");
		z = dataConfig.getDouble(name+".fall.loc1.z");
		world = Bukkit.getServer().getWorld(config.getString(name + ".fall.loc1.world"));
		fallLoc1 = new Location(world,x,y,z);
		x = dataConfig.getDouble(name+".fall.loc2.x");
		y = dataConfig.getDouble(name+".fall.loc2.y");
		z = dataConfig.getDouble(name+".fall.loc2.z");
		world = Bukkit.getServer().getWorld(config.getString(name + ".fall.loc2.world"));
		fallLoc2 = new Location(world,x,y,z);


	}
	public void resetDropArea(){
		double x1,y1,z1,x2,y2,z2;
		x1 = dropLoc1.getX();
		x2 = dropLoc2.getX();
		y1 = dropLoc1.getY();
		y2 = dropLoc2.getY();
		z1 = dropLoc1.getZ();
		z2 = dropLoc2.getZ();
		double moreX,lessX,moreZ,lessZ;
		if (x1 > x2) {
			lessX = x2;
			moreX = x1;
		} else {
			lessX = x1;
			moreX = x2;
		}
		if (z1 > z2) {
			lessZ = z2;
			moreZ =  z1;
		} else {
			lessZ = z1;
			moreZ = z2;
		}
		double length = (int) (moreX - lessX);
		double width = (int) (moreZ - lessZ);

		World loc1World = fallLoc1.getWorld();
		double area = Math.abs((length + 1) * (width + 1));
		List<Block> blockListTemp = new ArrayList<>();
		for (double li = lessX; li < moreX; li++) {
			for (double wi = lessZ; wi < moreZ; wi++) {
				Location placeholderLoc = new Location(loc1World, li, y1-1, wi);
				blockListTemp.add(placeholderLoc.getBlock());
				placeholderLoc.getBlock().setType(Material.STAINED_GLASS);
				placeholderLoc.getBlock().setData(ColoredWool.BLACK.getDataColor());
			}
		}
		blockListFall = blockListTemp;
	}
	public List<Block> getBlockListFall(){
		return blockListFall;
	}
	public void removeDropBlocks(){
		for(int i = 0; i < blockListFall.size(); i++){
			blockListFall.get(i).setType(Material.AIR);
		}
	}
	public void setLobbyLoc(Location loc1){
		lobbyLoc = loc1;
		config.set(name + ".lobby.x",loc1.getX());
		config.set(name + ".lobby.y",loc1.getBlockY());
		config.set(name + ".lobby.z",loc1.getZ());
		config.set(name + ".lobby.yaw",loc1.getYaw());
		config.set(name + ".lobby.pitch",loc1.getPitch());
		config.set(name + ".lobby.world",loc1.getWorld().getName());
		Configuration.saveDataConfig();
	}

	public void setDropLoc1(Location loc1){
		dropLoc1 = loc1;
		config.set(name + ".drop.loc1.x",loc1.getX());
		config.set(name + ".drop.loc1.y",loc1.getBlockY());
		config.set(name + ".drop.loc1.z",loc1.getZ());
		config.set(name + ".drop.loc1.world",loc1.getWorld().getName());
		Configuration.saveDataConfig();
	}
	public void setDropLoc2(Location loc2){
		dropLoc2 = loc2;
		config.set(name + ".drop.loc2.x",loc2.getX());
		config.set(name + ".drop.loc2.y",loc2.getBlockY());
		config.set(name + ".drop.loc2.z",loc2.getZ());
		config.set(name + ".drop.loc2.world",loc2.getWorld().getName());
		Configuration.saveDataConfig();
	}
	public void setFallLoc1(Location loc1){
		fallLoc1 = loc1;
		config.set(name + ".fall.loc1.x",loc1.getX());
		config.set(name + ".fall.loc1.y",loc1.getBlockY());
		config.set(name + ".fall.loc1.z",loc1.getZ());
		config.set(name + ".fall.loc1.world",loc1.getWorld().getName());
		Configuration.saveDataConfig();
	}
	public void setFallLoc2(Location loc2){
		fallLoc2 = loc2;
		config.set(name + ".fall.loc2.x",loc2.getX());
		config.set(name + ".fall.loc2.y",loc2.getBlockY());
		config.set(name + ".fall.loc2.z",loc2.getZ());
		config.set(name + ".fall.loc2.world",loc2.getWorld().getName());
		Configuration.saveDataConfig();
	}
	public Location getLobbyLoc(){
		return lobbyLoc;
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
