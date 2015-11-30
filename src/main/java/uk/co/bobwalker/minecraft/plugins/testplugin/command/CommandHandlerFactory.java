package uk.co.bobwalker.minecraft.plugins.testplugin.command;

import java.util.logging.Logger;

import uk.co.bobwalker.minecraft.plugins.testplugin.server.ServerProvider;

public class CommandHandlerFactory {

    /**
     * Gets a handler that can handle the given command.
     * 
     * @param command
     * @param provider
     * @param logger
     * @return
     */
    public static CommandHandler getCommandHandler(String commandName, ServerProvider provider, Logger logger) {

        Command command = Command.fromString(commandName.toUpperCase());
        CommandHandler handler = null;
        if (null != command) {
            switch (command) {
            case BURN:
                handler = new BurnCommandHandler(provider, logger);
                break;
            default:
            }
        }
        return handler;
    }
}
