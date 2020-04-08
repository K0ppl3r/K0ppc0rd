package de.k0ppl3r.k0ppc0rd.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import de.k0ppl3r.k0ppc0rd.koppcord;

public class Config {
	
	private final koppcord plugin;
	
	private static ArrayList<String> WartungKickMSG = new ArrayList<String>();
	private static ArrayList<String> allowedWartungUUID = new ArrayList<String>();
	private static ArrayList<String> TablistHeader = new ArrayList<String>();
	private static ArrayList<String> TablistFooter = new ArrayList<String>();
	private static ArrayList<String> Rules = new ArrayList<String>();
	private static ArrayList<String> Helps = new ArrayList<String>();
	private static ArrayList<String> InfoYouTuber = new ArrayList<String>();
	private static ArrayList<String> InfoStreamer = new ArrayList<String>();
	private static ArrayList<String> InfoTeamMitglied = new ArrayList<String>();
	private static ArrayList<String> InfoHelp = new ArrayList<String>();
	private static ArrayList<String> Streamer = new ArrayList<String>();
	private static ArrayList<String> YouTuber = new ArrayList<String>();
	private static ArrayList<String> Partner = new ArrayList<String>();

	public Config(koppcord plugin) {
		this.plugin = plugin;
	}
	
	public void createConfig() {
		File file = new File(plugin.getDataFolder() + "/config.yml");
		YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);


		if(!plugin.getDataFolder().exists()) {
			plugin.getDataFolder().mkdirs();
		}
		
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//wartung
		WartungKickMSG.add("&8\\xbb &9K0ppc0rd &8\\xab");
		WartungKickMSG.add("");
		WartungKickMSG.add("§c§lDer Server Befindet sich dezeit im WartungsModus!");
		WartungKickMSG.add("&c&lBitte versuche es ein andern mal erneut!");
		WartungKickMSG.add("");
		
		allowedWartungUUID.add("UUID");
		
		//tablist
		TablistHeader.add("");
		TablistHeader.add("§aWillkommen auf dem §9§lK0ppc0rd §aCommunity Minecraft Server");
		TablistHeader.add("§aViel Spaß");
		TablistHeader.add("");
		
		TablistFooter.add("");
		TablistFooter.add("§9Discord Adresse: §9§ndisocrd.gg/rYnKKqg");
		TablistFooter.add("");
		
		//rules
		Rules.add("1. Default Rule!");
		Rules.add("2. Default Rule 2!");
		
		//helps
		Helps.add("/test | Test Command!");
		Helps.add("/test2 | Test2 Command!");

		//info
		YouTuber.add("Unknown");
		Streamer.add("Unknown");
		Partner.add("Unknown");
		InfoHelp.add("/info help");
		InfoYouTuber.add("200Abos");
		InfoStreamer.add("100Abos");
		InfoTeamMitglied.add("15Jahre alt");
		
		
		yamlConfiguration.options().copyDefaults(true);
		yamlConfiguration.addDefault("Link.Discord", "discord.gg/commingsoon");
		yamlConfiguration.addDefault("Liste.YouTuber", YouTuber);
		yamlConfiguration.addDefault("Liste.Streamer", Streamer);
		yamlConfiguration.addDefault("Liste.Partner", Partner);
		yamlConfiguration.addDefault("Message.Prefix", "§8[§1K0ppc0rd§8] §r");
		yamlConfiguration.addDefault("Message.NoPermission", "§4§lDazu hast du keine Rechte!");
		yamlConfiguration.addDefault("Message.Error", "§4Es ist ein Fehler aufgetreten!");
		yamlConfiguration.addDefault("Message.MOTD", "§9Willkommen auf dem Community Server von K0ppc0rd!");
		yamlConfiguration.addDefault("Message.Rules", Rules);
		yamlConfiguration.addDefault("Message.Help.Help", Helps);
		yamlConfiguration.addDefault("Message.Help.Info", InfoHelp);
		yamlConfiguration.addDefault("Message.Live.Timer.Seconds", 60);
		yamlConfiguration.addDefault("Message.Info.Rang.YouTuber", InfoYouTuber);
		yamlConfiguration.addDefault("Message.Info.Rang.Streamer", InfoStreamer);
		yamlConfiguration.addDefault("Message.Info.Rang.TeamMitglied", InfoTeamMitglied);
		yamlConfiguration.addDefault("Wartung.Aktiv", false);
		yamlConfiguration.addDefault("Wartung.whitelist", allowedWartungUUID);
		yamlConfiguration.addDefault("Wartung.Message.Kick", WartungKickMSG);
		yamlConfiguration.addDefault("Wartung.Message.MOTD", "§c§lWartungsmodus ist derzeit Aktiv!");
		yamlConfiguration.addDefault("Tablist.Header", TablistHeader);
		yamlConfiguration.addDefault("Tablist.Footer", TablistFooter);
		
