package uk.co.bobwalker.minecraft.plugins.fatduckplugin.command;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.logging.Logger;

import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.junit.Before;
import org.junit.Test;

import uk.co.bobwalker.minecraft.plugins.fatduckplugin.command.CommandHandler;
import uk.co.bobwalker.minecraft.plugins.fatduckplugin.command.FlyCommandHandler;
import uk.co.bobwalker.minecraft.plugins.fatduckplugin.server.ServerProvider;

public class FlyCommandHandlerTest {

    private static String PLAYER_NAME = "TheFatDuck";;
    private static String[] ARGS = { PLAYER_NAME };

    private CommandSender sender;
    private Command command;
    private CommandHandler commandHandler;
    private ServerProvider serverProvider;
    private Logger logger;
    private Server server;
    private Player player;
    private String label;

    @Before
    public void setUp() {
        this.label = "Test Label";
        this.sender = mock(Player.class);
        this.command = mock(Command.class);
        this.serverProvider = mock(ServerProvider.class);
        this.logger = mock(Logger.class);
        this.server = mock(Server.class);
        this.player = mock(Player.class);
        when(serverProvider.getServer()).thenReturn(server);
        when(server.getPlayer(PLAYER_NAME)).thenReturn(player);
        when(command.getName()).thenReturn("fly");
        this.commandHandler = new FlyCommandHandler(serverProvider, logger);
    }

    @Test
    public void testHandleFlyCommand_NotFlyingNotAllowedToFly() {
        // Given
        when(player.isFlying()).thenReturn(false);
        when(player.getAllowFlight()).thenReturn(false);

        // When
        boolean result = commandHandler.handleCommand(player, command, label, ARGS);

        // Then
        assertTrue(result);
        verify(player).setFlying(true);
        verify(player).setAllowFlight(true);

    }

    @Test
    public void testHandleFlyCommand_NotFlyingAllowedToFly() {
        when(player.isFlying()).thenReturn(false);
        when(player.getAllowFlight()).thenReturn(true);

        // When
        boolean result = commandHandler.handleCommand(player, command, label, ARGS);

        // Then
        assertTrue(result);
        verify(player).setFlying(true);
        verify(player).setAllowFlight(true);
    }
    
    @Test
    public void testHandleFlyCommand_FlyingNotAllowedToFly() {
        when(player.isFlying()).thenReturn(true);
        when(player.getAllowFlight()).thenReturn(false);

        // When
        boolean result = commandHandler.handleCommand(player, command, label, ARGS);

        // Then
        assertTrue(result);
        verify(player).setFlying(false);
        verify(player).setAllowFlight(false);
    }

    @Test
    public void testHandleFlyCommand_FlyingAllowedToFly() {
        // Given
        when(player.isFlying()).thenReturn(true);
        when(player.getAllowFlight()).thenReturn(true);

        // When
        boolean result = commandHandler.handleCommand(player, command, label, ARGS);

        // Then
        assertTrue(result);
        verify(player).setFlying(false);
        verify(player).setAllowFlight(false);
    }
}
