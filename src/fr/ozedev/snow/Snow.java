package fr.ozedev.snow;

import java.util.Iterator;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitScheduler;

import fr.ozedev.item.SnowItem;
import fr.ozedev.menu.SnowMenu;
import fr.ozedev.xitron.PlayerInfo;
import fr.ozedev.xitron.Xitron;

public class Snow {
	
	private static int compteur = 45;
	private static boolean gameStart = false;
	
	private static Location[] locDefault 									 = {new Location(Bukkit.getWorld("snowpunch"),-5,49,86),new Location(Bukkit.getWorld("snowpunch"),-5,49,100),new Location(Bukkit.getWorld("snowpunch"),-19,49,100),new Location(Bukkit.getWorld("snowpunch"),-19,48,86)};
	private static Location[] locCandies 									 = {new Location(Bukkit.getWorld("snowpunch"),109,50.30,113),new Location(Bukkit.getWorld("snowpunch"),123,50.30,113),new Location(Bukkit.getWorld("snowpunch"),116,50.30,120),new Location(Bukkit.getWorld("snowpunch"),116,50.30,106)};
	private static Location[] locAbordage 									 = {new Location(Bukkit.getWorld("snowpunch"),14,53,34),new Location(Bukkit.getWorld("snowpunch"),21,48,1),new Location(Bukkit.getWorld("snowpunch"),3,48,19),new Location(Bukkit.getWorld("snowpunch"),38,45,12)};
	
	public static boolean getGameStart() {return gameStart;}
	
	public static void addPlayer(Player player){
		PlayerInfo playerInfo = Xitron.get(player);
		
		playerInfo.setGame("SnowPunch");
		
		player.closeInventory();
		
		player.teleport(new Location(Bukkit.getWorld("snowpunch"), 14, 60, 94));
		
		player.setGameMode(GameMode.ADVENTURE);
		
		player.getInventory().clear();
		Xitron.clearArmor(player);
		
		if(gameStart == false){
			Iterator<Player> iterator = Xitron.getPlayer("SnowPunch").iterator();
			while(iterator.hasNext()){
				Player aPlayer = iterator.next();
				aPlayer.sendMessage("§b[SnowPunch] §c"+player.getName()+"§a viens de rejoindre la partie §C["+Xitron.getPlayer("SnowPunch").size()+"/4]");
			}
			
			player.getInventory().addItem(SnowItem.getSnowItem());
			
			playerInfo.setSnowLife(5);
			player.setMaxHealth(playerInfo.getSnowLife()*2);
			
			player.setGameMode(GameMode.ADVENTURE);
			
			if(Xitron.getPlayer("SnowPunch").size() >= 2){
				startGame();
			}
		}else{
			player.setGameMode(GameMode.SPECTATOR);
			player.sendMessage("§b[SnowPunch] §aLa partie a déjà commencer attender la fin");
		}
	}
	
	
	public static void playerMove(Player player){
		PlayerInfo playerInfo = Xitron.get(player);
		
		if(gameStart == false && player.getLocation().getBlockY() <= 0) player.teleport(new Location(Bukkit.getWorld("snowpunch"), 14, 60, 94));
		if(gameStart == true){
			if(player.getLocation().getBlockY()<=0){
				if(playerInfo.getSnowLife()>1){
					player.teleport(playerInfo.getSnowLoc());
					playerInfo.setSnowLife(playerInfo.getSnowLife()-1);
					player.setMaxHealth(playerInfo.getSnowLife()*2);
					player.setHealth(playerInfo.getSnowLife()*2);
				}else{
					player.sendMessage("§b[SnowPunch] §aVous êtes §cmort§a attendez que la partie recommence pour §crejouer");
					player.setGameMode(GameMode.SPECTATOR);
					playerInfo.setSnowLife(0);
					
					int playerAlive = 0;
					
					Iterator iterator = Xitron.getPlayer("SnowPunch").iterator();
					while(iterator.hasNext()){
						Player aPlayer = (Player) iterator.next();
						PlayerInfo aPlayerInfo = Xitron.get(aPlayer);
						
						if(aPlayerInfo.getSnowLife()>=1) playerAlive++; 
					}
				}
			}
		}
	}
	
	
	public static void itemClick(Player player, ItemStack item){
		if(item.equals(SnowItem.getSnowItem())) SnowMenu.openMenu(player);
	}
	
