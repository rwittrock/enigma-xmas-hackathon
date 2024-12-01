import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.World;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.Material;
import org.bukkit.Bukkit;

import java.util.Arrays;
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
        if (args.length > 1) {
            // Extract the first argument as the target player's name
            String targetPlayerName = args[0];

            // Check if the target player is online
            Player targetPlayer = Bukkit.getPlayer(targetPlayerName);
            if (targetPlayer == null) {
                sender.sendMessage("Player not found or is not online.");
                return false;
            }

            // Get the target player's world and position
            World world = targetPlayer.getWorld();
            int x = targetPlayer.getLocation().getBlockX();
            int y = targetPlayer.getLocation().getBlockY();
            int z = targetPlayer.getLocation().getBlockZ();

            // Join the rest of the arguments to form the text
            String text = String.join(" ", Arrays.copyOfRange(args, 1, args.length)).toUpperCase(); // Convert text to uppercase

            // Generate the text in the world
            generateText(world, x, y, z, text);
            sender.sendMessage("The christmas card has been sent to " + targetPlayerName+"!");

        } else {
            sender.sendMessage("Please provide the player's name and the text to write.");
        }

        return true;
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
                {false, true, true},
                {false, false, true},
                {false, false, true},
                {true, false, true},
                {true, true, true}
        });

        letterMap.put('K', new boolean[][]{
                {true, false, true},
                {true, true, false},
                {true, true, false},
                {true, true, false},
                {true, false, true}
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
                {true, true, true},
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
                {true, false, true}
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
                {true, true, true},
                {false, true, false},
                {true, false, true},
                {true, false, true}
        });

        letterMap.put('Y', new boolean[][]{
                {true, false, true},
                {true, false, true},
                {false, true, false},
                {false, true, false},
                {false, true, false}
        });

        letterMap.put('Z', new boolean[][]{
                {true, true, true},
                {false, false, true},
                {false, true, false},
                {true, false, false},
                {true, true, true}
        });

        letterMap.put(' ', new boolean[][]{
                {false, false, false},
                {false, false, false},
                {false, false, false},
                {false, false, false},
                {false, false, false}
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
