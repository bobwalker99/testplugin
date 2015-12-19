package uk.co.bobwalker.minecraft.plugins.fatduckplugin.command;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import uk.co.bobwalker.minecraft.plugins.fatduckplugin.server.ServerProvider;

public class FlyCommandHandler implements CommandHandler {

    private ServerProvider serverProvider;
    private Logger logger;

    public FlyCommandHandler(ServerProvider serverProvider, Logger logger) {
        this.serverProvider = serverProvider;
        this.logger = logger;
    }

    @Override
    public boolean handleCommand(CommandSender sender, Command command, String label, String[] args) {
        this.logger.info("FlyCommandHandler handling command");
        if (sender instanceof Player) {
            Player playerSender = (Player) sender;
            this.logger.info("allowFlight: " + playerSender.getAllowFlight());
            this.logger.info("flying: " + playerSender.isFlying());
            String msg;
            if (playerSender.isFlying()) {
                playerSender.setFlying(false);
                playerSender.setAllowFlight(false);
                msg = ChatColor.RED + "Down you come, fattyfly!";
            } else {
                playerSender.setAllowFlight(true);
                playerSender.setFlying(true);
                msg = ChatColor.GREEN + "Fly, be free!";
            }
            playerSender.sendMessage(msg);
            return true;
        }
        return false;
    }
}
