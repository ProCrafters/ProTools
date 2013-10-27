package pl.themolka.protools;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.entity.Firework;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.meta.FireworkMeta;

public class Fireworks implements Listener {

	ProTools plugin;
	
	public Fireworks(ProTools proTools) {
		plugin = proTools;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		if(!e.getPlayer().hasPlayedBefore()) {
			Firework fw = (Firework) e.getPlayer().getWorld().spawn(e.getPlayer().getLocation(), Firework.class);
			
			FireworkMeta fwMeta = fw.getFireworkMeta();
			fwMeta.addEffect(FireworkEffect.builder()
							.flicker(true)
							.trail(true)
							.with(Type.BALL_LARGE)
							.withColor(Color.RED)
							.withFade(Color.BLUE)
							.build());
			fwMeta.setPower(1);
			fw.setFireworkMeta(fwMeta);
		}
	}
	
}
