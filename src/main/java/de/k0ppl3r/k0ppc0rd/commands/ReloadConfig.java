package de.k0ppl3r.k0ppc0rd.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.k0ppl3r.k0ppc0rd.koppcord;
import de.k0ppl3r.k0ppc0rd.utils.Config;
import de.k0ppl3r.k0ppc0rd.utils.ScoreBoardManager;
import de.k0ppl3r.k0ppc0rd.utils.TabListManager;

public class ReloadConfig implements CommandExecutor{
	
	private final koppcord plugin;
	
	public ReloadConfig(koppcord plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player)sender;
		Config config = new Config(plugin);
		
		ScoreBoardManager scoreboard = new ScoreBoardManager(plugin);
		TabListManager tabListManager = new TabListManager(plugin);
		if(sender instanceof Player) {
			if(cmd.getName().equalsIgnoreCase("reloadconfig")) {
				if(args.length == 0) {
					if(player.hasPermission("k0ppc0rd.reloadconfig")) {
						plugin.reloadConfig();
						config.reloadConfig();
						tabListManager.sendTab(player, config.getHeader(player), config.getFooter(player));
						for(Player all : Bukkit.getOnlinePlayers()) {
							scoreboard.setBoard(all);
						}
						player.sendMessage("Config Reloaded!");
						
					} else {
						player.sendMessage("Noperm");
					}
				} else {
					player.sendMessage("ToomanyAguments");
				}
			}
		} else {
			sender.sendMessage("Du bist kein Spieler!");
		}
		
		
		return false;
	}

}
