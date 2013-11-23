package pl.themolka.protools;

import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class ProTools extends JavaPlugin implements Listener {
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new Fireworks(this), this);
		getServer().getPluginManager().registerEvents(new Border(this), this);
		getServer().getPluginManager().registerEvents(new LoginMessages(), this);
		
		getCommand("protools").setExecutor(new ProtoolsCommand(this));
		getCommand("pt").setExecutor(new ProtoolsCommand(this));
		
		getLogger().info("ProTools v1.0 by TheMolkaPL (themolkapl@gmail.com) zostal wlaczony.");
	}
	
	public static String border() {
		String a = ChatColor.RED + "Offf, dotarles do konca mapy! :( Zawróc!";
		return a;
	}
	
}
