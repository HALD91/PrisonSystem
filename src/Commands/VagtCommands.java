package Commands;

import com.google.common.util.concurrent.Monitor;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class VagtCommands implements CommandExecutor {
    String prefix = "" + ChatColor.GRAY + "[" + ChatColor.DARK_AQUA + "Prison" + ChatColor.GOLD + "System" + ChatColor.GRAY + "]" + ChatColor.RESET + " ";
    private ItemStack Guard_Stick;


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if ((commandSender instanceof Player)) {
            Player p1 = (Player) commandSender;
            if (command.getName().equalsIgnoreCase("prison")) {
                if (commandSender.hasPermission("prison.vagt.use")) {
                    if (commandSender instanceof ConsoleCommandSender) {
                        commandSender.sendMessage(ChatColor.RED + "This command can't be used in the console");
                    }
                    if (args.length == 0) {
                        commandSender.sendMessage(prefix + "To see how to use this command use /prison");
                    }
                    if (args[0].equalsIgnoreCase("Help")) {
                        commandSender.sendMessage(prefix + ChatColor.YELLOW + "To use this command use:");
                        commandSender.sendMessage(prefix + ChatColor.YELLOW + "/Prison Help");

                        p1.getInventory().addItem(new ItemStack[]{Guard_Stick});
                    }
                    if (args[0].equalsIgnoreCase("GuardStick")) {
                        commandSender.sendMessage(prefix + ChatColor.AQUA + "You have been giving a Guard Stick.");
                        p1.getInventory().addItem(new ItemStack[]{Guard_Stick});
                    }
                }
            }
        }
        return true;
    }
}
