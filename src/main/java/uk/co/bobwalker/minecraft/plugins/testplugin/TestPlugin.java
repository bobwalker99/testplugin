package uk.co.bobwalker.minecraft.plugins.testplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class TestPlugin extends JavaPlugin {

	@Override
	public void onEnable() {
		getLogger().info("onEnable has been invoked!");
	}
	
	@Override
	public void onDisable() {
		getLogger().info("onDisable has been invoked!");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		getLogger().info("onCommand has been invoked");
		if (command.getName().equalsIgnoreCase("awesome") && sender instanceof Player) {
			Player player = (Player)sender;
			player.sendMessage(String.format("Hello %s, your Dad is awesome!", player.getName()));
			return true;
		}
		return false;
	}
}
