package uk.co.bobwalker.minecraft.plugins.testplugin;

import org.bukkit.Bukkit;
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
        // Make sure that the player specified exactly one argument (the name of
        // the player to ignite).
        if (args.length != 1) {
            // When onCommand() returns false, the help message associated with
            // that command is displayed.
            return false;
        }
        if (command.getName().equalsIgnoreCase("burn") && sender instanceof Player) {
            // Make sure the sender is a player.
            if (!(sender instanceof Player)) {
                sender.sendMessage("Only players can set other players on fire.");
                return true;
            }

            // Get the player who should be set on fire. Remember that indices
            // start with 0, not 1.
            Player target = Bukkit.getServer().getPlayer(args[0]);

            // Make sure the player is online.
            if (target == null) {
                sender.sendMessage(args[0] + " is not currently online.");
                return true;
            }

            // Sets the player on fire for 1,000 ticks (there are ~20 ticks in
            // second, so 50 seconds total).
            target.setFireTicks(200);
            return true;
        }
        return false;
    }
}