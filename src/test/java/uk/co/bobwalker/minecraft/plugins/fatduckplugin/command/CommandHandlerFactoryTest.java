package uk.co.bobwalker.minecraft.plugins.fatduckplugin.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;

import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;

import uk.co.bobwalker.minecraft.plugins.fatduckplugin.command.BurnCommandHandler;
import uk.co.bobwalker.minecraft.plugins.fatduckplugin.command.CommandHandler;
import uk.co.bobwalker.minecraft.plugins.fatduckplugin.command.CommandHandlerFactory;
import uk.co.bobwalker.minecraft.plugins.fatduckplugin.server.ServerProvider;

public class CommandHandlerFactoryTest {

    private ServerProvider serverProvider;
    private Logger logger;

    @Before
    public void setup() {
        this.serverProvider = mock(ServerProvider.class);
        this.logger = mock(Logger.class);
    }

    @Test
    public void testGetValidHandler() {
        // Given
        String commandName = "burn";

        // When
        CommandHandler commandHandler = CommandHandlerFactory.getCommandHandler(commandName, this.serverProvider,
                this.logger);

        // Then
        assertNotNull(commandHandler);
        assertEquals(BurnCommandHandler.class, commandHandler.getClass());
    }

    @Test
    public void testUnrecognisedCommand() {
        // Given
        String commandName = "blahblahblah";

        // When
        CommandHandler commandHandler = CommandHandlerFactory.getCommandHandler(commandName, this.serverProvider,
                this.logger);

        // Then
        assertNull(commandHandler);
    }

}
