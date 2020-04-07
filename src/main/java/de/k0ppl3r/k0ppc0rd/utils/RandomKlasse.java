package de.k0ppl3r.k0ppc0rd.utils;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import de.k0ppl3r.k0ppc0rd.koppcord;

public class RandomKlasse {
	
	private final koppcord plugin;
	
	public RandomKlasse(koppcord plugin) {
		this.plugin = plugin;
	}
	
	public static int randInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	public static String randomPlayer() {
		
		Random r = new Random();
		int random = r.nextInt(Bukkit.getOnlinePlayers().size());
		Player BS = (Player) Bukkit.getServer().getOnlinePlayers().toArray()[random];
		
		return BS.getName();
	}

}

