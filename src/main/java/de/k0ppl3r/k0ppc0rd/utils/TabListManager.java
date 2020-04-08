package de.k0ppl3r.k0ppc0rd.utils;

import java.lang.reflect.Field;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerListHeaderFooter;
import net.minecraft.server.v1_8_R3.PlayerConnection;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import de.k0ppl3r.k0ppc0rd.koppcord;

public class TabListManager {
	
	private final koppcord plugin;
	
	public TabListManager(koppcord plugin) {
		this.plugin = plugin;
	}

    public void sendTab(Player p, String head, String foot) {
        if(head == null) head = "";
        if(foot == null) foot = "";

        PlayerConnection connection = ((CraftPlayer) p).getHandle().playerConnection;

        IChatBaseComponent header = ChatSerializer.a("{'color':'', 'text':'" + head + "'}");
        IChatBaseComponent footer = ChatSerializer.a("{'color':'', 'text':'" + foot + "'}");

        PacketPlayOutPlayerListHeaderFooter packet = new PacketPlayOutPlayerListHeaderFooter();
        try {
            Field headerField = packet.getClass().getDeclaredField("a");
            headerField.setAccessible(true);
            headerField.set(packet, header);
            headerField.setAccessible(!headerField.isAccessible());

            Field footerField = packet.getClass().getDeclaredField("b");
            footerField.setAccessible(true);
            footerField.set(packet, footer);
            footerField.setAccessible(!footerField.isAccessible());
        } catch (Exception e) {
            e.printStackTrace();
        }

        connection.sendPacket(packet);
    }

}
