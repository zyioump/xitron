package fr.ozedev.listener;

import java.util.Iterator;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import fr.ozedev.xitron.PlayerInfo;
import fr.ozedev.xitron.Xitron;

public class ChatEvent implements Listener{
	@EventHandler
	public void onPlayerSpeak(AsyncPlayerChatEvent event){
		Player player = event.getPlayer();
		PlayerInfo playerinfo = Xitron.get(player);
		
		/*if(playerinfo.getGame().equals("Bds")){
			for(int i =0; i<Bds.getPlayer().length; i++) Bds.getPlayer()[i].sendMessage(event.getMessage());
		}else if(playerinfo.getGame().equals("Hub")){
			for(int i =0; i<Hub.getPlayer().length; i++) Hub.getPlayer()[i].sendMessage(event.getMessage());
		}*/
		
		//for(int i = 0; i<=Xitron.getPlayer(playerinfo.getGame()).length;i++) Xitron.getPlayer(playerinfo.getGame())[i].sendMessage(player.getName()+" > "+event.getMessage());
		
		Iterator<Player> iterator = Xitron.getPlayer(playerinfo.getGame()).iterator();
		
		while(iterator.hasNext()){
			Player aPlayer = iterator.next();
			aPlayer.sendMessage("§6"+player.getName()+" §7> §r"+event.getMessage());
		}
		
		event.setCancelled(true);
	}
}
