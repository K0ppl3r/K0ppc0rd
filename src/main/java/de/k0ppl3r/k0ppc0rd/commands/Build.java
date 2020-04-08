package de.k0ppl3r.k0ppc0rd.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.k0ppl3r.k0ppc0rd.koppcord;
import de.k0ppl3r.k0ppc0rd.utils.Config;
import de.k0ppl3r.k0ppc0rd.utils.PlayerManager;

public class Build implements CommandExecutor{
	
	private final koppcord plugin;
	
	public Build(koppcord plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player)sender;
		Config config = new Config(plugin);
		PlayerManager playerManager = new PlayerManager(plugin);
		
		if(sender instanceof Player) {
			if(args.length == 0) {
				if(player.hasPermission("k0ppc0rd.command.build")) {
					if(player.getWorld().getName().equalsIgnoreCase("K0ppunity")) {
						if(!plugin.buildmode.contains(player.getUniqueId())) {
							player.sendMessage("BuildMode activ!");
							plugin.buildmode.add(player.getUniqueId());
							player.setGameMode(GameMode.CREATIVE);
							player.getInventory().clear();
						} else {
							player.sendMessage("BuildMode deactiv!");
							plugin.buildmode.remove(player.getUniqueId());
							player.setGameMode(GameMode.SURVIVAL);
							playerManager.setPlayerJoinItems(player);
						}
					} else {
						playerManager.sendPlayerErrorCode(player, "wrong.world");
					}
				} else {
					playerManager.sendNoPermMessage(player);
				}
			} else {
				playerManager.sendPlayerErrorCode(player, "§6too.many.aguments");
			}
		} else {
			sender.sendMessage("Du musst ein Spieler sein!");
		}
		
		return false;
	}

}
