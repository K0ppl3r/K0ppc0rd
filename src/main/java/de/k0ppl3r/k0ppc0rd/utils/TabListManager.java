package de.k0ppl3r.k0ppc0rd.utils;

import java.lang.reflect.Field;

import net.minecraft.server.v1_8_R3.ChatMessage;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerListHeaderFooter;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import de.k0ppl3r.k0ppc0rd.koppcord;

public class TabListManager {
	
	private final koppcord plugin;
	
	public TabListManager(koppcord plugin) {
		this.plugin = plugin;
	}
	
	public void sendTab(Player player, String head, String foot){
        IChatBaseComponent header = new ChatMessage(head);
        IChatBaseComponent footer = new ChatMessage(foot);
        PacketPlayOutPlayerListHeaderFooter tablist = new PacketPlayOutPlayerListHeaderFooter();
        try {
                Field headerField = tablist.getClass().getDeclaredField("a");
                headerField.setAccessible(true);
                headerField.set(tablist, header);
                Field footerField = tablist.getClass().getDeclaredField("b");
                footerField.setAccessible(true);
                footerField.set(tablist, footer);
        } catch (Exception e) {
                e.printStackTrace();
        }
     
        CraftPlayer cp = (CraftPlayer) player;
        cp.getHandle().playerConnection.sendPacket(tablist);
    }

}
