package fr.ozedev.bds;


import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import fr.ozedev.item.BdsDef;
import fr.ozedev.item.BdsItem;
import fr.ozedev.item.BdsOff;
import fr.ozedev.menu.BdsChooseTeamMenu;
import fr.ozedev.menu.BdsDefMenu;
import fr.ozedev.menu.BdsOffMenu;
import fr.ozedev.menu.BdsShop;
import fr.ozedev.xitron.PlayerInfo;
import fr.ozedev.xitron.Xitron;

public class Bds {
	public static void addPlayer(Player player){
		PlayerInfo playerInfo = Xitron.get(player);
		
		player.setGameMode(GameMode.ADVENTURE);
		
		player.closeInventory();
		
		playerInfo.setBdsMoney(1);
		playerInfo.setGame("Bds");
		
		playerInfo.setBdsInGame(false);
		
		player.teleport(new Location(Bukkit.getWorld("bds"), 1298, 68, -27));
		
		player.getInventory().clear();
		player.getInventory().addItem(BdsItem.getBdsChooseItem());
		player.setGameMode(GameMode.ADVENTURE);
	}
	public static void ItemClick(Player player, ItemStack item){
		PlayerInfo playerInfo = Xitron.get(player);
		if(item.equals(BdsItem.getBdsChooseItem()) && (playerInfo.getGame().equals("Bds"))){
			BdsChooseTeamMenu.openMenu(player);
		}else if(item.equals(BdsItem.getMoneyItem(playerInfo.getBdsMoney()))){
			BdsShop.openMenu(player);
		}
	}
	
	public static void removeSword(Player player){
		Inventory inv = player.getInventory();
		inv.remove(Material.DIAMOND_SWORD);
		inv.remove(Material.GOLD_SWORD);
		inv.remove(Material.IRON_SWORD);
		inv.remove(Material.STONE_SWORD);
		inv.remove(Material.WOOD_SWORD);
	}
	
