package Items;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import javax.annotation.ParametersAreNonnullByDefault;
import java.awt.*;
import java.util.Objects;

public class listener implements Listener{
    public boolean onItem(ItemStack I, String Displayname, Material ItemType){
        return (I != null) && (I.hasItemMeta()) && (I.getItemMeta().getDisplayName().equalsIgnoreCase(Displayname)) && (I.getType() == ItemType);
    }

    @EventHandler
    @ParametersAreNonnullByDefault
    public void ondrop(PlayerDropItemEvent event){
        Player p = event.getPlayer();
        Item I = event.getItemDrop();
        if (Objects.requireNonNull(I.getItemStack().getItemMeta()).getDisplayName().contains(ChatColor.GOLD + "Guard Stick")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onEntityHit(EntityDamageByEntityEvent e)
    {
        if (((e.getEntity() instanceof Player)) &&((e.getDamager() instanceof Player)))
        {
            if (e.isCancelled()){
                return;
            } else {
                Player P = (Player) e.getEntity();
                Player D = (Player) e.getDamager();
                ItemStack I = D.getItemInHand();
                if (onItem(I, ChatColor.GOLD + "Guard Stick", Material.STICK)){
                    P.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 1));
                    P.getWorld().playEffect(P.getLocation(), Effect.POTION_BREAK, 0);
                    return;
                }
            }
        }
    }
}
