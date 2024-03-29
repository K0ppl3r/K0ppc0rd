package de.k0ppl3r.k0ppc0rd.utils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;


import de.k0ppl3r.k0ppc0rd.koppcord;

import javax.imageio.ImageIO;

public class PlayerManager {
	
	private final koppcord plugin;
	
	public PlayerManager(koppcord plugin) {
		this.plugin = plugin;
	}
	
	public void createPlayerData(Player player) {

		File ordner = new File(plugin.getDataFolder() + "/PlayerData");
		File file = new File(plugin.getDataFolder() + "/PlayerData/" +  player.getUniqueId().toString() + ".yml");
		YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);


		if(!ordner.exists()) {
			ordner.mkdirs();
		}

		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		yamlConfiguration.options().copyDefaults(true);
		yamlConfiguration.addDefault("Player.Name", player.getName());
		yamlConfiguration.addDefault("Player.UUID", player.getUniqueId().toString());
		yamlConfiguration.addDefault("Player.Coins", 0);
		
		try {
			yamlConfiguration.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//GetPlayer and More about player
	public Player getPlayerByUUID(UUID UUID) {
		return Bukkit.getPlayer(UUID);
	}
	
	public UUID getUUIDbyPlayer(Player player) {
		return player.getUniqueId();
	}
	
	public File getPlayerConfig(Player player) {
		File file = new File(plugin.getDataFolder() + "/PlayerData/" +  player.getUniqueId().toString() + ".yml");
		return file;
	}
	
	public void sendNoPermMessage(Player player) {
		Config config = new Config(plugin);
		
		player.sendMessage(config.getNoPerm());
	}
	
	public void sendPlayerErrorCode(Player player, String Code) {
		SimpleDateFormat Datum = new SimpleDateFormat("dd.MM.yyyy");
		SimpleDateFormat UhrZeit = new SimpleDateFormat("HH:mm");
		
		String StringDatum = Datum.format(new Date());
		String StringUhrZeit = UhrZeit.format(new Date());
		
		Config config = new Config(plugin);
		
		player.sendMessage(config.getPrefix() + "§8----- §4§lFehler §8-----");
		player.sendMessage(config.getPrefix() + "");
		player.sendMessage(config.getPrefix() + "§cCode: §6" + Code);
		player.sendMessage(config.getPrefix() + "§cDatum: §6" + StringDatum);
		player.sendMessage(config.getPrefix() + "§cUhrzeit: §6" + StringUhrZeit);
		player.sendMessage(config.getPrefix() + "");
		player.sendMessage(config.getPrefix() + "§8----- §4§lFehler §8-----");
		
	}
	
	public void setPlayerJoinItems(Player player) {
		ItemManager itemManager = new ItemManager(plugin);
		player.getInventory().clear();
		player.getInventory().setItem(8, itemManager.createitem(Material.DIAMOND, 0, "§3Extras"));
		if(player.hasPermission("k0ppc0rd.admin")) {
			player.getInventory().setItem(4, itemManager.createitem(Material.COMMAND, 0, "§4§lAdmin-Extras"));
			player.getInventory().setItem(3, itemManager.createitem(Material.BARRIER, 0, "§c§lNichts Ausgew§hlt!"));
		} else {
			player.getInventory().setItem(4, itemManager.createitem(Material.BARRIER, 0, "§c§lNichts Ausgew§hlt!"));
		}
	}

	public void sendPlayerSkull(Player player, Player target, String Line1, String Line2){

			URL url = null;
			try {
				url = new URL("https://minotar.net/avatar/" + player.getName() + "/8.png");
			} catch (MalformedURLException ex) {
				ex.printStackTrace();
			}
			ImageMessage imageMessage = null;
			try {
				imageMessage = new ImageMessage(ImageIO.read(url), 8,
						ImageChar.BLOCK.getChar());
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			int i = 1;
			for (String lines : imageMessage.getLines()) {
				if (i != 4 && i != 5) {
					target.sendMessage(lines);
				}
				if (i == 4) {
					target.sendMessage(lines + Line1);
				}
				if(i == 5) {
					target.sendMessage(lines + Line2);
				}
				i++;
			}


	}

}
