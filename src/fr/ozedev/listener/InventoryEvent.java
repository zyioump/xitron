package fr.ozedev.listener;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import fr.ozedev.bds.Bds;
import fr.ozedev.hub.Hub;
import fr.ozedev.snow.Snow;
import fr.ozedev.xitron.PlayerInfo;
import fr.ozedev.xitron.Xitron;

public class InventoryEvent implements Listener{
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event){
		if(event.getWhoClicked() instanceof Player){
			Player player = (Player) event.getWhoClicked();
			PlayerInfo playerInfo = Xitron.get(player);
			
			if(playerInfo.getGame().equals("Hub")){
				Hub.onClick(player, event.getCurrentItem());
				Hub.onClick(player, event.getInventory().getName(), event.getCurrentItem());
			}else if(playerInfo.getGame().equals("Bds")){
				Bds.ItemClick(player, player.getItemInHand());
				Bds.ItemClick(player, event.getInventory().getName(), event.getCurrentItem());
			}else if(playerInfo.getGame().equals("SnowPunch")){
				Snow.itemClick(player, event.getCurrentItem());
				Snow.itemClick(player, event.getCurrentItem(), event.getInventory().getName());
			}
			if(!player.getGameMode().equals(GameMode.CREATIVE)) event.setCancelled(true);
		}
	}
}
