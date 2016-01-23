package fr.ozedev.menu;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import fr.ozedev.item.HubItem;

public class HubMenu {
	public static void openMenu(Player player){
		Inventory inv = Bukkit.createInventory(player, 9, "Menu des jeux");
		setInv(inv);
		player.openInventory(inv);
	}
	private static void setInv(Inventory inv){
		inv.setItem(0, HubItem.getBdsItem());
		inv.setItem(1, HubItem.getSnowItem());
	}
}
