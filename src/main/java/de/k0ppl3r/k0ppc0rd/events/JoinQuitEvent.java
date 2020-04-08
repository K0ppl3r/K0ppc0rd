package de.k0ppl3r.k0ppc0rd.events;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent.Result;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import de.k0ppl3r.k0ppc0rd.koppcord;
import de.k0ppl3r.k0ppc0rd.utils.Config;
import de.k0ppl3r.k0ppc0rd.utils.ImageChar;
import de.k0ppl3r.k0ppc0rd.utils.ImageMessage;
import de.k0ppl3r.k0ppc0rd.utils.PlayerManager;
import de.k0ppl3r.k0ppc0rd.utils.ScoreBoardManager;
import de.k0ppl3r.k0ppc0rd.utils.TabListManager;
import de.k0ppl3r.k0ppc0rd.utils.Title;

public class JoinQuitEvent implements Listener{
	
	private final koppcord plugin;
	
	public JoinQuitEvent(koppcord plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent event) {
		Title title = new Title(plugin);
		Player player = event.getPlayer();
		
		ScoreBoardManager scoreboard = new ScoreBoardManager(plugin);
		TabListManager tablist = new TabListManager(plugin);
		Config config = new Config(plugin);
		PlayerManager playerManager = new PlayerManager(plugin);
		
		title.sendTitle(player, 10, 50, 10, "§c» §9§lK0ppc0rd §c«", "§cServer Befindet sich derzeit in Close Beta!");
		
		playerManager.createPlayerData(player);
		playerManager.setPlayerJoinItems(player);
		
		tablist.sendTab(player, config.getHeader(player), config.getFooter(player));
		for(Player all : Bukkit.getOnlinePlayers()) {
			scoreboard.setBoard(all);
		}
		
		if(!player.hasPlayedBefore()) {
			event.setJoinMessage("§8[§aNEW§8] §a\\o/" + player.getName() + " §a\\o/");
			if(config.spawnExist()) {
				player.teleport(config.getSpawn());
				player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
			} else {
				playerManager.sendPlayerErrorCode(player, "§6spawn.not.exist");
			}
		}
		
		if(config.spawnExist()) {
			player.teleport(config.getSpawn());
			player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
		} else {
			playerManager.sendPlayerErrorCode(player, "§6spawn.not.exist");
		}
		event.setJoinMessage("§8[§a+§8] §a" + player.getName());
		player.setGameMode(GameMode.SURVIVAL);
		
		if(player.hasPermission("k0ppc0rd.chatskull")) {
			for (Player players : Bukkit.getOnlinePlayers()) {
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
						players.sendMessage(lines);
					}
					if (i == 4) {
						players.sendMessage(lines + " §4" + player.getName());
					}
					if(i == 5) {
						players.sendMessage(lines + " " + "§aHat den Server Betreten!");
					}
					i++;
				}
			}
		}
	}
	
	@EventHandler
	public void onPlayerQuitEvent(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		TabListManager tablist = new TabListManager(plugin);
		Config config = new Config(plugin);
		
		plugin.buildmode.remove(player.getUniqueId());
		tablist.sendTab(player, config.getHeader(player), config.getFooter(player));
		event.setQuitMessage("§8[§4-§8] §c" + event.getPlayer().getName());
		
	}
	
	@EventHandler
	public void onPreJoin(AsyncPlayerPreLoginEvent event) {
		Config config = new Config(plugin);
		
		if(config.isWartugAktiv()) {
			if(!config.isWhitelistet(event.getUniqueId().toString())) {
				event.disallow(Result.KICK_OTHER, config.getWartungKickMessage());
			}
		}
	}

}
