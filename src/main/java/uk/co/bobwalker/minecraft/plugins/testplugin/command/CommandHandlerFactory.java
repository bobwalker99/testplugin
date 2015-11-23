package uk.co.bobwalker.minecraft.plugins.testplugin.command;

import uk.co.bobwalker.minecraft.plugins.testplugin.server.ServerProvider;

public class CommandHandlerFactory {

    static CommandHandler getCommandHandler(Command command, ServerProvider provider) {
        switch (command) {
        case BURN:
            return new BurnCommandHandler(provider);
        }
        return null;
    }
}
