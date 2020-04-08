package de.k0ppl3r.k0ppc0rd.commands;

import de.k0ppl3r.k0ppc0rd.koppcord;
import de.k0ppl3r.k0ppc0rd.utils.Config;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Info implements CommandExecutor {

    private final koppcord plugin;

    public Info(koppcord plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(commandSender instanceof Player){
            Config config = new Config(plugin);
            Player player = (Player)commandSender;
            //   0    1    2
            // /info rang youtuber (Anforderungen)
            // /info rang streamer (Anforderungen)
            // /info rang teammitglied (Anforderungen)
            // /info discord | (Discord Link)
            // /info youtuber | (YouTuber List)
            // /info streamer | (Streamer List)
            // /info partner | (Partner List)
            // /info addyoutuber <Spieler> | (Add YouTuber to list)
            // /info addstreamer <Spieler> | (Add Streamer to list)
            // /info removeyoutuber <Spieler> | (Remove YouTuber from list)
            // /info removestreamer <Spieler> | (Remove Streamer from list)
            // /info

            if(strings.length == 0){
                player.sendMessage(config.getInfoHelp());
            } else if (strings.length == 1) {
                if(strings[0].equalsIgnoreCase("discord")){
                    player.sendMessage(config.getPrefix() + "§9Discord Link: " + config.getDiscordLink());
                }
                if(strings[0].equalsIgnoreCase("youtuber")){
                    player.sendMessage("K0ppc0rd YouTuber:");
                    player.sendMessage(config.getYouTuber());
                    player.sendMessage("");
                }
                if(strings[0].equalsIgnoreCase("streamer")){
                    player.sendMessage("K0ppc0rd Streamer:");
                    player.sendMessage(config.getStreamer());
                    player.sendMessage("");
                }
                if(strings[0].equalsIgnoreCase("partner")){
                    player.sendMessage("K0ppc0rd Partner:");
                    player.sendMessage(config.getPartner());
                    player.sendMessage("");
                }
            } else if(strings.length == 2) {

            } else {

            }
        }

        return false;
    }
}
