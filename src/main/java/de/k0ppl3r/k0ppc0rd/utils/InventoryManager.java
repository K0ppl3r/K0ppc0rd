package de.k0ppl3r.k0ppc0rd.utils;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import de.k0ppl3r.k0ppc0rd.koppcord;

public class InventoryManager {
	
	private final koppcord plugin;

	//#0 #1 #2 #3 #4 #5 #6 #7 #8
	//#9 #10 #11 #12 #13 #14 #15 #16 #17
	//#18 #19 #20 #21 #22 #23 #24 #25 #26

	public InventoryManager(koppcord plugin) {
		this.plugin = plugin;
	}
	
	public Inventory inventoryExtras() {
		Inventory inv = Bukkit.createInventory(null, 3*9, "§3Extras");
		ItemManager itemManager = new ItemManager(plugin);
		
		for(int i = 0; i < inv.getSize(); i++) {
			inv.setItem(i, itemManager.createitem(Material.STAINED_GLASS, 15, ""));
		}
		inv.setItem(11, itemManager.createitem(Material.LEATHER_BOOTS, 0, "§9Boots"));
		inv.setItem(13, itemManager.createitem(Material.BOW, 0, "§9Weapons"));
		inv.setItem(15, itemManager.createSkull("K0ppl3r", "§9Köpfe"));
		
		return inv;
	}
	
	public Inventory inventoryExtrasBoots() {
		Inventory inv = Bukkit.createInventory(null, 3*9, "§9Boots");
		ItemManager itemManager = new ItemManager(plugin);
		
		for(int i = 0; i < inv.getSize(); i++) {
			inv.setItem(i, itemManager.createitem(Material.STAINED_GLASS, 15, ""));
		}
		inv.setItem(11, itemManager.createColoredArmor(Material.LEATHER_BOOTS, Color.RED, "§4Love-Boots"));
		inv.setItem(12, itemManager.createColoredArmor(Material.LEATHER_BOOTS, Color.PURPLE, "§5Magic-Boots"));
		inv.setItem(22, itemManager.createitem(Material.BARRIER, 0, "§cAusziehen"));
		inv.setItem(26, itemManager.createSkull("MHF_ArrowLeft" , "§cZurück"));
		
		return inv;
	}
	
	public Inventory inventoryExtrasHeads(Player player) {
		Inventory inv = Bukkit.createInventory(null, 3*9, "§9Köpfe");
		ItemManager itemManager = new ItemManager(plugin);
		
		for(int i = 0; i < inv.getSize(); i++) {
			inv.setItem(i, itemManager.createitem(Material.STAINED_GLASS, 15, ""));
		}
		if(player.hasPermission("k0ppc0rd.skull.Kotori")) {
			inv.setItem(11, itemManager.createSkull("Kotori", "§cKotori"));
		}
		inv.setItem(22, itemManager.createitem(Material.BARRIER, 0, "§cAusziehen"));
		inv.setItem(26, itemManager.createSkull("MHF_ArrowLeft" , "§cZurück"));
		
		return inv;
	}

	public Inventory inventoryAdminExtras() {
		ItemManager itemManager = new ItemManager(plugin);
		Inventory inv = Bukkit.createInventory(null, 3*9, "§4Admin-Extras");

		for(int i = 0; i != inv.getSize(); i++){
			inv.setItem(i, itemManager.createitem(Material.STAINED_GLASS_PANE, 15, ""));
		}

		inv.setItem(11, itemManager.createitem(Material.WATCH, 0, "§9Zeit ändern"));
		inv.setItem(13, itemManager.createitem(Material.COMPASS, 0, "§9Wetter ändern"));
		inv.setItem(15, itemManager.createitemverzaubert(Material.ENCHANTED_BOOK, 0, "§9Sonstiges", null, 0));

		return inv;
	}

	public Inventory inventoryTimeChange(){
		ItemManager itemManager = new ItemManager(plugin);
		Inventory inv = Bukkit.createInventory(null, 3*9, "§9Zeit");

		for (int i = 0; i != inv.getSize(); i++){
			inv.setItem(i, itemManager.createitem(Material.STAINED_GLASS_PANE, 15, ""));
		}

		inv.setItem(12, itemManager.createitem(Material.DOUBLE_PLANT, 0, "§6Tag"));
		inv.setItem(14, itemManager.createitem(Material.NETHER_STAR, 0, "§1Nacht"));
		inv.setItem(26, itemManager.createSkull("MHF_ArrowLeft" , "§cZurück"));

		return inv;
	}

	public Inventory inventoryWeatherChange(){
		ItemManager itemManager = new ItemManager(plugin);
		Inventory inv = Bukkit.createInventory(null, 3*9, "§9Wetter");

		for (int i = 0; i != inv.getSize(); i++){
			inv.setItem(i, itemManager.createitem(Material.STAINED_GLASS_PANE, 15, ""));
		}

		inv.setItem(11, itemManager.createitem(Material.WATER_BUCKET, 0, "&9Regen"));
		inv.setItem(13, itemManager.createitem(Material.DOUBLE_PLANT, 0, "§6Sonnig"));
		inv.setItem(15, itemManager.createitem(Material.BLAZE_POWDER, 0, "§7Gewitter"));
		inv.setItem(26, itemManager.createSkull("MHF_ArrowLeft" , "§cZurück"));

		return null;
	}

	public Inventory inventorySomthing(){
		ItemManager itemManager = new ItemManager(plugin);
		Inventory inv = Bukkit.createInventory(null, 3*9, "§9Sonstiges");

		for(int i = 0; i != inv.getSize(); i++){
			inv.setItem(i, itemManager.createitem(Material.STAINED_GLASS_PANE, 14, "§cComming Soon!"));
		}

		return null;
	}

}
