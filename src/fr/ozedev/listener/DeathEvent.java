package fr.ozedev.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import fr.ozedev.item.BdsItem;
import fr.ozedev.xitron.PlayerInfo;
import fr.ozedev.xitron.Xitron;

public class DeathEvent implements Listener{
	@EventHandler
	public void onPlayerDeath(EntityDeathEvent event){
		if(event.getEntity() instanceof Player){
			Player player = (Player) event.getEntity();
			Player killer = player.getKiller();
			
			PlayerInfo playerInfo = Xitron.get(player);
			PlayerInfo killerInfo = Xitron.get(killer);
			
			if(playerInfo.getBdsMoney()>=1) playerInfo.setBdsMoney(playerInfo.getBdsMoney()-1);
			killerInfo.setBdsMoney(killerInfo.getBdsMoney()+2);
			
			killer.getInventory().remove(Material.DOUBLE_PLANT);
			killer.getInventory().addItem(BdsItem.getMoneyItem(killerInfo.getBdsMoney()));
		}
	}
}
