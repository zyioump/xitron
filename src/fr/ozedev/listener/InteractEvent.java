package fr.ozedev.listener;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import fr.ozedev.bds.Bds;
import fr.ozedev.hub.Hub;
import fr.ozedev.snow.Snow;
import fr.ozedev.xitron.PlayerInfo;
import fr.ozedev.xitron.Xitron;

public class InteractEvent implements Listener{
	@EventHandler
	public void onPlayerInterack(PlayerInteractEvent event){
		Player player = event.getPlayer();
		PlayerInfo playerInfo = Xitron.get(player);
		
		if(event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
			if(playerInfo.getGame().equals("Hub")) Hub.onClick(player, player.getItemInHand());
			else if(playerInfo.getGame().equals("Bds")) Bds.ItemClick(player, player.getItemInHand());
			else if(playerInfo.getGame().equals("SnowPunch")) Snow.itemClick(player, player.getItemInHand());
			
			if(playerInfo.getGame().equals("SnowPunch")){
				if(Snow.getGameStart() == true && player.getItemInHand().getType().equals(Material.SNOW_BALL)){
					player.getInventory().addItem(new ItemStack(Material.SNOW_BALL));
				}
			}
		}
		
		if(playerInfo.getGame().equals("hub") && !player.getGameMode().equals(GameMode.CREATIVE)) event.setCancelled(true);
	}
}
