package fr.ozedev.xitron;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.ozedev.command.HubCommand;
import fr.ozedev.command.SnowCommand;
import fr.ozedev.item.HubItem;
import fr.ozedev.listener.*;

public class Xitron extends JavaPlugin{
	
	private static Map<String, PlayerInfo> playerInfo = new HashMap<>();
	private PluginManager pm;
	private static Plugin instance;
	
	public void onEnable(){
		instance = this;
		this.pm = Bukkit.getPluginManager();
		
		this.pm.registerEvents(new JoinEvent(), instance);
		this.pm.registerEvents(new InteractEvent(), instance);
		this.pm.registerEvents(new InventoryEvent(),instance);
		this.pm.registerEvents(new MoveEvent(), instance);
		this.pm.registerEvents(new DamageEvent(),instance);
		this.pm.registerEvents(new DropEvent(), instance);
		this.pm.registerEvents(new RespawnEvent(),instance);
		this.pm.registerEvents(new DeathEvent(), instance);
		this.pm.registerEvents(new ChatEvent(), instance);
		
		getCommand("hub").setExecutor(new HubCommand());
		getCommand("snow").setExecutor(new SnowCommand());
		
		Bukkit.createWorld(new WorldCreator("bds"));
		Bukkit.createWorld(new WorldCreator("snowpunch"));
	}
	
	public static Plugin getInstance(){return instance;}
	
	public static PlayerInfo get(Player player){
		return playerInfo.get(player.getName());
	}
	
	public static void clearArmor(Player player){
        player.getInventory().setHelmet(null);
        player.getInventory().setChestplate(null);
        player.getInventory().setLeggings(null);
        player.getInventory().setBoots(null);
    }
	
	public static void initPlayer(Player player){
		playerInfo.put(player.getName(), new PlayerInfo(player.getName()));
		PlayerInfo pi = Xitron.get(player);
		
		player.sendMessage("§6----------------------------------------------------");
		player.sendMessage("§aBienvenue §b"+player.getName().toString()+" §asur §6§kpo§r§aXitron§6§kpo§r§a");
		player.sendMessage("§cXitron est en version beta il peut y avoir certain beug");
		player.sendMessage("§cSi vous en trouver un merci de nous envoyer un message sur le skype du créateur du serveur : §6citron qui roule");
		player.sendMessage("§6----------------------------------------------------");
		
		player.setGameMode(GameMode.ADVENTURE);
		
		player.setMaxHealth(20);
		player.setHealth(20);
		player.setLevel(0);
		
		pi.setGame("Hub");
		
		player.getInventory().clear();
		
	    Xitron.clearArmor(player);
		
		player.getInventory().addItem(HubItem.getChooseItem());
		player.getInventory().addItem(HubItem.getJumpItem());
		player.getInventory().addItem(HubItem.getSpawnItem());
		
		player.teleport(new Location(Bukkit.getWorld("world"), 32, 25, 61));
	}
	public static ArrayList<Player> getPlayer(String game){
		ArrayList<Player> players = new ArrayList<Player>();
		
		Iterator<? extends Player> iterator = Bukkit.getOnlinePlayers().iterator();
		
		while(iterator.hasNext()){
			Player aplayer = iterator.next();
			PlayerInfo playerInfo = Xitron.get(aplayer);
			if(playerInfo.getGame().equals(game)) players.add(aplayer);
		}
		
		return players;
	}
}
