package fr.ozedev.menu;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import fr.ozedev.item.BdsItem;

public class BdsChooseTeamMenu {
	public static void openMenu(Player player){
		Inventory inv = Bukkit.createInventory(player, 9, "Team");
		setInv(inv);
		player.openInventory(inv);
	}
	private static void setInv(Inventory inv){
		inv.setItem(0, BdsItem.getCyan());
		inv.setItem(1, BdsItem.getOrange());
		inv.setItem(2, BdsItem.getMauve());
		inv.setItem(3, BdsItem.getVert());
	}
}
