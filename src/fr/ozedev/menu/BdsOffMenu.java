package fr.ozedev.menu;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import fr.ozedev.item.BdsOff;

public class BdsOffMenu{
	public static void openMenu(Player player){
		Inventory inv = Bukkit.createInventory(player, 9, "Offensif");
		setInv(inv);
		player.openInventory(inv);
	}
	private static void setInv(Inventory inv){
		inv.setItem(0, BdsOff.getNormaleM());
		inv.setItem(1, BdsOff.getRepousseVent());
		inv.setItem(2, BdsOff.getFlamboyance());
		inv.setItem(3, BdsOff.getLameMana());
		inv.setItem(4, BdsOff.getEcailleDeDragon());
	}
}
