package fr.ozedev.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import fr.ozedev.snow.Snow;
import fr.ozedev.xitron.PlayerInfo;
import fr.ozedev.xitron.Xitron;

public class MoveEvent implements Listener{
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event){
		Player player = event.getPlayer();
		PlayerInfo playerInfo = Xitron.get(player);
		
		player.setFoodLevel(20);
		player.setSaturation(20);
		
		if(playerInfo.getGame().equals("SnowPunch")) Snow.playerMove(player);
	}
}
