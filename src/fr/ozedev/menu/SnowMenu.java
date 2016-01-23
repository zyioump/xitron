package fr.ozedev.menu;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import fr.ozedev.item.SnowItem;

public class SnowMenu {
	public static void openMenu(Player player){
		Inventory inv = Bukkit.createInventory(player, 9, "Map");
		setInv(inv);
		player.openInventory(inv);
	}
	private static void setInv(Inventory inv){
		inv.setItem(0, SnowItem.get1Map());
		inv.setItem(1, SnowItem.get2Map());
		inv.setItem(2, SnowItem.get3Map());
	}
}
