package de.k0ppl3r.k0ppc0rd.events;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.material.Door;

import de.k0ppl3r.k0ppc0rd.koppcord;
import de.k0ppl3r.k0ppc0rd.utils.InventoryManager;
import de.k0ppl3r.k0ppc0rd.utils.ItemManager;
import de.k0ppl3r.k0ppc0rd.utils.PlayerManager;

public class InventoryEvent implements Listener{
	
	private final koppcord plugin;
	
	public InventoryEvent(koppcord plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onInventory(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		ItemManager itemManager = new ItemManager(plugin);
		PlayerManager playerManager = new PlayerManager(plugin);
		InventoryManager invManager = new InventoryManager(plugin);
		if(player.getLocation().getWorld().getName().equalsIgnoreCase("K0ppunity")) {
			if(plugin.buildmode.contains(player.getUniqueId())) {
				event.setCancelled(false);
			} else {
				event.setCancelled(true);
			}
			if(event.getInventory().getName().equals("�3Extras")) {
				if(event.getCurrentItem().getType() == Material.LEATHER_BOOTS && event.getCurrentItem().getItemMeta().getDisplayName().equals("�9Boots")) {
					player.openInventory(invManager.inventoryExtrasBoots());
				}
				if(event.getCurrentItem().getType() == Material.SKULL_ITEM && event.getCurrentItem().getItemMeta().getDisplayName().equals("�9K�pfe")) {
					player.openInventory(invManager.inventoryExtrasHeads(player));
				}
				event.setCancelled(true);
			}
			if(event.getInventory().getName().equals("�9Boots")) {
				if(event.getCurrentItem().getType() == Material.LEATHER_BOOTS && event.getCurrentItem().getItemMeta().getDisplayName().equals("�4Love-Boots")) {
					player.getInventory().setBoots(itemManager.createColoredArmor(Material.LEATHER_BOOTS, Color.RED, "�4Love-Boots"));
					player.closeInventory();
				}
				if(event.getCurrentItem().getType() == Material.LEATHER_BOOTS && event.getCurrentItem().getItemMeta().getDisplayName().equals("�5Magic-Boots")) {
					player.getInventory().setBoots(itemManager.createColoredArmor(Material.LEATHER_BOOTS, Color.PURPLE, "�5Magic-Boots"));
					player.closeInventory();
				}
				if(event.getCurrentItem().getType() == Material.BARRIER && event.getCurrentItem().getItemMeta().getDisplayName().equals("�cAusziehen")) {
					player.getInventory().setBoots(null);
					player.closeInventory();
				}
				event.setCancelled(true);
			}
			if(event.getInventory().getName().equals("�9K�pfe")) {
				if(event.getCurrentItem().getType() == Material.SKULL_ITEM && event.getCurrentItem().getItemMeta().getDisplayName().equals("�cKotori")) {
					player.getInventory().setHelmet(itemManager.createSkull("Kotori", "�cKotori"));
					player.closeInventory();
				}
				if(event.getCurrentItem().getType() == Material.BARRIER && event.getCurrentItem().getItemMeta().getDisplayName().equals("�cAusziehen")) {
					player.getInventory().setHelmet(null);
					player.closeInventory();
				}
			}
		} else {
			event.setCancelled(false);
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		ItemManager itemManager = new ItemManager(plugin);
		PlayerManager playerManager = new PlayerManager(plugin);
		InventoryManager invManager = new InventoryManager(plugin);
		Block block = event.getClickedBlock();
		Action action = event.getAction();
		if(player.getLocation().getWorld().getName().equalsIgnoreCase("K0ppunity")) {
			if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if(event.getPlayer().getItemInHand().getType() == Material.DIAMOND && event.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals("�3Extras")) {
					player.openInventory(invManager.inventoryExtras());
				}
				if(event.getClickedBlock() != null) {
				    if(event.getClickedBlock().getType() == Material.WOODEN_DOOR) {
				       	event.setCancelled(true);
			           	player.kickPlayer("Disconnect");
			           	player.sendMessage("INTERACT");
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onInvMove(InventoryDragEvent event) {
		Player player = (Player) event.getWhoClicked();
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
	public void onChangeWorld(PlayerChangedWorldEvent event) {
		Player player = event.getPlayer();
		ItemManager item = new ItemManager(plugin);
		PlayerManager playerManager = new PlayerManager(plugin);
		if(player.getWorld().getName().equalsIgnoreCase("K0ppunity")) {
			player.setGameMode(GameMode.SURVIVAL);
			player.getInventory().clear();
			playerManager.setPlayerJoinItems(player);
		} else if(player.getWorld().getName().equalsIgnoreCase("BuildWorld")) {
			if(!player.hasPermission("k0ppc0rd.worldbootsbypass")) {
				player.getInventory().setBoots(null);
			}
			player.setGameMode(GameMode.CREATIVE);
			player.getInventory().clear();
			plugin.buildmode.remove(player.getUniqueId());
		} else {
			player.getInventory().clear();
			plugin.buildmode.remove(player.getUniqueId());
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		
		if(player.getInventory().getHelmet() != null) {
			if(player.getInventory().getHelmet().getType() == Material.SKULL && player.getInventory().getHelmet().getItemMeta().getDisplayName().equals("�cKotori")) {
				player.playEffect(player.getLocation().add(0, 1, 0), Effect.MOBSPAWNER_FLAMES, 1);
			}
		}
		
		if(player.getInventory().getBoots() != null) {
			if(player.getInventory().getBoots().getType() == Material.LEATHER_BOOTS && player.getInventory().getBoots().getItemMeta().getDisplayName().equals("�4Love-Boots")) {
				player.playEffect(player.getLocation(), Effect.HEART, 1);
			}
			if(player.getInventory().getBoots().getType() == Material.LEATHER_BOOTS && player.getInventory().getBoots().getItemMeta().getDisplayName().equals("�5Magic-Boots")) {
				player.playEffect(player.getLocation(), Effect.WITCH_MAGIC, 1);
			}
		}
	}
}
