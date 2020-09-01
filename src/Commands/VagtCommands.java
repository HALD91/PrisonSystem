package Commands;

import com.google.common.util.concurrent.Monitor;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class VagtCommands implements CommandExecutor {
    String prefix = "" + ChatColor.GRAY + "[" + ChatColor.DARK_AQUA + "Prison" + ChatColor.GRAY + "-" + ChatColor.GOLD + "System" + ChatColor.GRAY + "]" + ChatColor.RESET + " ";
    String prefix1 = "" + ChatColor.GRAY + "[" + ChatColor.DARK_AQUA + "Prison" + ChatColor.GRAY + "-" + ChatColor.DARK_PURPLE + "Guard" + ChatColor.GRAY + "]" + ChatColor.RESET + " ";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if ((sender instanceof Player)) {
            Player p = (Player) sender;
            if (command.getName().equalsIgnoreCase("prison")) {
                if (p.hasPermission("prison.vagt.use")) {
                    if (p instanceof ConsoleCommandSender) {
                        p.sendMessage(ChatColor.RED + "This command can't be used in the console");
                        return true;
                    }
                    if (args.length == 0) {
                        p.sendMessage(prefix + "To see how to use this command use /prison help");
                        return true;
                    }
                    if (args.length == 1) {
                        if (args[0].equalsIgnoreCase("Help")) {
                            p.sendMessage(ChatColor.YELLOW + "-------------------- " + ChatColor.DARK_AQUA + "Prison" + ChatColor.GRAY + " - " + ChatColor.GREEN + "Help " + ChatColor.YELLOW + "--------------------");
                            p.sendMessage(" ");
                            p.sendMessage(prefix + ChatColor.YELLOW + "To use this command use:");
                            p.sendMessage(prefix + ChatColor.GREEN + "/Prison Help Guard" + ChatColor.GRAY + " - " + "To see the command list for " + ChatColor.DARK_AQUA + "Prison " + ChatColor.DARK_PURPLE + "Guard");
                            p.sendMessage(" ");
                            p.sendMessage(ChatColor.YELLOW + "-----------------------------------------------------");

                            return true;
                        }

                        if (args[0].equalsIgnoreCase("Guard")) {
                            p.sendMessage("Prison Guard help commands:");
                            p.sendMessage(prefix1 + ChatColor.GREEN + "/Prison Guard GuardStick" + ChatColor.GRAY + " - " + ChatColor.YELLOW + "to get the Guard Stick");
                            p.sendMessage(prefix1 + ChatColor.GREEN + "/Prison Guard Effects" + ChatColor.GRAY + " - " + ChatColor.YELLOW + "to get the Guard Effects");
                        }
                    }
                        if (args.length == 2) {
                            if (args[0].equalsIgnoreCase("Guard")) {
                                if (args[1].equalsIgnoreCase("GuardStick")) {
                                    p.sendMessage(prefix1 + ChatColor.YELLOW + "You have been giving a " + ChatColor.DARK_AQUA + "Guard " + ChatColor.GOLD + "Stick.");
                                    p.getInventory().addItem(new ItemStack[]{Stick()});
                                    return true;
                                }
                                else if (args[1].equalsIgnoreCase("Effects")) {
                                    p.sendMessage(prefix1 + ChatColor.YELLOW + "You have been giving your " + ChatColor.DARK_AQUA + "Guard " + ChatColor.RED + "effects");
                                    p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000000, 0));
                                    p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1000000, 1));
                                    p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000000, 1));
                                    return true;
                                }
                            }
                            if (args[0].equalsIgnoreCase("Help")) {
                                if (args[1].equalsIgnoreCase("Guard")) {
                                    p.sendMessage(ChatColor.YELLOW + "------------------ " + ChatColor.DARK_AQUA + "Prison" + " - " + ChatColor.DARK_PURPLE + "Guard " + ChatColor.YELLOW + "Help " + ChatColor.YELLOW + "-----------------");
                                    p.sendMessage(" ");
                                    p.sendMessage(ChatColor.GREEN + "/Prison help Guard" + ChatColor.GRAY + " - " + ChatColor.GRAY + "To see the command list for " + ChatColor.DARK_AQUA + "Prison " + ChatColor.DARK_PURPLE + "Guard");
                                    p.sendMessage(ChatColor.GREEN + "/Prison Guard GuardStick" + ChatColor.GRAY + " - " + ChatColor.GRAY + "to get the " + ChatColor.DARK_PURPLE+ "Guard " + ChatColor.GOLD + "Stick");
                                    p.sendMessage(ChatColor.GREEN + "/Prison Guard Effects" + ChatColor.GRAY + " - " + ChatColor.GRAY + "to get the " + ChatColor.DARK_PURPLE+ "Guard " + ChatColor.GREEN + "Effects");
                                    p.sendMessage(" ");
                                    p.sendMessage(ChatColor.YELLOW + "-----------------------------------------------------");
                                }
                            }
                        }
                }
            }
        }
        return true;
    }

    private ItemStack Stick() {
        ItemStack I = new ItemStack(Material.STICK, 1);
        ItemMeta Im = I.getItemMeta();
        Im.setDisplayName(ChatColor.GOLD + "Guard Stick");
        ArrayList Nau = new ArrayList();
        Nau.add("Soulbound");
        Im.setLore(Nau);
        I.setItemMeta(Im);
        I.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
        return I;
    }

}
