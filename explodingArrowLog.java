package thisPlugin.Melkor.explodingArrow;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;

public class explodingArrowLog{

	private explodingArrow plugin;
	private Logger log;
	
	public explodingArrowLog(explodingArrow plugin) {
		this.plugin = plugin;
		this.log = Logger.getLogger("Minecraft");
	}
	
	private String buildString(String msg) {
		PluginDescriptionFile pdFile = plugin.getDescription();
		
		return "[" + pdFile.getName() + " " + pdFile.getVersion() + "]: " + msg;
	}
	
	public void info(String msg) {
		this.log.info(this.buildString(msg));
	}
	
	public void warn(String msg) {
		this.log.warning(this.buildString(msg));
	}
	
	public void severe(String msg) {
		this.log.severe(this.buildString(msg));
	}
	
}