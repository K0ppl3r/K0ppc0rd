package de.k0ppl3r.k0ppc0rd.commands;

import de.k0ppl3r.k0ppc0rd.koppcord;
import de.k0ppl3r.k0ppc0rd.utils.Config;
import de.k0ppl3r.k0ppc0rd.utils.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.UUID;

public class Live implements CommandExecutor {

    private final koppcord plugin;

    ArrayList<UUID> commandused = new ArrayList<UUID>();

    public Live(koppcord plugin){
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Config config = new Config(plugin);

        if(commandSender instanceof Player){
            final Player player = (Player)commandSender;
            PlayerManager playerManager = new PlayerManager(plugin);
            if(player.hasPermission("k0ppc0rd.live.use")) {
                if (strings.length == 0) {
                    player.sendMessage(config.getPrefix() + "Bitte verwende \"/live <Link/Name>\"!");
                } else if (strings.length == 1) {
                    if(!commandused.contains(player.getUniqueId())){
                        if(!player.hasPermission("k0ppc0rd.live.timer.bypass")) {
                            commandused.add(player.getUniqueId());
                            Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
                                public void run() {
                                    commandused.remove(player.getUniqueId());
                                }
                            }, config.getLiveTimer()*20);
                        }
                        for(Player all : Bukkit.getOnlinePlayers()){
                            playerManager.sendPlayerSkull(player, all, "§4§l● §5" + player.getName() + " ist nun Live! §4§l●", "§7§nLink/Name: §a" + strings[0]);
                        }
                    } else {
                        player.sendMessage(config.getPrefix() + "§cDu kannst diesen Command nur alle "+ config.getLiveTimer() +" Sekunden nutzen!");
                    }
                } else {
                    playerManager.sendPlayerErrorCode(player, "too.many.arguments");
                }
            } else {
                player.sendMessage(config.getNoPerm());
            }
        } else {
            commandSender.sendMessage("Du musst ein Spieler sein!");
        }

        return false;
    }

}
