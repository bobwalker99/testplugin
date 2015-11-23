package uk.co.bobwalker.minecraft.plugins.testplugin.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public interface CommandHandler {
    boolean handleCommand(CommandSender sender, Command command, String label, String[] args);
}
