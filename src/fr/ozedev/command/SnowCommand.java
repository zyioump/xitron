package fr.ozedev.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import fr.ozedev.snow.Snow;

public class SnowCommand extends Snow implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	
    if(sender.isOp() == true){
    	if(args != null && args.length > 0){
	    	if(args[0].equals("start")){
	    		super.compt();
	    		return true;
	    	}
	    	return false;
    	}else return false;
    }else{
    	return false;
    }
   } 
}