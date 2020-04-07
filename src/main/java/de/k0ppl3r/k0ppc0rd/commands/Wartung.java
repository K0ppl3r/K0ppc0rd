package de.k0ppl3r.k0ppc0rd.commands;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.k0ppl3r.k0ppc0rd.koppcord;
import de.k0ppl3r.k0ppc0rd.utils.Config;
import de.k0ppl3r.k0ppc0rd.utils.PlayerManager;

public class Wartung implements CommandExecutor{
	
	private final koppcord plugin;

	public Wartung(koppcord plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player)sender;
		Config config = new Config(plugin);
		PlayerManager playerManager = new PlayerManager(plugin);
		
		if(sender instanceof Player) {
			if(args.length == 1) {
				if(player.hasPermission("k0ppc0rd.command.wartung.onoff")) {
					if(args[0].equalsIgnoreCase("on")) {
						if(config.isWartugAktiv()) {
							player.sendMessage(config.getPrefix() + "�aWartung ist bereits Aktiv!");
						} else {
							config.setWartung(true);
							player.sendMessage(config.getPrefix() + "�aWartung ist nun Aktiv!");
						}
					} else if(args[0].equalsIgnoreCase("off")) {
						if(!config.isWartugAktiv()) {
							player.sendMessage(config.getPrefix() + "�cWartung ist bereits nicht Aktiv!");
						} else {
							config.setWartung(false);
							player.sendMessage(config.getPrefix() + "�cWartung ist nun nicht mehr Aktiv!");
						}
					} else  if(args[0].equalsIgnoreCase("status")) {
						player.sendMessage(config.getPrefix() + "�aWartung: �c" + config.isWartugAktiv());
					} else {
						player.sendMessage(config.getPrefix() + "�aUse /wartung <on/off>");
					}
				} else {
					playerManager.sendNoPermMessage(player);
				}
			} else if(args.length == 2) {
				Player target = Bukkit.getPlayer(args[1]);
				String StringUUID = args[1];
				if(player.hasPermission("k0ppc0rd.wartung.addremove")) {
					if(args[0].equalsIgnoreCase("add")) {
						if(StringUUID.contains("-")) {
							if(!config.isWhitelistet(StringUUID)) {
								config.addAllowedWartung(StringUUID);
								player.sendMessage(config.getPrefix() + "�aDer Spieler �c" + StringUUID + " �awurde auf die Wartungs Whitelist gesetzt!");
							} else {
								player.sendMessage(config.getPrefix() + "�cDer Spieler �c�n" + StringUUID + " �cist bereits auf der Wartungs Whitelist!");
							}
						} else {
							player.sendMessage(config.getPrefix() + "�cDer Spieler �6" + args[1] + " �ckonnte nicht gefunden werden!");
						}
						if(!StringUUID.contains("-")) {
							if(target != null) {
								if(!config.isWhitelistet(target.getUniqueId().toString())) {
									config.addAllowedWartung(target.getUniqueId().toString());
									player.sendMessage(config.getPrefix() + "�aDer Spieler �c" + target.getName() + " �awurde auf die Wartungs Whitelist gesetzt!");
								} else {
									player.sendMessage(config.getPrefix() + "�cDer Spieler �c�n" + target.getName() + " �cist bereits auf der Wartungs Whitelist!");
								}
							} else {
								player.sendMessage(config.getPrefix() + "�cDer Spieler �6" + args[1] + " �ckonnte nicht gefunden werden!");
							}
						}
					} else if(args[0].equalsIgnoreCase("remove")) {
						if(StringUUID.contains("-")) {
							if(config.isWhitelistet(StringUUID)) {
								config.removeAllowedWartung(StringUUID);
								player.sendMessage(config.getPrefix() + "�aDer Spieler �c" + StringUUID + " �awurde auf die Wartungs Whitelist entfernt!");
							} else {
								player.sendMessage(config.getPrefix() + "�cDer Spieler �c�n" + StringUUID + " �cist nicht auf der Wartungs Whitelist!");
							}
						} else {
							player.sendMessage(config.getPrefix() + "�cDer Spieler �6" + args[1] + " �ckonnte nicht gefunden werden!");
						}
						if(!StringUUID.contains("-")) {
							if(target != null) {
								if(config.isWhitelistet(target.getUniqueId().toString())) {
									config.removeAllowedWartung(target.getUniqueId().toString());
									player.sendMessage("�cDer Spieler �c�n" + target.getName() + " �cwurde von der Wartungs Whitelist entfernt!");
								} else {
									player.sendMessage("�cDer Spieler �c�n" + target.getName() + " �cist nicht auf der Wartungs Whitelist!");
								}
							} else {
								player.sendMessage(config.getPrefix() + "�cDer Spieler �6" + args[1] + " �ckonnte nicht gefunden werden!");
							}
						}
					} else {
						player.sendMessage(config.getPrefix() + "�aUse /wartung <add/remove> <player/uuid>");
					}
				} else {
					player.sendMessage(config.getNoPerm());
				}
			} else {
				player.sendMessage(config.getPrefix() + "�aUse \"/help\" for help!");
			}
		} else {
			sender.sendMessage("Du musst ein Spieler sein!");
		}
		return false;
	}

}