	public static void getDefaultStuff(Player player){
		PlayerInfo playerInfo = Xitron.get(player);
		
		player.getInventory().clear();
		player.getInventory().addItem(new ItemStack(Material.IRON_SWORD));
		player.getInventory().addItem(BdsItem.getMoneyItem(playerInfo.getBdsMoney()));
		player.getInventory().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));
		player.getInventory().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
		player.getInventory().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
		player.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET));
	}
	public static void ItemClick(Player player, String string, ItemStack item){
		PlayerInfo playerinfo = Xitron.get(player);
		
		if(string.equals("Team") && (playerinfo.getGame().equals("Bds"))){
			if(item.equals(BdsItem.getCyan())){
				Location loc = new Location(Bukkit.getWorld("bds"), 1291, 10, -48);
				player.teleport(loc);
				playerinfo.setBdsLoc(loc);
				playerinfo.setBdsInGame(true);
				
				player.sendMessage("§b[Bds] §aVous rejoigner l'équipe §bcyan");
				
				playerinfo.setBdsTeam("cyan");
				Bds.getDefaultStuff(player);
			}
			if(item.equals(BdsItem.getVert())){
				Location loc = new Location(Bukkit.getWorld("bds"), 1306, 10, -7);
				player.teleport(loc);
				playerinfo.setBdsLoc(loc);
				playerinfo.setBdsInGame(true);
				
				player.sendMessage("§b[Bds] §aVous rejoigner l'équipe §2vert");
				
				playerinfo.setBdsTeam("vert");
				Bds.getDefaultStuff(player);
			}
			if(item.equals(BdsItem.getOrange())){
				Location loc = new Location(Bukkit.getWorld("bds"), 1278, 10, -20);
				player.teleport(loc);
				playerinfo.setBdsLoc(loc);
				playerinfo.setBdsInGame(true);
				
				player.sendMessage("§b[Bds] §aVous rejoigner l'équipe §6orange");
				
				playerinfo.setBdsTeam("orange");
				Bds.getDefaultStuff(player);
			}
			if(item.equals(BdsItem.getMauve())){
				Location loc = new Location(Bukkit.getWorld("bds"), 1319, 10, -35);
				player.teleport(loc);
				playerinfo.setBdsLoc(loc);
				playerinfo.setBdsInGame(true);
				
				player.sendMessage("§b[Bds] §aVous rejoigner l'équipe §5mauve");
				
				playerinfo.setBdsTeam("mauve");
				Bds.getDefaultStuff(player);
			}
		}else if(string.equals("Shop")){
			if(item.equals(BdsOff.getOff())){
				BdsOffMenu.openMenu(player);
			}else if(item.equals(BdsDef.getDef())){
				BdsDefMenu.openMenu(player);
			}
		}else if(string.equals("Offensif")){
			if(item.equals(BdsOff.getNormaleM()) && playerinfo.getBdsMoney() >= 2){
				playerinfo.setBdsMoney(playerinfo.getBdsMoney()-2);
				player.getInventory().remove(Material.DOUBLE_PLANT);
				player.getInventory().addItem(BdsItem.getMoneyItem(playerinfo.getBdsMoney()));
				Bds.removeSword(player);
				player.getInventory().addItem(item);
				player.closeInventory();
			}
			if(item.equals(BdsOff.getRepousseVent()) && playerinfo.getBdsMoney() >= 5){
				playerinfo.setBdsMoney(playerinfo.getBdsMoney()-5);
				player.getInventory().remove(Material.DOUBLE_PLANT);
				player.getInventory().addItem(BdsItem.getMoneyItem(playerinfo.getBdsMoney()));
				Bds.removeSword(player);
				player.getInventory().addItem(item);
				player.closeInventory();
			}
			if(item.equals(BdsOff.getFlamboyance()) && playerinfo.getBdsMoney() >= 5){
				playerinfo.setBdsMoney(playerinfo.getBdsMoney()-5);
				player.getInventory().remove(Material.DOUBLE_PLANT);
				player.getInventory().addItem(BdsItem.getMoneyItem(playerinfo.getBdsMoney()));
				Bds.removeSword(player);
				player.getInventory().addItem(item);
				player.closeInventory();
			}
			if(item.equals(BdsOff.getLameMana()) && playerinfo.getBdsMoney() >= 10){
				playerinfo.setBdsMoney(playerinfo.getBdsMoney()-10);
				player.getInventory().remove(Material.DOUBLE_PLANT);
				player.getInventory().addItem(BdsItem.getMoneyItem(playerinfo.getBdsMoney()));
				Bds.removeSword(player);
				player.getInventory().addItem(item);
				player.closeInventory();
			}
			if(item.equals(BdsOff.getEcailleDeDragon()) && playerinfo.getBdsMoney() >= 12){
				playerinfo.setBdsMoney(playerinfo.getBdsMoney()-12);
				player.getInventory().remove(Material.DOUBLE_PLANT);
				player.getInventory().addItem(BdsItem.getMoneyItem(playerinfo.getBdsMoney()));
				Bds.removeSword(player);
				player.getInventory().addItem(item);
				player.closeInventory();
			}
		}else if(string.equals("Defensif")){
			if(item.equals(BdsDef.getNormalM()[0]) && playerinfo.getBdsMoney() >= 2){
				playerinfo.setBdsMoney(playerinfo.getBdsMoney()-2);
				player.getInventory().remove(Material.DOUBLE_PLANT);
				player.getInventory().addItem(BdsItem.getMoneyItem(playerinfo.getBdsMoney()));
				player.getInventory().setArmorContents(BdsDef.getNormalM());
				player.closeInventory();
			}
			if(item.equals(BdsDef.getCoeurAride()[0]) && playerinfo.getBdsMoney() >= 5){
				playerinfo.setBdsMoney(playerinfo.getBdsMoney()-5);
				player.getInventory().remove(Material.DOUBLE_PLANT);
				player.getInventory().addItem(BdsItem.getMoneyItem(playerinfo.getBdsMoney()));
				player.getInventory().setArmorContents(BdsDef.getCoeurAride());
				player.closeInventory();
			}
			if(item.equals(BdsDef.getArmureDArchimage()[0]) && playerinfo.getBdsMoney() >= 15){
				playerinfo.setBdsMoney(playerinfo.getBdsMoney()-15);
				player.getInventory().remove(Material.DOUBLE_PLANT);
				player.getInventory().addItem(BdsItem.getMoneyItem(playerinfo.getBdsMoney()));
				player.getInventory().setArmorContents(BdsDef.getArmureDArchimage());
				player.closeInventory();
			}
			if(item.equals(BdsDef.getEcailleDeDragon()[0]) && playerinfo.getBdsMoney() >= 12){
				playerinfo.setBdsMoney(playerinfo.getBdsMoney()-12);
				player.getInventory().remove(Material.DOUBLE_PLANT);
				player.getInventory().addItem(BdsItem.getMoneyItem(playerinfo.getBdsMoney()));
				player.getInventory().setArmorContents(BdsDef.getEcailleDeDragon());
				player.closeInventory();
			}
		}
	}
}
