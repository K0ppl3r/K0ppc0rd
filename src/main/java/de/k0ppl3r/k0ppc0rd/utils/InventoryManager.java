package de.k0ppl3r.k0ppc0rd.utils;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import de.k0ppl3r.k0ppc0rd.koppcord;

public class InventoryManager {
	
	private final koppcord plugin;
	
	public InventoryManager(koppcord plugin) {
		this.plugin = plugin;
	}
	
	public Inventory inventoryExtras() {
		Inventory inv = Bukkit.createInventory(null, 3*9, "�3Extras");
		ItemManager itemManager = new ItemManager(plugin);
		
		for(int i = 0; i < inv.getSize(); i++) {
			inv.setItem(i, itemManager.createitem(Material.STAINED_GLASS, 14, ""));
		}
		inv.setItem(11, itemManager.createitem(Material.LEATHER_BOOTS, 0, "�9Boots"));
		inv.setItem(13, itemManager.createitem(Material.BOW, 0, "�9Weapons"));
		inv.setItem(15, itemManager.createSkull("K0ppl3r", "�9K�pfe"));
		
		return inv;
	}
	
	public Inventory inventoryAdminExtras() {
		Inventory inv = Bukkit.createInventory(null, 3*9, "�4Admin-Extras");
		
		
		return inv;
	}
	
	public Inventory inventoryExtrasBoots() {
		Inventory inv = Bukkit.createInventory(null, 3*9, "�9Boots");
		ItemManager itemManager = new ItemManager(plugin);
		
		for(int i = 0; i < inv.getSize(); i++) {
			inv.setItem(i, itemManager.createitem(Material.STAINED_GLASS, 14, ""));
		}
		inv.setItem(11, itemManager.createColoredArmor(Material.LEATHER_BOOTS, Color.RED, "�4Love-Boots"));
		inv.setItem(12, itemManager.createColoredArmor(Material.LEATHER_BOOTS, Color.PURPLE, "�5Magic-Boots"));
		inv.setItem(22, itemManager.createitem(Material.BARRIER, 0, "�cAusziehen"));
		
		return inv;
	}
	
	public Inventory inventoryExtrasHeads(Player player) {
		Inventory inv = Bukkit.createInventory(null, 3*9, "�9K�pfe");
		ItemManager itemManager = new ItemManager(plugin);
		
		for(int i = 0; i < inv.getSize(); i++) {
			inv.setItem(i, itemManager.createitem(Material.STAINED_GLASS, 14, ""));
		}
		if(player.hasPermission("k0ppc0rd.skull.Kotori")) {
			inv.setItem(11, itemManager.createSkull("Kotori", "�cKotori"));
		}
		inv.setItem(22, itemManager.createitem(Material.BARRIER, 0, "�cAusziehen"));
		
		return inv;
	}

}
