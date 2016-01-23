package fr.ozedev.item;

import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class BdsItem {
	public static ItemStack getMoneyItem(int nb){
		ItemStack item = new ItemStack(Material.DOUBLE_PLANT, nb);
		ItemMeta itemMeta = item.getItemMeta();
		
		itemMeta.setDisplayName("§6Money : §c"+nb);
		itemMeta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, nb, true);
		
		item.setItemMeta(itemMeta);
		
		return item;
	}
	public static ItemStack getBdsChooseItem(){
		ItemStack item = new ItemStack(Material.BANNER);
		BannerMeta itemMeta = (BannerMeta) item.getItemMeta();
		
		itemMeta.setDisplayName("§6Choisie ton équipe");
		itemMeta.setBaseColor(DyeColor.WHITE);
		
		item.setItemMeta(itemMeta);
		
		return item;
	}
	public static ItemStack getOrange(){
		ItemStack item = new ItemStack(Material.LEATHER_HELMET);
		LeatherArmorMeta itemMeta = (LeatherArmorMeta) item.getItemMeta();
		
		itemMeta.setDisplayName("§6Orange");
		itemMeta.setColor(Color.ORANGE);
		
		item.setItemMeta(itemMeta);
		
		return item;
	}
	public static ItemStack getMauve(){
		ItemStack item = new ItemStack(Material.LEATHER_HELMET);
		LeatherArmorMeta itemMeta = (LeatherArmorMeta) item.getItemMeta();
		
		itemMeta.setDisplayName("§5Mauve");
		itemMeta.setColor(Color.PURPLE);
		
		item.setItemMeta(itemMeta);
		
		return item;
	}
	public static ItemStack getCyan(){
		ItemStack item = new ItemStack(Material.LEATHER_HELMET);
		LeatherArmorMeta itemMeta = (LeatherArmorMeta) item.getItemMeta();
		
		itemMeta.setDisplayName("§bCyan");
		itemMeta.setColor(Color.AQUA);
		
		item.setItemMeta(itemMeta);
		
		return item;
	}
	public static ItemStack getVert(){
		ItemStack item = new ItemStack(Material.LEATHER_HELMET);
		LeatherArmorMeta itemMeta = (LeatherArmorMeta) item.getItemMeta();
		
		itemMeta.setDisplayName("§2Vert");
		itemMeta.setColor(Color.GREEN);
		
		item.setItemMeta(itemMeta);
		
		return item;
	}
}
