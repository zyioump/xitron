package fr.ozedev.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import fr.ozedev.xitron.PlayerInfo;
import fr.ozedev.xitron.Xitron;

public class DamageEvent implements Listener{
	@EventHandler
	public void onDamage(EntityDamageEvent event){
		if(event.getEntity() instanceof Player){
			Player player = (Player) event.getEntity();
			PlayerInfo playerInfo = Xitron.get(player);
			if(playerInfo.getGame().equals("Bds")){
				if(playerInfo.getBdsInGame() == false){
					event.setCancelled(true);
				}
				if(event.getCause().equals(DamageCause.FALL)) event.setCancelled(true);
			}
			else if(playerInfo.getGame().equals("SnowPunch")){
				if(!event.getCause().equals(DamageCause.PROJECTILE)){
					event.setCancelled(true);
				}
			}
			else event.setCancelled(true);
		}else{
			event.setCancelled(true);
		}
	}
}
