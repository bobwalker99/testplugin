package uk.co.bobwalker.minecraft.plugins.fatduckplugin;

import java.io.File;
import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.JavaPluginLoader;

import uk.co.bobwalker.minecraft.plugins.fatduckplugin.command.CommandHandler;
import uk.co.bobwalker.minecraft.plugins.fatduckplugin.command.CommandHandlerFactory;
import uk.co.bobwalker.minecraft.plugins.fatduckplugin.server.BukkitServerProvider;
import uk.co.bobwalker.minecraft.plugins.fatduckplugin.server.ServerProvider;

public class FatDuckPlugin extends JavaPlugin {

    private ServerProvider serverProvider;
    private Logger logger;

    public FatDuckPlugin() {
        super();
        this.serverProvider = new BukkitServerProvider();
        this.logger = this.getLogger();
    }

    public FatDuckPlugin(JavaPluginLoader loader, PluginDescriptionFile description, File dataFolder, File file) {
        super(loader, description, dataFolder, file);
        this.logger = this.getLogger();
        this.serverProvider = new BukkitServerProvider();
    }

    @Override
    public void onEnable() {
        this.logger.info("onEnable has been invoked!");
    }

    @Override
    public void onDisable() {
        this.logger.info("onDisable has been invoked!");
    }

    /**
     * 
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        CommandHandler handler = CommandHandlerFactory.getCommandHandler(command.getName(), this.serverProvider,
                this.logger);
        if (null != handler) {
            return handler.handleCommand(sender, command, label, args);
        }
        return false;
    }
}