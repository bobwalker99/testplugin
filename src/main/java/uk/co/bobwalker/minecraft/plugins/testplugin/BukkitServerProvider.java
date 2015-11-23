package uk.co.bobwalker.minecraft.plugins.testplugin;

import org.bukkit.Bukkit;
import org.bukkit.Server;

public class BukkitServerProvider implements ServerProvider {

    @Override
    public Server getServer() {
        return Bukkit.getServer();
    }
}
