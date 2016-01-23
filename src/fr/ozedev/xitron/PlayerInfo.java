package fr.ozedev.xitron;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class PlayerInfo {
	public PlayerInfo(String name){
		this.name = name;
	}
	
	String name;
	String game					=	"Hub";
	Location bdsLoc				= null;
	boolean bdsInGame			= false;
	String bdsTeam 				= null;
	int bdsMoney 				= 1;
	int snowVote 				= 0;
	Location snowLoc;
	int snowLife				= 5;
	
	public String getGame(){return this.game;}
	@SuppressWarnings("deprecation")
	public void setGame(String game){
		this.game = game;
		Bukkit.getPlayer(this.name).setPlayerListName("["+this.game+"] "+Bukkit.getPlayer(name).getName());
	}
	
	public int getSnowLife(){return this.snowLife;}
	public void setSnowLife(int snowLife){this.snowLife = snowLife;}
	
	public Location getBdsLoc(){return this.bdsLoc;}
	public void setBdsLoc(Location bdsLoc){this.bdsLoc = bdsLoc;}
	
	public Location getSnowLoc(){return this.snowLoc;}
	public void setSnowLoc(Location snowLoc){this.snowLoc = snowLoc;}
	
	public String getBdsTeam(){return this.getBdsTeam();}
	public void setBdsTeam(String bdsTeam){this.bdsTeam = bdsTeam;}
	
	public int getBdsMoney(){return this.bdsMoney;}
	public void setBdsMoney(int bdsMoney){this.bdsMoney = bdsMoney;}
	
	public int getSnowVote(){return this.snowVote;}
	public void setSnowVote(int snowVote){this.snowVote = snowVote;}
	
	public boolean getBdsInGame(){return this.bdsInGame;}
	public void setBdsInGame(boolean bdsInGame){this.bdsInGame = bdsInGame;}
}
