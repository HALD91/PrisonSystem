import Commands.VagtCommands;
import Items.listener;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {


    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new listener(), this);
        getCommand("prison").setExecutor(new VagtCommands());
        super.onEnable();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
