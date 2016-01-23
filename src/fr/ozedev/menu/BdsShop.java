package fr.ozedev.menu;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import fr.ozedev.item.BdsDef;
import fr.ozedev.item.BdsOff;

public class BdsShop {
	public static void openMenu(Player player){
		Inventory inv = Bukkit.createInventory(player, 9, "Shop");
		setInv(inv);
		player.openInventory(inv);
	}
	private static void setInv(Inventory inv){
		inv.setItem(0, BdsOff.getOff());
		inv.setItem(1, BdsDef.getDef());
	}
}
