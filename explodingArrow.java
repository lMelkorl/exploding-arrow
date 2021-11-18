package thisPlugin.Melkor.explodingArrow;

import java.util.ArrayList;

import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class explodingArrow extends JavaPlugin implements Listener{
	
	protected explodingArrowLog log;
	protected ArrayList<String> enabledPlayers;
	
	//basic onEnable commands
	public void onEnable() {
		this.log = new explodingArrowLog(this); 
		this.enabledPlayers = new ArrayList<String>();
		
		//run explosive executor if command is typed
		this.getCommand("explode").setExecutor((CommandExecutor) new explodingArrowExecutor(this));
		
		PluginManager manger = this.getServer().getPluginManager();
		
		manger.registerEvents(new explodingArrowListener(this), this);
	}
	
}