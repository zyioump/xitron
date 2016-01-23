package fr.ozedev.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SnowItem {
	public static ItemStack getSnowItem(){
		ItemStack item = new ItemStack(Material.BOOK_AND_QUILL);
		ItemMeta itemM = item.getItemMeta();
		
		itemM.setDisplayName("§6Map");
		
		item.setItemMeta(itemM);
		return item;
	}
	public static ItemStack get1Map(){
		ItemStack item = new ItemStack(Material.SNOW_BALL,1);
		ItemMeta itemM = item.getItemMeta();
		
		itemM.setDisplayName("§c1) §6Default");
		
		item.setItemMeta(itemM);
		return item;
	}
	public static ItemStack get2Map(){
		ItemStack item = new ItemStack(Material.SNOW_BALL,2);
		ItemMeta itemM = item.getItemMeta();
		
		itemM.setDisplayName("§c2) §6Candies");
		
		item.setItemMeta(itemM);
		return item;
	}
	public static ItemStack get3Map(){
		ItemStack item = new ItemStack(Material.SNOW_BALL,3);
		ItemMeta itemM = item.getItemMeta();
		
		itemM.setDisplayName("§c3) §6Abordage");
		
		item.setItemMeta(itemM);
		return item;
	}
}
