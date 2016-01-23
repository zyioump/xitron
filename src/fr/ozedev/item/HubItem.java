package fr.ozedev.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class HubItem {
	public static ItemStack getChooseItem(){
		ItemStack item = new ItemStack(Material.BOOK_AND_QUILL);
		ItemMeta itemMeta = item.getItemMeta();
		
		itemMeta.setDisplayName("§6Menu des jeux");
		
		item.setItemMeta(itemMeta);
		
		return item;
	}
	public static ItemStack getJumpItem(){
		ItemStack item = new ItemStack(Material.FEATHER);
		ItemMeta itemMeta = item.getItemMeta();
		
		itemMeta.setDisplayName("§6Jump");
		
		item.setItemMeta(itemMeta);
		
		return item;
	}
	public static ItemStack getSpawnItem(){
		ItemStack item = new ItemStack(Material.IRON_DOOR);
		ItemMeta itemMeta = item.getItemMeta();
		
		itemMeta.setDisplayName("§6Spawn");
		
		item.setItemMeta(itemMeta);
		
		return item;
	}
	public static ItemStack getBdsItem(){
		ItemStack item = new ItemStack(Material.REDSTONE);
		ItemMeta itemMeta = item.getItemMeta();
		
		itemMeta.setDisplayName("§6Bain de sang");
		
		item.setItemMeta(itemMeta);
		
		return item;
	}
	public static ItemStack getSnowItem(){
		ItemStack item = new ItemStack(Material.SNOW_BALL);
		ItemMeta itemMeta = item.getItemMeta();
		
		itemMeta.setDisplayName("§6SnowPunch");
		
		item.setItemMeta(itemMeta);
		
		return item;
	}
}
