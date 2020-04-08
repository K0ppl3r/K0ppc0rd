package de.k0ppl3r.k0ppc0rd.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.k0ppl3r.k0ppc0rd.koppcord;
import de.k0ppl3r.k0ppc0rd.utils.Config;
import de.k0ppl3r.k0ppc0rd.utils.PlayerManager;

public class Rule implements CommandExecutor{
	
	private final koppcord plugin;

	public Rule(koppcord plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player)sender;
		Config config = new Config(plugin);
		PlayerManager playerManager = new PlayerManager(plugin);
		
		if(sender instanceof Player) {
			if(args.length == 0) {
				player.sendMessage("§8§l----- §4§lRegeln §8§l-----\n" + config.getRules() + "\n§8§l----- §4§lRegeln §8§l-----");
			} else {
				playerManager.sendPlayerErrorCode(player, "§6too.many.aguments!");
			}
		} else {
			sender.sendMessage("Du musst ein Spieler sein!");
		}
		
		return false;
	}
}
