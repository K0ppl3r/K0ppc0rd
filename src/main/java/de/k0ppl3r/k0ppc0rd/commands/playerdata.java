package de.k0ppl3r.k0ppc0rd.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.HoverEvent.Action;

public class playerdata implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player)sender;
		
		if(sender instanceof Player) {
			if(args.length == 1) {
				 if(player.hasPermission("k0ppc0rd.playerdata")) {
					 Player target = Bukkit.getPlayer(args[0]);
					 
					 	TextComponent infocomp = new TextComponent();
		             	infocomp.setText(target.getUniqueId().toString());
		             	infocomp.setHoverEvent(new HoverEvent(Action.SHOW_TEXT, new ComponentBuilder("Klick zum Kopieren").create()));
		             	infocomp.setClickEvent(new ClickEvent(net.md_5.bungee.api.chat.ClickEvent.Action.SUGGEST_COMMAND, target.getUniqueId().toString()));
		             	infocomp.setObfuscated(true);
		                
		                TextComponent prefix = new TextComponent();
		                prefix.setText("[DEBUG] §r");
		                
		                player.spigot().sendMessage(prefix, infocomp);
				 } else {
					 player.sendMessage("ERROR");
				 }
			} else {
				player.sendMessage("ERROR");
			}
		} else {
			sender.sendMessage("ERROR");
		}
		
		return false;
	}
	

}
