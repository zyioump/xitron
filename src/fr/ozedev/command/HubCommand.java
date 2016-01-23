package fr.ozedev.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.ozedev.xitron.Xitron;

public class HubCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	if(sender instanceof Player){
		Xitron.initPlayer((Player) sender); 
		return true; 
	}
	return false;
   } 
}