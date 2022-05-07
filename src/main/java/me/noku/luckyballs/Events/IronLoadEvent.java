package me.noku.luckyballs.Events;

import me.noku.luckyballs.LuckyBalls;
import me.noku.luckyballs.UTils.ItemBuilder;
import me.noku.luckyballs.recipes.LvL2.standard.Core.ingredients.UnloadedIron;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class IronLoadEvent implements Listener {

    private static final ItemStack ITEMSTACK = new ItemBuilder(Material.IRON_INGOT).setDisplayname(ChatColor.GREEN + "Loaded Iron").addEnchantement(Enchantment.LUCK, 1, true).addCustomModelData(2).addItemFlags(ItemFlag.HIDE_ENCHANTS).build();

    private static final NamespacedKey KEY = new NamespacedKey(LuckyBalls.getInstance(), "iron_ingot_loaded");

    @EventHandler
    public void onClick(PlayerInteractEvent event) {
        //casts Player
        Player player = (Player) event.getPlayer();

        //checks if the itemmeta of the Item in hand is null
        if (player.getInventory().getItemInMainHand().getItemMeta() == null) return;

        //checks if the Item in the Mainhand has the NameSpacedKey from unloaded Iron in the Meta
        if (!player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().has(UnloadedIron.getKey())) return;

            //checks if the Player has one or more items in the main hand
            if (player.getInventory().getItemInMainHand().getAmount() != 1) {

                player.getInventory().getItemInMainHand().setAmount(event.getPlayer().getInventory().getItemInMainHand().getAmount() - 1);

            } else if (player.getInventory().getItemInMainHand().getAmount() == 1) {

                player.getInventory().getItemInMainHand().setAmount(0);

            }

            //ads the NameSpacedKey to the Meta of the ItemStack
            ItemMeta meta = ITEMSTACK.getItemMeta();
            PersistentDataContainer persistentDataContainer = meta.getPersistentDataContainer();
            persistentDataContainer.set(KEY, PersistentDataType.BYTE, (byte) 1);
            ITEMSTACK.setItemMeta(meta);

            //ads the loaded Iron into the players Inventory
            player.getInventory().addItem(ITEMSTACK);

            //removes 1HP from the Player or kills him if the HP is under 1
            if (player.getHealth() < 1) {

                player.setHealth(0);

            }else {

                player.setHealth(event.getPlayer().getHealth() - 1);

            }

        }

    //returns the ItemStack
    public static ItemStack getItemstack() {
        return ITEMSTACK;
    }
    //returns the NameSpacedKey
    public static NamespacedKey getKey() {
        return KEY;
    }
}
