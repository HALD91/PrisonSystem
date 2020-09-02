package me.hald91.main.command;

import me.hald91.main.Main;
import me.hald91.main.items.itemstack;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class commandlist extends itemstack implements CommandExecutor {
    Main main = JavaPlugin.getPlugin(Main.class);
    String test = ChatColor.translateAlternateColorCodes('&', String.valueOf(main.config.getString("SystemPrefix")));

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if ((sender instanceof Player)) {
            Player p = (Player) sender;
            if (command.getName().equalsIgnoreCase("prison")) {
                if (p.hasPermission("prison.vagt.use")) {
                    if (p instanceof ConsoleCommandSender) {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("SystemPrefix").toString() + " " + ChatColor.RED + "This command can't be used in the console"));
                        return true;
                    }
                    if (args.length == 0) {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("SystemPrefix").toString() + " " + "To see how to use this command use /prison help"));
                        return true;
                    }
                    if (args.length == 1) {
                        if (args[0].equalsIgnoreCase("Help")) {
                            p.sendMessage(ChatColor.YELLOW + "-------------------- " + ChatColor.DARK_AQUA + "Prison" + ChatColor.GRAY + " - " + ChatColor.GREEN + "Help " + ChatColor.YELLOW + "--------------------");
                            p.sendMessage(" ");
                            p.sendMessage( ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("SystemPrefix").toString() + " " + ChatColor.YELLOW + "To use this command use:"));
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("SystemPrefix").toString() + " " + ChatColor.GREEN + "/Prison Help Guard" + ChatColor.GRAY + " - " + "To see the command list for " + ChatColor.DARK_AQUA + "Prison " + ChatColor.DARK_PURPLE + "Guard"));
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("SystemPrefix").toString() + " " + ChatColor.GREEN + "/Prison Reload" + ChatColor.GRAY + " - " + "To reload the " + ChatColor.DARK_AQUA + "Prison " + ChatColor.DARK_AQUA + "Config"));
                            p.sendMessage(" ");
                            p.sendMessage(ChatColor.YELLOW + "-----------------------------------------------------");

                            return true;
                        }

                        if (args[0].equalsIgnoreCase("Guard")) {
                            p.sendMessage("Prison Guard help commands:");
                            p.sendMessage(main.GuardPrefix + " " + ChatColor.GREEN + "/Prison Guard GuardStick" + ChatColor.GRAY + " - " + ChatColor.YELLOW + "to get the Guard Stick");
                            p.sendMessage(main.GuardPrefix + " " + ChatColor.GREEN + "/Prison Guard Effects" + ChatColor.GRAY + " - " + ChatColor.YELLOW + "to get the Guard Effects");
                        }
                        if (args[0].equalsIgnoreCase("Reload")) {
                            main.reloadConfig();
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("SystemPrefix").toString() + " " + ChatColor.GREEN + "The config has been reload."));
                        }
                    }
                    if (args.length == 2) {
                        if (args[0].equalsIgnoreCase("Guard")) {
                            if (args[1].equalsIgnoreCase("GuardStick")) {
                                p.sendMessage(main.GuardPrefix + " " + ChatColor.YELLOW + "You have been giving a " + ChatColor.DARK_AQUA + "Guard " + ChatColor.GOLD + "Stick.");
                                p.getInventory().addItem(new ItemStack[]{StickVagt()});
                                p.updateInventory();
                                return true;
                            }
                            else if (args[1].equalsIgnoreCase("Effects")) {
                                p.sendMessage(main.GuardPrefix + " " + ChatColor.YELLOW + "You have been giving your " + ChatColor.DARK_AQUA + "Guard " + ChatColor.RED + "Effects");
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
                }else {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("SystemPrefix").toString() + ChatColor.RED + "It seems like you don't have permission to use this command."));
                }
            }
        }
        return true;
    }
}
