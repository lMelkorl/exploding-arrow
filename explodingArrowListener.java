package thisPlugin.Melkor.explodingArrow;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class explodingArrowListener implements Listener {

	private explodingArrow plugin;
	
	public explodingArrowListener(explodingArrow plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler(priority = EventPriority.NORMAL)
	public void onProjectileHit(ProjectileHitEvent event) {
		Entity entity = event.getEntity();
		
		if(entity instanceof Arrow) {
			Arrow arrow = (Arrow) entity;
			Entity shooter = (Entity) arrow.getShooter();
			
			if(shooter instanceof Player) {
				Player player = (Player) shooter;
				
				if(plugin.enabledPlayers.contains(player.getName())) {
					player.getWorld().createExplosion(arrow.getLocation(), 5F);
				}
			}
		}
		
	}
	
}
