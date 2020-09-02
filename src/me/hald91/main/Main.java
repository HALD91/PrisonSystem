package me.hald91.main;

import me.hald91.main.command.commandlist;
import me.hald91.main.items.itemstack;
import me.hald91.main.items.listener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Main extends JavaPlugin implements Listener
{

    public FileConfiguration config = getConfig();
    public String SystemPrefix = ChatColor.translateAlternateColorCodes('&', String.valueOf(config.getString("SystemPrefix")));
    public String GuardPrefix = ChatColor.translateAlternateColorCodes('&', String.valueOf(config.getString("GuardPrefix")));

    @Override
    public void onDisable() {

    }

    @Override
    public void onEnable() {
        Logger.getLogger("starter");
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(new listener(), this);
        Bukkit.getPluginManager().registerEvents(new itemstack(), this);
        getCommand("prison").setExecutor(new commandlist());
    }
}
