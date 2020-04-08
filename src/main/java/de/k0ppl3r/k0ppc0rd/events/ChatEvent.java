package de.k0ppl3r.k0ppc0rd.events;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.help.HelpTopic;

import de.k0ppl3r.k0ppc0rd.koppcord;
import de.k0ppl3r.k0ppc0rd.utils.Config;
import de.k0ppl3r.k0ppc0rd.utils.PlayerManager;

public class ChatEvent implements Listener {

	private final koppcord plugin;

	public ChatEvent(koppcord plugin) {
		this.plugin = plugin;
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void nocommand(PlayerCommandPreprocessEvent e){
		if(!(e.isCancelled())){
			Player p = e.getPlayer();
			String msg = e.getMessage().split(" ")[0];
			HelpTopic ht = Bukkit.getServer().getHelpMap().getHelpTopic(msg);
			if(ht == null){
				p.sendMessage("§8[§l§4!§8] §cUnbekannter Befehl! §6["+ msg +"]");
				e.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void Command(PlayerCommandPreprocessEvent e){
		Player p = e.getPlayer();
		String cmd = e.getMessage();
		Config config = new Config(plugin);

		if(cmd.equalsIgnoreCase("/rl") || cmd.equalsIgnoreCase("/reload")){
			if(p.hasPermission("relaod.use") || p.isOp()){
				e.setCancelled(true);
				Bukkit.broadcastMessage("§4§lDer Server wird Neu Geladen! Bitte bewege dich so Wenig wie möglich!");
				Bukkit.broadcastMessage("");
				for(Player all : Bukkit.getOnlinePlayers()) {
					if(all.getGameMode() != GameMode.CREATIVE) {
						all.setAllowFlight(false);
						all.setFlying(false);
					}
				}
				Bukkit.reload();
				Bukkit.broadcastMessage("§a§lDer Server wurde Neu Geladen! Du  kannst du wieder Normal bewegen.");
			}
		} else if(cmd.equalsIgnoreCase("/help") || cmd.equalsIgnoreCase("/hilfe") || cmd.equalsIgnoreCase("/minecraft:help") || cmd.equalsIgnoreCase("/?") || cmd.equalsIgnoreCase("/minecraft:?") ) {
			if(!p.isOp() || !p.hasPermission("k0ppc0rd.helpbypass") || cmd.equalsIgnoreCase("/koppcord help")) {
				p.sendMessage("§8§l----- §a§lHelp §8§l-----\n" + config.getHelps() + "\n§8§l----- §a§lHelp §8§l-----");
				e.setCancelled(true);
			} else {
				e.setCancelled(false);
			}
		}
	}
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		String message = event.getMessage();
		PlayerManager playerManager = new PlayerManager(plugin);
		
		if(message.contains("%")) {
            event.setCancelled(true);
            playerManager.sendPlayerErrorCode(player, "§6unauthorized.sign");
        }
		
		if(player.hasPermission("k0ppc0rd.prefix.besitzer")) {
			event.setFormat("§6☕ §4Besitzer §6§l× §4" + player.getName() + " §8» §c" + message);
			return;
		}
		if(player.hasPermission("k0ppc0rd.prefix.admin")) {
			event.setFormat("§6☕ §4Admin §6§l× §4" + player.getName() + " §8» §6" + message);
			return;
		}
		if(player.hasPermission("k0ppc0rd.prefix.developer")) {
			event.setFormat("§6☕ §3Developer §6§l× §3" + player.getName() + " §8» §b" + message);
			return;
		}
		if(player.hasPermission("k0ppc0rd.prefix.techniker")) {
			event.setFormat("§6☕ §3Techiker §6§l× §3" + player.getName() + " §8» §b" + message);
			return;
		}
		if(player.hasPermission("k0ppc0rd.prefix.designer")) {
			event.setFormat("§6☕ §aDesigner §6§l× §a" + player.getName() + " §8» §e" + message);
			return;
		}
		if(player.hasPermission("k0ppc0rd.prefix.scripter")) {
			event.setFormat("§6☕ §bScripter §6§l× §b" + player.getName() + " §8» §e" + message);
			return;
		}
		if(player.hasPermission("k0ppc0rd.prefix.srmoderator")) {
			event.setFormat("§6☕ §cSrModerator §6§l× §4" + player.getName() + " §8» §6" + message);
			return;
		}
		if(player.hasPermission("k0ppc0rd.prefix.moderator")) {
			event.setFormat("§6☕ §cModerator §6§l× §4" + player.getName() + " §8» §6" + message);
			return;
		}
		if(player.hasPermission("k0ppc0rd.prefix.supporter")) {
			event.setFormat("§6☕ §9Supporter §6§l× §4" + player.getName() + " §8» §6" + message);
			return;
		}
		if(player.hasPermission("k0ppc0rd.prefix.rekrut")) {
			event.setFormat("§6☕ §9Rekrut §6§l× §9" + player.getName() + " §8» §e" + message);
			return;
		}
		if(player.hasPermission("k0ppc0rd.prefix.bekannter")) {
			event.setFormat("§6☕ §dBekannter §6§l× §d" + player.getName() + " §8» §e" + message);
			return;
		}
		if(player.hasPermission("k0ppc0rd.prefix.partner")) {
			event.setFormat("§6☕ §5Partner §6§l× §5" + player.getName() + " §8» §e" + message);
			return;
		}
		if(player.hasPermission("k0ppc0rd.prefix.streamer")) {
			event.setFormat("§5Streamer §6§l× §5" + player.getName() + " §8» §6" + message);
			return;
		}
		if(player.hasPermission("k0ppc0rd.prefix.youtuber")) {
			event.setFormat("§fYou§4Tuber §6§l× §c" + player.getName() + " §8» §6" + message);
			return;
		}
		if(player.hasPermission("k0ppc0rd.prefix.vip")) {
			event.setFormat("§6VIP §8§l× §6" + player.getName() + " §8» §6" + message);
			return;
		}
		event.setFormat("§7Member §8§l× §7" + player.getName() + " §8» §f" + message);
		
	}
	
	@EventHandler
	public void onPing(ServerListPingEvent event) {
		Config config = new Config(plugin);
		
		if(config.isWartugAktiv()) {
			event.setMotd(config.getWartungMOTD());
			event.setMaxPlayers(0);
		} else {
			event.setMotd(config.getMOTD());
			event.setMaxPlayers(Bukkit.getMaxPlayers());
		}
		
	}
	
}
