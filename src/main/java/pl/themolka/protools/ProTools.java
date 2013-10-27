package pl.themolka.protools;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class ProTools extends JavaPlugin implements Listener {
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		
		getServer().getPluginManager().registerEvents(new Fireworks(this), this);
		getServer().getPluginManager().registerEvents(new Border(this), this);
		
		getCommand("protools").setExecutor(new ProtoolsCommand(this));
		
		getLogger().info("ProTools v1.0 by TheMolkaPL (themolkapl@gmail.com) zostal wlaczony.");
	}
	
}
