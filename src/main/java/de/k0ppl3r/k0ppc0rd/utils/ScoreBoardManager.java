package de.k0ppl3r.k0ppc0rd.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import de.k0ppl3r.k0ppc0rd.koppcord;

public class ScoreBoardManager {
	
	private Scoreboard sb = null;
	private Objective obj = null;
	private final koppcord plugin;
	
	public ScoreBoardManager(koppcord plugin) {
		this.plugin = plugin;
	}
	
	public void setBoard(Player player) {
		
	    sb = Bukkit.getScoreboardManager().getNewScoreboard();
	    obj = sb.registerNewObjective("ccc", "ddd");
	    sb.registerNewTeam("00Besitzer").setPrefix("�4�lB �6�l� �4");
	    sb.registerNewTeam("01Admin").setPrefix("�4�lA �6�l� �4");
	    sb.registerNewTeam("02Developer").setPrefix("�b�lD �6�l� �b");
	    sb.registerNewTeam("03Techniker").setPrefix("�b�lT �6�l� �b");
	    sb.registerNewTeam("04Designer").setPrefix("�a�lD �6�l� �a");
	    sb.registerNewTeam("05Scripter").setPrefix("�b�lS �6�l� �b");
	    sb.registerNewTeam("06SrModerator").setPrefix("�c�lSrM �6�l� �c");
	    sb.registerNewTeam("07Moderator").setPrefix("�c�lM �6�l� �c");
	    sb.registerNewTeam("08Supporter").setPrefix("�9�lS �6�l� �9");
	    sb.registerNewTeam("09Rekrut").setPrefix("�9�lR �6�l� �9");
	    sb.registerNewTeam("10Partner").setPrefix("�5�lP �6�l� �5");
	    sb.registerNewTeam("11Bekannter").setPrefix("�d�lB �6�l� �d");
	    sb.registerNewTeam("12Streamer").setPrefix("�5�lS �6�l� �5");
	    sb.registerNewTeam("13YouTuber").setPrefix("�fY�4T �6�l� �5");
	    sb.registerNewTeam("14VIP").setPrefix("�6�lV �8�l� �6");
	    sb.registerNewTeam("15Spieler").setPrefix("�7M �8�l� �7");
	    
	    for(Player all : Bukkit.getOnlinePlayers()) {
		    if(all.hasPermission("k0ppc0rd.prefix.besitzer")) {
		    	sb.getTeam("00Besitzer").addPlayer(all);
		    } else if(all.hasPermission("k0ppc0rd.prefix.admin")) {
		    	sb.getTeam("01Admin").addPlayer(all);
		    } else if(all.hasPermission("k0ppc0rd.prefix.developer")) {
		    	sb.getTeam("02Developer").addPlayer(all);
		    } else if(all.hasPermission("k0ppc0rd.prefix.techniker")) {
		    	sb.getTeam("03Techniker").addPlayer(all);
		    } else if(all.hasPermission("k0ppc0rd.prefix.designer")) {
		    	sb.getTeam("04Designer").addPlayer(all);
		    } else if(all.hasPermission("k0ppc0rd.prefix.scripter")) {
		    	sb.getTeam("05Scripter").addPlayer(all);
		    } else if(all.hasPermission("k0ppc0rd.prefix.srmoderator")) {
		    	sb.getTeam("06SrModerator").addPlayer(all);
		    } else if(all.hasPermission("k0ppc0rd.prefix.moderator")) {
		    	sb.getTeam("07Moderator").addPlayer(all);
		    } else if(all.hasPermission("k0ppc0rd.prefix.supporter")) {
		    	sb.getTeam("08Supporter").addPlayer(all);
		    } else if(all.hasPermission("k0ppc0rd.prefix.rekrut")) {
		    	sb.getTeam("09Rekrut").addPlayer(all);
		    } else if(all.hasPermission("k0ppc0rd.prefix.partner")) {
		    	sb.getTeam("10Partner").addPlayer(all);
		    } else if(all.hasPermission("k0ppc0rd.prefix.bekannter")) {
		    	sb.getTeam("11Bekannter").addPlayer(all);
		    } else if(all.hasPermission("k0ppc0rd.prefix.streamer")) {
		    	sb.getTeam("12Streamer").addPlayer(all);
		    } else if(all.hasPermission("k0ppc0rd.prefix.youtuber")) {
		    	sb.getTeam("13YouTuber").addPlayer(all);
		    } else if(all.hasPermission("k0ppc0rd.prefix.vip")) {
		    	sb.getTeam("14VIP").addPlayer(all);
		    } else {
		    	sb.getTeam("15Spieler").addPlayer(all);
		    }
	    }
	    
	    obj.setDisplayName(" �c� �9�lK0ppc0rd �c� ");
	    obj.setDisplaySlot(DisplaySlot.SIDEBAR);
	    
	    Score a = obj.getScore("�5");
	    Score a1 = obj.getScore("�7Rang:");
	    if (player.hasPermission("k0ppc0rd.prefix.besitzer")) {
	      Score aa = obj.getScore(" �8� �4�lBesitzer");
	      aa.setScore(7);
	    } else if(player.hasPermission("k0ppc0rd.prefix.admin")) {
		      Score aa = obj.getScore(" �8� �4�lAdmin");
		      aa.setScore(7);
	    } else if(player.hasPermission("k0ppc0rd.prefix.developer")) {
		      Score aa = obj.getScore(" �8� �b�lDeveloper");
		      aa.setScore(7);
	    } else if(player.hasPermission("k0ppc0rd.prefix.techniker")) {
		      Score aa = obj.getScore(" �8� �b�lTechnicker");
		      aa.setScore(7);
	    } else if(player.hasPermission("k0ppc0rd.prefix.designer")) {
		      Score aa = obj.getScore(" �8� �a�lDesigner");
		      aa.setScore(7);
	    } else if(player.hasPermission("k0ppc0rd.prefix.scripter")) {
		      Score aa = obj.getScore(" �8� �b�lScripter");
		      aa.setScore(7);
	    } else if(player.hasPermission("k0ppc0rd.prefix.srmoderator")) {
		      Score aa = obj.getScore(" �8� �c�lSrModerator");
		      aa.setScore(7);
	    } else if(player.hasPermission("k0ppc0rd.prefix.moderator")) {
		      Score aa = obj.getScore(" �8� �c�lModerator");
		      aa.setScore(7);
	    } else if(player.hasPermission("k0ppc0rd.prefix.supporter")) {
		      Score aa = obj.getScore(" �8� �9�lSupporter");
		      aa.setScore(7);
	    } else if(player.hasPermission("k0ppc0rd.prefix.rekrut")) {
		      Score aa = obj.getScore(" �8� �9�lRekrut");
		      aa.setScore(7);
	    } else if(player.hasPermission("k0ppc0rd.prefix.partner")) {
		      Score aa = obj.getScore(" �8� �5�lPartner");
		      aa.setScore(7);
	    } else if(player.hasPermission("k0ppc0rd.prefix.bekannter")) {
		      Score aa = obj.getScore(" �8� �d�lBekannter");
		      aa.setScore(7);
	    } else if(player.hasPermission("k0ppc0rd.prefix.streamer")) {
		      Score aa = obj.getScore(" �8� �5�lStreamer");
		      aa.setScore(7);
	    } else if(player.hasPermission("k0ppc0rd.prefix.youtuber")) {
		      Score aa = obj.getScore(" �8� �f�lYou�4�lTuber");
		      aa.setScore(7);
	    } else if(player.hasPermission("k0ppc0rd.prefix.vip")) {
		      Score aa = obj.getScore(" �8� �6�lVIP");
		      aa.setScore(7);
	    } else {
	      Score aa = obj.getScore(" �8� �7Spieler");
	      aa.setScore(7);
	    }
	    
	    SimpleDateFormat Datum = new SimpleDateFormat("dd.MM.yyyy");
		String StringDatum = Datum.format(new Date());
	   
	    Score c = obj.getScore("�3");
	    Score d = obj.getScore("�cDatum:");
		Score e = obj.getScore(" �8� �c" + StringDatum);
	    Score f = obj.getScore("�2");
	    Score g = obj.getScore("�9Discord:");
	    Score h = obj.getScore(" �8� �ediscord.gg/rYnKKqg");
	    Score i = obj.getScore("�1");
	    
	    a.setScore(9);
	    a1.setScore(8);
	    c.setScore(6);
	    d.setScore(5);
	    e.setScore(4);
	    f.setScore(3);
	    g.setScore(2);
	    h.setScore(1);
	    i.setScore(0);
	   
	    player.setScoreboard(sb);
	  }

}
