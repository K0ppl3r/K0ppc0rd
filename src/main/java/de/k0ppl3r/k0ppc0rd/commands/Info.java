package de.k0ppl3r.k0ppc0rd.commands;

import de.k0ppl3r.k0ppc0rd.koppcord;
import de.k0ppl3r.k0ppc0rd.utils.Config;
import org.bukkit.Bukkit;
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
            // /info rang partner (Anforderungen)
            // /info addyoutuber <Spieler> | (Add YouTuber to list)
            // /info addstreamer <Spieler> | (Add Streamer to list)
            // /info removeyoutuber <Spieler> | (Remove YouTuber from list)
            // /info removestreamer <Spieler> | (Remove Streamer from list)
            // /info discord | (Discord Link)
            // /info youtuber | (YouTuber List)
            // /info streamer | (Streamer List)
            // /info partner | (Partner List)
            // /info

            if(strings.length == 0){
                player.sendMessage(config.getInfoHelp());
            } else if (strings.length == 1) {
                if(strings[0].equalsIgnoreCase("discord")){
                    player.sendMessage(config.getPrefix() + "§9Discord Link: " + config.getDiscordLink());
                }
                if(strings[0].equalsIgnoreCase("help")){
                    player.sendMessage(config.getInfoHelp());
                }
                if(strings[0].equalsIgnoreCase("youtuber")){
                    player.sendMessage("§7===== §cYou§fTuber §7=====");
                    player.sendMessage("§8- " + config.getYouTuber());
                    player.sendMessage("§7===== §cYou§fTuber §7=====");
                }
                if(strings[0].equalsIgnoreCase("streamer")){
                    player.sendMessage("§7===== §5Streamer §7=====");
                    player.sendMessage("§8- " + config.getStreamer());
                    player.sendMessage("§7===== §5Streamer §7=====");
                }
                if(strings[0].equalsIgnoreCase("partner")){
                    player.sendMessage("§7===== §5Partner §7=====");
                    player.sendMessage("§8- " + config.getPartner());
                    player.sendMessage("§7===== §5Partner §7=====");
                }
                return true;
            } else if(strings.length == 2) {
                // /info rang youtuber (Anforderungen)
                // /info rang streamer (Anforderungen)
                // /info rang teammitglied (Anforderungen)
                // /info addyoutuber <Spieler> | (Add YouTuber to list)
                // /info addstreamer <Spieler> | (Add Streamer to list)
                // /info removeyoutuber <Spieler> | (Remove YouTuber from list)
                // /info removestreamer <Spieler> | (Remove Streamer from list)
                if(strings[0] != null){
                    if(strings[1] != null){
                        String target = strings[1];
                        if (strings[0].equalsIgnoreCase("addyoutuber")) {
                            if(player.hasPermission("k0ppc0rd.addyoutuber.use")){
                                if(!config.getYouTuber().contains(target)){
                                    config.addYouTuber(target);
                                    player.sendMessage(config.getPrefix() + "§cYou§fTuber §c" + target  +" §awurde der Liste Hinzugefügt!");
                                } else {
                                    player.sendMessage(config.getPrefix() + "§cYou§fTuber §c" + target + " §aist bereits auf der Liste!");
                                }
                            } else {
                                player.sendMessage(config.getNoPerm());
                            }
                        } else
                        if (strings[0].equalsIgnoreCase("addstreamer")) {
                            if(player.hasPermission("k0ppc0rd.addstreamer.use")){
                                if(!config.getStreamer().contains(target)){
                                    config.addStreamer(target);
                                    player.sendMessage(config.getPrefix() + "§5Streamer §c" + target  +" §awurde der Liste Hinzugefügt!");
                                } else {
                                    player.sendMessage(config.getPrefix() + "§5Streamer §c" + target + " §aist bereits auf der Liste!");
                                }
                            } else {
                                player.sendMessage(config.getNoPerm());
                            }
                        } else
                        if (strings[0].equalsIgnoreCase("addpartner")) {
                            if(player.hasPermission("k0ppc0rd.addpartner.use")){
                                if(!config.getPartner().contains(target)){
                                    config.addPartner(target);
                                    player.sendMessage(config.getPrefix() + "§5Partner §c" + target  +" §awurde der Liste Hinzugefügt!");
                                } else {
                                    player.sendMessage(config.getPrefix() + "§5Partner §c" + target + " §aist bereits auf der Liste!");
                                }
                            } else {
                                player.sendMessage(config.getNoPerm());
                            }
                        } else
                        if (strings[0].equalsIgnoreCase("removeyoutuber")) {
                            if(player.hasPermission("k0ppc0rd.removeyoutuber.use")){
                                if(config.getYouTuber().contains(target)){
                                    config.removeYouTuber(target);
                                    player.sendMessage(config.getPrefix() + "§cYou§fTuber §c§n" + target  + " §cwurde von der Liste entfernt!");
                                } else {
                                    player.sendMessage(config.getPrefix() + "§cYou§fTuber §c§n" + target + " §cist bereits von der Liste!");
                                }
                            } else {
                                player.sendMessage(config.getNoPerm());
                            }
                        } else
                        if (strings[0].equalsIgnoreCase("removestreamer")) {
                            if(player.hasPermission("k0ppc0rd.removestreamer.use")){
                                if(config.getYouTuber().contains(target)){
                                    config.removeStreamer(target);
                                    player.sendMessage(config.getPrefix() + "§cYou§fTuber §c§n" + target  + " §cwurde von der Liste entfernt!");
                                } else {
                                    player.sendMessage(config.getPrefix() + "§cYou§fTuber §c§n" + target + " §cist bereits von der Liste!");
                                }
                            } else {
                                player.sendMessage(config.getNoPerm());
                            }
                        } else
                        if (strings[0].equalsIgnoreCase("removepartner")) {
                            if(player.hasPermission("k0ppc0rd.removepartner.use")){
                                if(config.getYouTuber().contains(target)){
                                    config.removePartner(target);
                                    player.sendMessage(config.getPrefix() + "§cYou§fTuber §c§n" + target  + " §cwurde von der Liste entfernt!");
                                } else {
                                    player.sendMessage(config.getPrefix() + "§cYou§fTuber §c§n" + target + " §cist bereits von der Liste!");
                                }
                            } else {
                                player.sendMessage(config.getNoPerm());
                            }
                        } else
                        if(strings[0].equalsIgnoreCase("rang")){
                            if (strings[1].equalsIgnoreCase("youtuber")) {
                                player.sendMessage(config.getInfoYouTuber());
                            } else if(strings[1].equalsIgnoreCase("streamer")){
                                player.sendMessage(config.getInfoStreamer());
                            } else if(strings[1].equalsIgnoreCase("partner")){
                                player.sendMessage(config.getInfoPartner());
                            } else if(strings[1].equalsIgnoreCase("teammitglied")){
                                player.sendMessage(config.getInfoTeamMitglied());
                            } else {
                                player.sendMessage(config.getInfoHelp());
                            }
                        } else {
                            player.sendMessage(config.getPrefix() + "Bitte verwende \"/info help\" um eine Übersicht an Befehlen zu bekommen!");
                        }
                    } else {
                        player.sendMessage(config.getPrefix() + "Bitte verwende \"/info help\" um eine Übersicht an Befehlen zu bekommen!");
                    }
                } else {
                    player.sendMessage(config.getPrefix() + "Bitte verwende \"/info help\" um eine Übersicht an Befehlen zu bekommen!");
                }
            } else {
                player.sendMessage(config.getPrefix() + "Bitte verwende \"/info help\" um eine Übersicht an Befehlen zu bekommen!");
            }
        } else {
            commandSender.sendMessage("Du musst ein Spieler sein!");
        }

        return false;
    }
}
