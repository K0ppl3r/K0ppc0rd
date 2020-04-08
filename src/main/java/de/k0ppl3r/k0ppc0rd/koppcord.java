package de.k0ppl3r.k0ppc0rd;

import java.util.ArrayList;
import java.util.UUID;

import de.k0ppl3r.k0ppc0rd.commands.*;
import org.bukkit.plugin.java.JavaPlugin;

import de.k0ppl3r.k0ppc0rd.events.ChatEvent;
import de.k0ppl3r.k0ppc0rd.events.JoinQuitEvent;
import de.k0ppl3r.k0ppc0rd.events.DenyedEvents;
import de.k0ppl3r.k0ppc0rd.events.InventoryEvent;
import de.k0ppl3r.k0ppc0rd.utils.Config;

public class koppcord extends JavaPlugin{
	
	private static koppcord instance;
	
	public ArrayList<UUID> buildmode = new ArrayList<UUID>();
	
	
	@Override
	public void onEnable() {
		
		instance = this;

		new Config(this).createConfig();
		
		getCommand("spawn").setExecutor(new Spawn(this));
		getCommand("reloadconfig").setExecutor(new ReloadConfig(this));
		getCommand("rule").setExecutor(new Rule(this));
		getCommand("wartung").setExecutor(new Wartung(this));
		getCommand("build").setExecutor(new Build(this));
		getCommand("playerdata").setExecutor(new playerdata());
		getCommand("live").setExecutor(new Live(this));
		getCommand("newvideo").setExecutor(new NewVideo(this));
		getCommand("info").setExecutor(new Info(this));
		
		getServer().getPluginManager().registerEvents(new JoinQuitEvent(this), this);
		getServer().getPluginManager().registerEvents(new ChatEvent(this), this);
		getServer().getPluginManager().registerEvents(new DenyedEvents(this), this);
		getServer().getPluginManager().registerEvents(new InventoryEvent(this), this);
		
		System.out.println("Plugin by K0ppl3r");
		super.onEnable();
	}
	
	@Override
	public void onDisable() {
		
		buildmode.clear();
		
		super.onDisable();
	}

	public koppcord getInstance() {
		return instance;
	}
}
