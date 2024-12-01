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

    private void createText(World world, String text, Location startLocation) {
        int xOffset = 0;

        for (char c : text.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                createLetter(world, c, startLocation.clone().add(xOffset, 0, 0));
                xOffset += 6; // Space between letters
            }
        }
    }

    private void createLetter(World world, char letter, Location loc) {
        String[] pattern = getLetterPattern(letter);
        for (int y = 0; y < pattern.length; y++) {
            for (int x = 0; x < pattern[y].length(); x++) {
                if (pattern[y].charAt(x) == 'X') {
                    Block block = world.getBlockAt(loc.clone().add(x, -y, 0));
                    block.setType(Material.STONE);
                }
            }
        }
    }

    private String[] getLetterPattern(char letter) {
        switch (letter) {
            case 'H':
                return new String[]{
                        "X   X",
                        "X   X",
                        "XXXXX",
                        "X   X",
                        "X   X"
                };
            case 'E':
                return new String[]{
                        "XXXXX",
                        "X    ",
                        "XXXXX",
                        "X    ",
                        "XXXXX"
                };
            case 'L':
                return new String[]{
                        "X    ",
                        "X    ",
                        "X    ",
                        "X    ",
                        "XXXXX"
                };
            case 'O':
                return new String[]{
                        "XXXXX",
                        "X   X",
                        "X   X",
                        "X   X",
                        "XXXXX"
                };
            default:
                return new String[]{};
        }
    }
}
