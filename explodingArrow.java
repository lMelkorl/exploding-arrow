package thisPlugin.Melkor.explodingArrow;

import java.util.ArrayList;

import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class explodingArrow extends JavaPlugin implements Listener{
	
	protected explodingArrowLog log;
	protected ArrayList<String> enabledPlayers;
	
	//temel onEnable komutları
	public void onEnable() {
		this.log = new explodingArrowLog(this); 
		this.enabledPlayers = new ArrayList<String>();
		
		//eğer komut yazılırsa patlayıcı executor calıısın
		this.getCommand("patla").setExecutor((CommandExecutor) new explodingArrowExecutor(this));
		
		PluginManager manger = this.getServer().getPluginManager();
		
		manger.registerEvents(new explodingArrowListener(this), this);
	}
	
}