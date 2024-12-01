import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.World;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.Material;
import org.bukkit.Bukkit;

import java.util.Map;
import java.util.HashMap;


public class ChristmasCardCommandExecutor implements CommandExecutor {

    private final Main plugin;

    // Constructor to associate the executor with the plugin
    public ChristmasCardCommandExecutor(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            World world = player.getWorld();
            int x = player.getLocation().getBlockX();
            int y = player.getLocation().getBlockY();
            int z = player.getLocation().getBlockZ();

            if (args.length > 0) {
                String text = String.join(" ", args).toUpperCase(); // Convert text to uppercase
                generateText(world, x, y, z, text); // Place the text in the world
                player.sendMessage("Text has been written!");
            } else {
                player.sendMessage("Please provide some text to write.");
            }

            return true;
        } else {
            sender.sendMessage("This command can only be run by a player.");
            return false;
        }
    }

    // Define letter-to-block mappings for each letter of the alphabet
    private final Map<Character, boolean[][]> letterMap = new HashMap<>();

    {
        // Define the template for each letter
        letterMap.put('A', new boolean[][]{
                {false, true, false},
                {true, false, true},
                {true, true, true},
                {true, false, true},
                {true, false, true}
        });

        letterMap.put('B', new boolean[][]{
                {true, true, false},
                {true, false, true},
                {true, true, false},
                {true, false, true},
                {true, true, false}
        });

        letterMap.put('C', new boolean[][]{
                {true, true, true},
                {true, false, false},
                {true, false, false},
                {true, false, false},
                {true, true, true}
        });

        letterMap.put('D', new boolean[][]{
                {true, true, false},
                {true, false, true},
                {true, false, true},
                {true, false, true},
                {true, true, false}
        });

        letterMap.put('E', new boolean[][]{
                {true, true, true},
                {true, false, false},
                {true, true, true},
                {true, false, false},
                {true, true, true}
        });

        letterMap.put('F', new boolean[][]{
                {true, true, true},
                {true, false, false},
                {true, true, true},
                {true, false, false},
                {true, false, false}
        });

        letterMap.put('G', new boolean[][]{
                {true, true, true},
                {true, false, false},
                {true, false, true},
                {true, false, true},
                {true, true, true}
        });

        letterMap.put('H', new boolean[][]{
                {true, false, true},
                {true, false, true},
                {true, true, true},
                {true, false, true},
                {true, false, true}
        });

        letterMap.put('I', new boolean[][]{
                {true, true, true},
                {false, true, false},
                {false, true, false},
                {false, true, false},
                {true, true, true}
        });

        letterMap.put('J', new boolean[][]{
                {true, true, true},
                {false, true, false},
                {false, true, false},
                {true, false, true},
                {true, true, true}
        });

        letterMap.put('K', new boolean[][]{
                {true, false, true},
                {true, true, false},
                {true, true, false},
                {true, false, true},
                {true, false, false}
        });

        letterMap.put('L', new boolean[][]{
                {true, false, false},
                {true, false, false},
                {true, false, false},
                {true, false, false},
                {true, true, true}
        });

        letterMap.put('M', new boolean[][]{
                {true, false, true},
                {true, true, true},
                {true, false, true},
                {true, false, true},
                {true, false, true}
        });

        letterMap.put('N', new boolean[][]{
                {true, false, true},
                {true, true, true},
                {true, false, true},
                {true, false, true},
                {true, false, true}
        });

        letterMap.put('O', new boolean[][]{
                {false, true, false},
                {true, false, true},
                {true, false, true},
                {true, false, true},
                {false, true, false}
        });

        letterMap.put('P', new boolean[][]{
                {true, true, false},
                {true, false, true},
                {true, true, false},
                {true, false, false},
                {true, false, false}
        });

        letterMap.put('Q', new boolean[][]{
                {false, true, false},
                {true, false, true},
                {true, false, true},
                {true, true, true},
                {false, true, true}
        });

        letterMap.put('R', new boolean[][]{
                {true, true, false},
                {true, false, true},
                {true, true, false},
                {true, false, true},
                {true, false, false}
        });

        letterMap.put('S', new boolean[][]{
                {true, true, true},
                {true, false, false},
                {true, true, true},
                {false, false, true},
                {true, true, true}
        });

        letterMap.put('T', new boolean[][]{
                {true, true, true},
                {false, true, false},
                {false, true, false},
                {false, true, false},
                {false, true, false}
        });

        letterMap.put('U', new boolean[][]{
                {true, false, true},
                {true, false, true},
                {true, false, true},
                {true, false, true},
                {false, true, false}
        });

        letterMap.put('V', new boolean[][]{
                {true, false, true},
                {true, false, true},
                {true, false, true},
                {false, true, false},
                {false, true, false}
        });

        letterMap.put('W', new boolean[][]{
                {true, false, true},
                {true, false, true},
                {true, true, true},
                {true, true, true},
                {true, false, true}
        });

        letterMap.put('X', new boolean[][]{
                {true, false, true},
                {true, true, false},
                {false, true, true},
                {true, true, false},
                {true, false, true}
        });

        letterMap.put('Y', new boolean[][]{
                {true, false, true},
                {true, true, false},
                {false, true, true},
                {false, true, true},
                {false, true, true}
        });

        letterMap.put('Z', new boolean[][]{
                {true, true, true},
                {false, false, true},
                {false, true, false},
                {true, false, false},
                {true, true, true}
        });

        // Add more letters here...
    }
    // Method to write the text using block templates
    private void generateText(World world, int x, int y, int z, String text) {
        int offsetX = x;
        for (char c : text.toCharArray()) {
            boolean[][] letter = letterMap.get(c);
            if (letter != null) {
                placeLetter(world, offsetX, y, z, letter);
                offsetX += letter[0].length + 1; // Move x for the next letter
            }
        }
    }

    // Place blocks for each letter
    private void placeLetter(World world, int x, int y, int z, boolean[][] letter) {
        for (int row = 0; row < letter.length; row++) {
            for (int col = 0; col < letter[row].length; col++) {
                if (letter[row][col]) {
                    world.getBlockAt(x + col, y - row, z).setType(Material.RED_WOOL);
                }
            }
        }
    }
}
