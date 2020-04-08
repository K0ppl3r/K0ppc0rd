package de.k0ppl3r.k0ppc0rd.events;

import java.awt.HeadlessException;

import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

import de.k0ppl3r.k0ppc0rd.koppcord;
import de.k0ppl3r.k0ppc0rd.utils.Config;
import de.k0ppl3r.k0ppc0rd.utils.PlayerManager;

public class DenyedEvents implements Listener{
	
	private final koppcord plugin;
	
	public DenyedEvents(koppcord plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onWeather(WeatherChangeEvent event) {
		event.setCancelled(true);
	}
	
	@EventHandler
	public void onFootChange(FoodLevelChangeEvent event) {
		event.setCancelled(true);
		event.setFoodLevel(20);
	}
	
	@EventHandler
	public void onDamageEntity(EntityDamageByEntityEvent event) {
		Player target = (Player) event.getDamager();
		if(target instanceof Player) {
			target.setHealth(20.0);
		}
	}
	
	@EventHandler
	public void onDamageBlock(EntityDamageByBlockEvent event) {
		event.setCancelled(true);
	}
	
	@EventHandler
	public void onRespawn(PlayerRespawnEvent event) {
		Config config = new Config(plugin);
		PlayerManager playerManager = new PlayerManager(plugin);
		Player player = event.getPlayer();
		if(config.spawnExist() == true) {
			event.setRespawnLocation(config.getSpawn());
		}
		player.getInventory().clear();
		playerManager.setPlayerJoinItems(player);
	}
	
	@EventHandler
	public void onFallDamage(PlayerDeathEvent event) {
		Config config = new Config(plugin);
		if(event.getEntity().getKiller() != null){
			if(event.getEntity().getKiller() instanceof Player){
				event.setDeathMessage(config.getPrefix() + "§6" +   event.getEntity().getName() + " §cwurde von §6" + event.getEntity().getKiller().getName() + " §cget§tet!");
			}
		} else {
			event.setDeathMessage(ChatColor.RED + event.getEntity().getName() + " Starb!");
		}
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event) {
		Player player = event.getPlayer();
		if(player.getLocation().getWorld().getName().equalsIgnoreCase("K0ppunity")) {
			if(plugin.buildmode.contains(player.getUniqueId())) {
				event.setCancelled(false);
			} else {
				event.setCancelled(true);
			}
		} else {
			event.setCancelled(false);
		}
	}
	
	@EventHandler
	public void onBlockBreack(BlockBreakEvent event) {
		Player player = event.getPlayer();
		if(player.getLocation().getWorld().getName().equalsIgnoreCase("K0ppunity")) {
			if(plugin.buildmode.contains(player.getUniqueId())) {
				event.setCancelled(false);
			} else {
				event.setCancelled(true);
			}
		} else {
			event.setCancelled(false);
		}
	}
	@EventHandler
	public void onItemDrop(PlayerDropItemEvent event) {
		if(plugin.buildmode.contains(event.getPlayer().getUniqueId())) {
			event.setCancelled(false);
		} else {
			event.setCancelled(true);
		}
	}
}
