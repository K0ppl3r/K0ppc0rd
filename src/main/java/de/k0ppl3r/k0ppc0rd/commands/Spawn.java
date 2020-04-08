package de.k0ppl3r.k0ppc0rd.commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.k0ppl3r.k0ppc0rd.koppcord;
import de.k0ppl3r.k0ppc0rd.utils.Config;
import de.k0ppl3r.k0ppc0rd.utils.PlayerManager;

public class Spawn implements CommandExecutor{
	
	private final koppcord plugin;
	
	public Spawn(koppcord plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player player = (Player)sender;
		PlayerManager playerManager = new PlayerManager(plugin);
		Config config = new Config(plugin);
		if(sender instanceof Player) {
			if(args.length == 0) {
				if(player.hasPermission("k0ppc0rd.command.spawn")) {
					if(config.spawnExist()) {
						player.teleport(config.getSpawn());
						player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
					} else {
						playerManager.sendPlayerErrorCode(player, "§6spawn.not.exist");
					}
				} else {
					player.sendMessage(config.getNoPerm());
				}
			} else if(args.length == 1) {
				if(args[0].equalsIgnoreCase("set")) {
					if(player.hasPermission("k0ppc0rd.command.spawn.set")) {
						config.setSpawn(player);
						player.sendMessage(config.getPrefix() + "§9Der Spawn wurde erfolgreich gesetzt!");
					} else {
						player.sendMessage(config.getNoPerm());
					}
				} else {
					playerManager.sendPlayerErrorCode(player, "§6invalid.agument");
				}
			} else {
				playerManager.sendPlayerErrorCode(player, "§6too.many.aguments");
			}
		} else {
			sender.sendMessage(config.getError());
		}
		
		return false;
	}

}
