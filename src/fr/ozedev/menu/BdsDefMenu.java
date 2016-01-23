package fr.ozedev.menu;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import fr.ozedev.item.BdsDef;

public class BdsDefMenu{
	public static void openMenu(Player player){
		Inventory inv = Bukkit.createInventory(player, 9, "Defensif");
		setInv(inv);
		player.openInventory(inv);
	}
	private static void setInv(Inventory inv){
		inv.setItem(0, BdsDef.getNormalM()[0]);
		inv.setItem(1, BdsDef.getCoeurAride()[0]);
		inv.setItem(2, BdsDef.getEcailleDeDragon()[0]);
		inv.setItem(3, BdsDef.getArmureDArchimage()[0]);
	}
}
