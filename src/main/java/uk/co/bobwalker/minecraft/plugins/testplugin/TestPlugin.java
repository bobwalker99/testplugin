package uk.co.bobwalker.minecraft.plugins.testplugin;

import java.io.File;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.JavaPluginLoader;

public class TestPlugin extends JavaPlugin {

    public TestPlugin() {
        super();
    }

    public TestPlugin(JavaPluginLoader loader, PluginDescriptionFile description, File dataFolder, File file) {
        super(loader, description, dataFolder, file);
    }

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
        if (command.getName().equalsIgnoreCase("burn")) {
            return new BurnCommandHandler(new BukkitServerProvider()).handleCommand(sender, command, label, args);
        }
        return false;
    }
}