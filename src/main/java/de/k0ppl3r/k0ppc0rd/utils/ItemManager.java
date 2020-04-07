package de.k0ppl3r.k0ppc0rd.utils;

import java.util.List;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import de.k0ppl3r.k0ppc0rd.koppcord;

public class ItemManager {
	
	private final koppcord plugin;
	
	public ItemManager(koppcord plugin) {
		this.plugin = plugin;
	}

	public ItemStack createitem(Material material, int subid, String displayname) {

		ItemStack item = new ItemStack(material, 1, (short) subid);
		ItemMeta mitem = item.getItemMeta();
		mitem.setDisplayName(displayname);
		item.setItemMeta(mitem);

		return item;

	}

	public ItemStack createitemlore(Material material, int subid, String displayname, List<String> lore) {

		ItemStack item4 = new ItemStack(material, 1, (short) subid);
		ItemMeta mitem4 = item4.getItemMeta();
		mitem4.setDisplayName(displayname);
		mitem4.setLore(lore);
		item4.setItemMeta(mitem4);

		return item4;

	}

	public ItemStack createitemloreverzaubert(Material material, int subid, String displayname, List<String> lore,
			Enchantment enchant, int lvl) {

		ItemStack item5 = new ItemStack(material, 1, (short) subid);
		ItemMeta mitem5 = item5.getItemMeta();
		mitem5.setDisplayName(displayname);
		mitem5.addEnchant(enchant, lvl, true);
		mitem5.setLore(lore);
		item5.setItemMeta(mitem5);

		return item5;

	}

	public ItemStack createitemverzaubert(Material material, int subid, String displayname, Enchantment enchant,
			int lvl) {

		ItemStack item1 = new ItemStack(material, 1, (short) subid);
		ItemMeta mitem1 = item1.getItemMeta();
		mitem1.setDisplayName(displayname);
		mitem1.addEnchant(enchant, lvl, true);
		item1.setItemMeta(mitem1);

		return item1;

	}

	public ItemStack createitemdamage(Material material, int subid, String displayname, short damage) {

		ItemStack item7 = new ItemStack(material, 1, (short) subid);
		ItemMeta mitem7 = item7.getItemMeta();
		item7.setDurability(damage);
		mitem7.setDisplayName(displayname);

		return item7;

	}

	public ItemStack createitemdamageamount(int material, int subid, String displayname, int amount, short damage) {

		@SuppressWarnings("deprecation")
		ItemStack item7 = new ItemStack(material, amount, (short) subid);
		ItemMeta mitem7 = item7.getItemMeta();
		item7.setDurability(damage);
		mitem7.setDisplayName(displayname);

		return item7;

	}

	public ItemStack createitemverzaubertamount(Material material, int subid, int amount, String displayname,
			Enchantment enchant, int lvl) {

		ItemStack item2 = new ItemStack(material, amount, (short) subid);
		ItemMeta mitem2 = item2.getItemMeta();
		mitem2.setDisplayName(displayname);
		mitem2.addEnchant(enchant, lvl, true);
		item2.setItemMeta(mitem2);

		return item2;

	}

	public ItemStack createitemamount(Material material, int amount, int subid, String displayname) {

		ItemStack item6 = new ItemStack(material, amount, (short) subid);
		ItemMeta mitem6 = item6.getItemMeta();
		mitem6.setDisplayName(displayname);
		item6.setItemMeta(mitem6);

		return item6;
	}

	public ItemStack createSkull(String Owner, String Displayname) {

		ItemStack item3 = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		SkullMeta sitem3 = (SkullMeta) item3.getItemMeta();
		sitem3.setOwner(Owner);
		sitem3.setDisplayName(Displayname);
		item3.setItemMeta(sitem3);

		return item3;
	}

	public ItemStack createColoredArmor(Material material, Color color, String displayname) {

		ItemStack itemArmor = new ItemStack(material);
		LeatherArmorMeta itemLeatherArmorMeta = (LeatherArmorMeta) itemArmor.getItemMeta();
		itemLeatherArmorMeta.setColor(color);
		itemLeatherArmorMeta.setDisplayName(displayname);
		itemArmor.setItemMeta(itemLeatherArmorMeta);

		return itemArmor;
	}

	public ItemStack createallitem(Material material, int subid, int amount, String displayname,
			Enchantment ench, int enchlvl, Boolean encheffekt, List<String> lore, short damage, Color Armorcolor,
			String SkullOwner) {

		ItemStack allitem = new ItemStack(material, amount, (short) subid);
		ItemMeta allmitem = allitem.getItemMeta();
		SkullMeta allsitem = (SkullMeta) allitem.getItemMeta();
		LeatherArmorMeta allLeatherArmorMeta = (LeatherArmorMeta) allitem.getItemMeta();
		allitem.setDurability(damage);
		allmitem.setDisplayName(displayname);
		allmitem.addEnchant(ench, enchlvl, encheffekt);
		allmitem.setLore(lore);
		allsitem.setOwner(SkullOwner);
		allLeatherArmorMeta.setColor(Armorcolor);

		return allitem;

	}

}