	public static void itemClick(Player player, ItemStack item, String string){
		PlayerInfo playerInfo = Xitron.get(player);
		if(string.equals("Map")){
			if(item.equals(SnowItem.get1Map())) playerInfo.setSnowVote(0);
			if(item.equals(SnowItem.get2Map())) playerInfo.setSnowVote(1);
			if(item.equals(SnowItem.get3Map())) playerInfo.setSnowVote(2);
			player.sendMessage("§b[SnowPunch] §aVotre vote a été prit en compte");
			player.closeInventory();
		}
	}
	
	private static void go(int map){
		Iterator<Player> iterator = Xitron.getPlayer("SnowPunch").iterator();
		
		int i = 0;
		
		while(iterator.hasNext()){
			Player player = iterator.next();
			PlayerInfo playerInfo = Xitron.get(player);
			
			if(map == 0){
				player.sendMessage("§b[SnowPunch] §aLa map choisi est §cDefault");
				player.teleport(locDefault[i]);
				playerInfo.setSnowLoc(locDefault[i]);
			}
			if(map == 1){
				player.sendMessage("§b[SnowPunch] §aLa map choisi est §cDefault");
				player.teleport(locCandies[i]);
				playerInfo.setSnowLoc(locCandies[i]);
			}
			if(map == 2){
				player.sendMessage("§b[SnowPunch] §aLa map choisi est §cDefault");
				player.teleport(locAbordage[i]);
				playerInfo.setSnowLoc(locAbordage[i]);
			}
			player.getInventory().clear();
			Xitron.clearArmor(player);
			
			player.getInventory().addItem(new ItemStack(Material.SNOW_BALL));
			i++;
		}
	}
	
	protected static void compt(){
		gameStart = true;
		
		int vote1Map = 0;
		int vote2Map = 0;
		int vote3Map = 0;
		
		Iterator<Player> iterator = Xitron.getPlayer("SnowPunch").iterator();
		while(iterator.hasNext()){
			Player player = (Player)iterator.next();
			PlayerInfo playerInfo = Xitron.get(player);
			
			if(playerInfo.getSnowVote() == 0) vote1Map++;
			if(playerInfo.getSnowVote() == 1) vote2Map++;
			if(playerInfo.getSnowVote() == 2) vote3Map++;
		}
		
		if(vote1Map >= vote2Map ||vote1Map >= vote3Map) go(0);
		else if(vote2Map >= vote3Map) go(1);
		else if(vote3Map > vote2Map) go(2);
	}
	
	private static void startGame(){
		BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
		scheduler.runTaskLater(Xitron.getInstance(), new Runnable() {
			
			@Override
			public void run() {
				if(compteur>0 && Xitron.getPlayer("SnowPunch").size()>=2){
					if((compteur == 45) || (compteur == 30) ||(compteur == 15) ||(compteur == 10) || (compteur <= 5)){
						Iterator<Player> iterator = Xitron.getPlayer("SnowPunch").iterator();
						while(iterator.hasNext()){
							Player player = iterator.next();
							player.sendMessage("§b[SnowPunch] §aLe jeu commence dans §c"+compteur+"§a seconde(s)");
						}
					}
					Iterator<Player> iterator = Xitron.getPlayer("SnowPunch").iterator();
					while(iterator.hasNext()){
						Player player = iterator.next();
						
						player.setLevel(compteur);
					}
					
					compteur--;
					
					
					scheduler.runTaskLater(Xitron.getInstance(), this, 20L);
				}else if(compteur<=0){
					Snow.compt();
					
				}else{
					compteur = 45;
					Iterator<Player> iterator = Xitron.getPlayer("SnowPunch").iterator();
					while(iterator.hasNext()){
						Player player = iterator.next();
						player.setLevel(compteur);
						player.sendMessage("§b[SnowPunch] §aLe jeu ne peux pas commencer car le nombre de joueur n'est suffisant §c["+Xitron.getPlayer("SnowPunch").size()+"/4]");
					}
				}
			}
		}, 20L);
	}
}
