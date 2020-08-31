package Items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class itemstack implements Listener {
    public ItemStack Guard_Stick() {
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
