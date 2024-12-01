import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Location;
import org.bukkit.block.Block;


public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        // Register the command executor
        getCommand("christmascard").setExecutor(new ChristmasCardCommandExecutor(this));

        // Log to console that the plugin is enabled
        getLogger().info("ChristmasCardPlugin has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("ChristmasCardPlugin has been disabled!");
    }
}
