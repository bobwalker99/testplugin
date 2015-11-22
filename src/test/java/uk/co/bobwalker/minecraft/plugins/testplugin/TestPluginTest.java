package uk.co.bobwalker.minecraft.plugins.testplugin;

import static org.mockito.Mockito.mock;

import java.io.File;

import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.InvalidDescriptionException;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPluginLoader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class TestPluginTest {

    @Test
    public void testPlugin() throws InvalidDescriptionException {
        JavaPluginLoader loader = new JavaPluginLoader(mock(Server.class));
        PluginDescriptionFile description = new PluginDescriptionFile("TestPlugin", "plugin.yml",
                "uk.co.bobwalker.minecraft.plugins.testplugin.TestPlugin");
        File dataFolder = mock(File.class);
        File file = mock(File.class);
        TestPlugin plugin = new TestPlugin(loader, description, dataFolder, file);
        CommandSender sender = mock(CommandSender.class);
        Command command = mock(Command.class);
        String label = "Test Label";
        String[] args = new String[0];
        plugin.onCommand(sender, command, label, args);
    }

}
