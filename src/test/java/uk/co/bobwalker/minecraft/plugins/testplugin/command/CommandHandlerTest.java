package uk.co.bobwalker.minecraft.plugins.testplugin.command;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

import uk.co.bobwalker.minecraft.plugins.testplugin.command.BurnCommandHandler;
import uk.co.bobwalker.minecraft.plugins.testplugin.command.CommandHandler;
import uk.co.bobwalker.minecraft.plugins.testplugin.server.ServerProvider;

@RunWith(PowerMockRunner.class)
public class CommandHandlerTest {

    @Test
    public void testHandleCommand() {
        // Given
        String playerName = "Coolyo888";
        CommandSender sender = mock(Player.class);
        Command command = mock(Command.class);
        ServerProvider serverProvider = mock(ServerProvider.class);
        Server server = mock(Server.class);
        Player player = mock(Player.class);
        when(serverProvider.getServer()).thenReturn(server);
        when(server.getPlayer(playerName)).thenReturn(player);
        when(command.getName()).thenReturn("burn");
        String label = "Test Label";
        String[] args = { playerName };
        CommandHandler handler = new BurnCommandHandler(serverProvider);

        // When
        boolean result = handler.handleCommand(sender, command, label, args);

        // Then
        assertTrue(result);
    }

}
