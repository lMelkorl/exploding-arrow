package thisPlugin.Melkor.explodingArrow;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class explodingArrowExecutor implements CommandExecutor {
	
	private explodingArrow plugin;
	
	//constructor??
	public explodingArrowExecutor(explodingArrow plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player == false) {
			
			sender.sendMessage(ChatColor.RED + "This command is for players only.");
			
			return true;
		}
		
		Player player = (Player) sender;
		String playerName = player.getName();
		
		if(plugin.enabledPlayers.contains(playerName)) {
			plugin.enabledPlayers.remove(playerName);
			player.sendMessage(ChatColor.RED + "Explosive arrows off!");
			
		}else {
			plugin.enabledPlayers.add(playerName);
			player.sendMessage(ChatColor.GREEN + "Explosive arrows are on!");
		}
		
		return true;
	}

	
}