		try {
			yamlConfiguration.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void reloadConfig() {
		File file = new File(plugin.getDataFolder() + "/config.yml");
		YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);
		
		
		try {
			yamlConfiguration.load(file);
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (InvalidConfigurationException ex) {
			ex.printStackTrace();
		}

	}

	public int getLiveTimer(){
		File file = new File(plugin.getDataFolder() + "/config.yml");
		YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);

		return yamlConfiguration.getInt("Message.Live.Timer.Seconds");

	}

	//List
	public String getYouTuber(){
		File file = new File(plugin.getDataFolder() + "/config.yml");
		YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);

		List<String> list = yamlConfiguration.getStringList("Liste.YouTuber");
		String liststring = String.join("\n§8- ", list);

		return liststring;
	}
	public String getStreamer(){
		File file = new File(plugin.getDataFolder() + "/config.yml");
		YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);

		List<String> list = yamlConfiguration.getStringList("Liste.Streamer");
		String liststring = String.join("\n§8- ", list);

		return liststring;
	}
	public String getPartner(){
		File file = new File(plugin.getDataFolder() + "/config.yml");
		YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);

		List<String> list = yamlConfiguration.getStringList("Liste.Pasrtner");
		String liststring = String.join("\n§8- ", list);

		return liststring;
	}

	public void addYouTuber(String Player){
		File file = new File(plugin.getDataFolder() + "/config.yml");
		YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);

		List<String> spielerlist = yamlConfiguration.getStringList("Liste.YouTuber");
		spielerlist.add(Player);
		yamlConfiguration.set("Liste.YouTuber", spielerlist);

		try {
			yamlConfiguration.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void addStreamer(String Player){
		File file = new File(plugin.getDataFolder() + "/config.yml");
		YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);

		List<String> spielerlist = yamlConfiguration.getStringList("Liste.Streamer");
		spielerlist.add(Player);
		yamlConfiguration.set("Liste.Streamer", spielerlist);

		try {
			yamlConfiguration.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void addPartner(String Player){
		File file = new File(plugin.getDataFolder() + "/config.yml");
		YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);

		List<String> spielerlist = yamlConfiguration.getStringList("Liste.Partner");
		spielerlist.add(Player);
		yamlConfiguration.set("Liste.Partner", spielerlist);

		try {
			yamlConfiguration.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void removeYouTuber(String Player){
		File file = new File(plugin.getDataFolder() + "/config.yml");
		YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);

		List<?> spielerlist = yamlConfiguration.getList("Liste.YouTuber");
		spielerlist.remove(Player);
		yamlConfiguration.set("Liste.YouTuber", spielerlist);

		try {
			yamlConfiguration.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void removeStreamer(String Player){
		File file = new File(plugin.getDataFolder() + "/config.yml");
		YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);

		List<?> spielerlist = yamlConfiguration.getList("Liste.Streamer");
		spielerlist.remove(Player);
		yamlConfiguration.set("Liste.Streamer", spielerlist);

		try {
			yamlConfiguration.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void removePartner(String Player){
		File file = new File(plugin.getDataFolder() + "/config.yml");
		YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);

		List<?> spielerlist = yamlConfiguration.getList("Liste.Partner");
		spielerlist.remove(Player);
		yamlConfiguration.set("Liste.Partner", spielerlist);

		try {
			yamlConfiguration.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//Info
	public String getDiscordLink(){
		File file = new File(plugin.getDataFolder() + "/config.yml");
		YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);

		return yamlConfiguration.getString("Link.Discord");
	}
	public String getInfoYouTuber() {
		File file = new File(plugin.getDataFolder() + "/config.yml");
		YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);

		List<String> list = yamlConfiguration.getStringList("Message.Info.Rang.YouTuber");
		String liststring = String.join("\n", list);

		return liststring.replaceAll("&", "§");
	}
	public String getInfoStreamer() {
		File file = new File(plugin.getDataFolder() + "/config.yml");
		YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);

		List<String> list = yamlConfiguration.getStringList("Message.Info.Rang.Streamer");
		String liststring = String.join("\n", list);

		return liststring.replaceAll("&", "§");
	}
	public String getInfoTeamMitglied() {
		File file = new File(plugin.getDataFolder() + "/config.yml");
		YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);

		List<String> list = yamlConfiguration.getStringList("Message.Info.Rang.TeamMitglied");
		String liststring = String.join("\n", list);

		return liststring.replaceAll("&", "§");
	}
	public String getInfoPartner() {
		File file = new File(plugin.getDataFolder() + "/config.yml");
		YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);

		List<String> list = yamlConfiguration.getStringList("Message.Info.Rang.TeamMitglied");
		String liststring = String.join("\n", list);

		return liststring.replaceAll("&", "§");
	}
	public String getInfoHelp() {
		File file = new File(plugin.getDataFolder() + "/config.yml");
		YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);

		List<String> list = yamlConfiguration.getStringList("Message.Help.Info");
		String liststring = String.join("\n", list);

		return liststring.replaceAll("&", "§");
	}
	
	//Messages and Prefixes
	public String getPrefix() {

		File file = new File(plugin.getDataFolder() + "/config.yml");
		YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);
		
		return yamlConfiguration.getString("Message.Prefix")
				.replaceAll("&", "§");
	}
	public String getRules() {
		
		File file = new File(plugin.getDataFolder() + "/config.yml");
		YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);
		
		List<String> list = yamlConfiguration.getStringList("Message.Rules");
		String liststring = String.join("\n", list);
		
		return liststring.replaceAll("&", "§");
	}
	public String getHelps() {
		File file = new File(plugin.getDataFolder() + "/config.yml");
		YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);
		
		List<String> list = yamlConfiguration.getStringList("Message.Help.Help");
		String liststring = String.join("\n", list);
		
		return liststring.replaceAll("&", "§");
	}
	public String getNoPerm() {
		
		File file = new File(plugin.getDataFolder() + "/config.yml");
		YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);
		String Prefix = this.getPrefix();
		
		return yamlConfiguration.getString("Message.NoPermission")
				.replaceAll("&", "§")
				.replaceAll("%prefix%", Prefix);
	}
	
	public String getError() {
		
		File file = new File(plugin.getDataFolder() + "/config.yml");
		YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);
		String Prefix = this.getPrefix();
		
		return yamlConfiguration.getString("Message.Error")
				.replaceAll("&", "§")
				.replaceAll("%prefix%", Prefix);
	}
	
	public String getMOTD() {
		
		File file = new File(plugin.getDataFolder() + "/config.yml");
		YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);
		
		return yamlConfiguration.getString("Message.MOTD")
				.replaceAll("&", "§");
	}
	
	//Tablist Header Footer
	public String getHeader(Player player) {
		File file = new File(plugin.getDataFolder() + "/config.yml");
		YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);
		
		List<String> list = yamlConfiguration.getStringList("Tablist.Header");
		String liststring = String.join("\n", list);
		
		return liststring
				.replaceAll("&", "§")
				.replaceAll("%player_name%", player.getName())
				.replaceAll("%online_players%", String.valueOf(Bukkit.getOnlinePlayers().size()))
				.replaceAll("%max_players%", String.valueOf(Bukkit.getMaxPlayers())
				.replaceAll("%discordlink%", getDiscordLink()));
	}
	public String getFooter(Player player) {
		File file = new File(plugin.getDataFolder() + "/config.yml");
		YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);
		
		List<String> list = yamlConfiguration.getStringList("Tablist.Footer");
		String liststring = String.join("\n", list);
		
		return liststring
				.replaceAll("&", "§")
				.replaceAll("%player_name%", player.getName())
				.replaceAll("%online_players%", String.valueOf(Bukkit.getOnlinePlayers().size()))
				.replaceAll("%max_players%", String.valueOf(Bukkit.getMaxPlayers()));
	}
	//Wartung
	public boolean isWhitelistet(String uuid){
		File file = new File(plugin.getDataFolder() + "/config.yml");
		YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);
		
		List<String> whitelist =  yamlConfiguration.getStringList("Wartung.whitelist");
		
		if(whitelist.contains(uuid.toString())) {
			return true;
		} else {
			return false;
		}
		
	}
	public boolean isWartugAktiv() {
		File file = new File(plugin.getDataFolder() + "/config.yml");
		YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);
		
		return yamlConfiguration.getBoolean("Wartung.Aktiv");
	}
	public String getWartungKickMessage() {
		File file = new File(plugin.getDataFolder() + "/config.yml");
		YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);
		
		List<String> list = yamlConfiguration.getStringList("Wartung.Message.Kick");
		String liststring = String.join("\n", list);
		
		return liststring
				.replaceAll("&", "§")
				.replaceAll("%prefix%", getPrefix());
	}
	public String getWartungMOTD() {
		File file = new File(plugin.getDataFolder() + "/config.yml");
		YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);
		
		
		return yamlConfiguration.getString("Wartung.Message.MOTD")
				.replaceAll("&", "§")
				.replaceAll("%prefix%", getPrefix());
	}
	public void setWartung(boolean status) {
		File file = new File(plugin.getDataFolder() + "/config.yml");
		YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);
		
		yamlConfiguration.set("Wartung.Aktiv", status);
		
		try {
			yamlConfiguration.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void addAllowedWartung(String uuid) {
		File file = new File(plugin.getDataFolder() + "/config.yml");
		YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);
		
		List<String> uuidlist = yamlConfiguration.getStringList("Wartung.whitelist");
		uuidlist.add(uuid.toString());
		yamlConfiguration.set("Wartung.whitelist", uuidlist);
		
		try {
			yamlConfiguration.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void removeAllowedWartung(String uuid) {
		File file = new File(plugin.getDataFolder() + "/config.yml");
		YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);
		
		List<?> uuidlist = yamlConfiguration.getList("Wartung.whitelist");
		uuidlist.remove(uuid.toString());
		
		try {
			yamlConfiguration.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//Spawn
	public void setSpawn(Player player) {

		File file = new File(plugin.getDataFolder() + "/config.yml");
		YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);
		
		yamlConfiguration.set("Spawn.Loc.X", player.getLocation().getX());
		yamlConfiguration.set("Spawn.Loc.Y", player.getLocation().getY());
		yamlConfiguration.set("Spawn.Loc.Z", player.getLocation().getZ());
		yamlConfiguration.set("Spawn.Loc.Yaw", player.getLocation().getYaw());
		yamlConfiguration.set("Spawn.Loc.Pitch", player.getLocation().getPitch());
		yamlConfiguration.set("Spawn.Loc.World", player.getLocation().getWorld().getName());
		
		try {
			yamlConfiguration.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Location getSpawn() {
		
		File file = new File(plugin.getDataFolder() + "/config.yml");
		YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);
		
		double x = yamlConfiguration.getDouble("Spawn.Loc.X");
		double y = yamlConfiguration.getDouble("Spawn.Loc.Y");
		double z = yamlConfiguration.getDouble("Spawn.Loc.Z");
		String worldString = yamlConfiguration.getString("Spawn.Loc.World");
		float yaw = yamlConfiguration.getInt("Spawn.Loc.Yaw");
		float pitch = yamlConfiguration.getInt("Spawn.Loc.Pitch");
		
		World world = Bukkit.getWorld(worldString);
		
		Location loc = new Location(world, x, y, z);
		loc.setYaw(yaw);
		loc.setPitch(pitch);
		
		return loc;
	}
	
	public boolean spawnExist() {
		
		File file = new File(plugin.getDataFolder() + "/config.yml");
		YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);
		
		if(yamlConfiguration.get("Spawn.Loc") == null) {
			return false;
		} else {
			return true;
		}
	}

}