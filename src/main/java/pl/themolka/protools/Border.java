package pl.themolka.protools;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class Border implements Listener {

	private static ProTools plugin;
	
	public Border(ProTools proTools) {
		plugin = proTools;
	}
	
	public static int getX() {
		int a = plugin.getConfig().getInt("border.x");
		return a;
	}
	
	public double getXPlus() {
		double a = getX() + getRadius();
		return a;
	}
	
	public double getXMinus() {
		double a = getX() - getRadius();
		return a;
	}
	
	public static int getZ() {
		int a = plugin.getConfig().getInt("border.z");
		return a;
	}
	
	public double getZPlus() {
		double a = getZ() + getRadius();
		return a;
	}
	
	public double getZMinus() {
		double a = getZ() + getRadius();
		return a;
	}
	
	public static int getRadius() {
		int a = plugin.getConfig().getInt("border");
		return a;
	}
	
	public static void setBorder(Player player, Location location, int radius) {
		int x = location.getBlockX();
		int z = location.getBlockZ();
		
		plugin.getConfig().set("border.x", x);
		plugin.getConfig().set("border.z", z);
		plugin.getConfig().set("border.radius", radius);
		plugin.saveConfig();
		
		player.sendMessage(ChatColor.GOLD + "[ProTools] " + ChatColor.DARK_GREEN + "Pomyslnie utworzono border o promieniu " + radius + ".");
	}
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		if(e.getTo().getBlockX() < getXMinus()) {
			e.getPlayer().sendMessage(ChatColor.GOLD + "[ProTools] " + Util.border());
			e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENDERMAN_TELEPORT, 10, 1);
		}
		if(e.getTo().getBlockX() > getXPlus()) {
			e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENDERMAN_TELEPORT, 10, 1);
			e.getPlayer().sendMessage(ChatColor.GOLD + "[ProTools] " + Util.border());
		}
		if(e.getTo().getBlockZ() < getZMinus()) {
			e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENDERMAN_TELEPORT, 10, 1);
			e.getPlayer().sendMessage(ChatColor.GOLD + "[ProTools] " + Util.border());
		}
		if(e.getTo().getBlockZ() > getZPlus()) {
			e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENDERMAN_TELEPORT, 10, 1);
			e.getPlayer().sendMessage(ChatColor.GOLD + "[ProTools] " + Util.border());
		}
	}
	
}
