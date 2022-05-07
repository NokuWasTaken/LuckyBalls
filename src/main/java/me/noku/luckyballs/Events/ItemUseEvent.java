package me.noku.luckyballs.Events;

import me.noku.luckyballs.UTils.ItemBuilder;
import me.noku.luckyballs.recipes.LvL2.standard.Core.ingredients.UnloadedIron;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;

public class ItemUseEvent implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent event) {
        Player player = (Player) event.getPlayer();
        if (player.getInventory().getItemInMainHand().getItemMeta() == null) return;

        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().has(UnloadedIron.getKey())) {
            if (player.getInventory().getItemInMainHand().getAmount() != 1) {
                event.getPlayer().getInventory().getItemInMainHand().setAmount(event.getPlayer().getInventory().getItemInMainHand().getAmount() - 1);
            } else if (player.getInventory().getItemInMainHand().getAmount() == 1) {
                player.getInventory().getItemInMainHand().setAmount(0);
            }

            player.getInventory().addItem(new ItemBuilder(Material.IRON_INGOT).setDisplayname(ChatColor.GREEN + "Loaded Iron").addEnchantement(Enchantment.LUCK, 1, true).addCustomModelData(2).addItemFlags(ItemFlag.HIDE_ENCHANTS).build());

            if (player.getHealth() < 1) {
                player.setHealth(0);
            }else {
                player.setHealth(event.getPlayer().getHealth() - 1);
            }

        }
    }
}
