package fr.ozedev.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import fr.ozedev.bds.Bds;
import fr.ozedev.xitron.PlayerInfo;
import fr.ozedev.xitron.Xitron;

public class RespawnEvent implements Listener{
	@EventHandler
	public void onPlayerRespawn(PlayerRespawnEvent event){
		Player player = event.getPlayer();
		PlayerInfo playerInfo = Xitron.get(player);
		
		if(playerInfo.getGame().equals("Bds")){
			Bds.getDefaultStuff(player);
			event.setRespawnLocation(playerInfo.getBdsLoc());
		}
	}
}
