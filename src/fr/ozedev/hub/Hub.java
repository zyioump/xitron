package fr.ozedev.hub;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import fr.ozedev.bds.Bds;
import fr.ozedev.item.HubItem;
import fr.ozedev.menu.HubMenu;
import fr.ozedev.snow.Snow;
import fr.ozedev.xitron.PlayerInfo;
import fr.ozedev.xitron.Xitron;

public class Hub {
	public static void onClick(Player player, ItemStack item) {
		if(item.equals(HubItem.getChooseItem())){
			HubMenu.openMenu(player);
		}else if(item.equals(HubItem.getJumpItem())){
			player.teleport(new Location(player.getWorld(), 55, 38, 34));
		}else if(item.equals(HubItem.getSpawnItem())){
			player.teleport(new Location(player.getWorld(), 32, 25, 61));
		}
	}
	public static void onClick(Player player, String name, ItemStack item){
		PlayerInfo playerInfo = Xitron.get(player);
		
		if(name.equals("Menu des jeux") && playerInfo.getGame().equals("Hub")){
			if(item.equals(HubItem.getSnowItem())){
				Snow.addPlayer(player);
			} else if(item.equals(HubItem.getBdsItem())){
				Bds.addPlayer(player);
			}
		}
	}
}
