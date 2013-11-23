package pl.themolka.protools;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class Border implements Listener {

	ProTools plugin;
	static ProTools pluginStatic;
	
	public Border(ProTools proTools) {
		plugin = proTools;
	}
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		if(e.getTo().getBlockX() > 4000 || e.getTo().getBlockX() < -4000 || e.getTo().getBlockZ() > 4000 || e.getTo().getBlockZ() < -4000) {
			e.getPlayer().teleport(e.getFrom());
			e.getPlayer().sendMessage(ChatColor.GOLD + "[ProTools] " + ProTools.border());
			e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENDERMAN_TELEPORT, 10, 1);
		}
	}
	
}
