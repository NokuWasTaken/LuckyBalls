package me.noku.luckyballs.recipes.LvL1.standard.Core;

import me.noku.luckyballs.LuckyBalls;
import me.noku.luckyballs.UTils.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Keyed;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class LvL1StandardCore {

    private static final ItemStack ITEMSTACK = new ItemBuilder(Material.REDSTONE_LAMP).setDisplayname(ChatColor.BLUE + "Core").setLore(ChatColor.GRAY + "Level 1").addCustomModelData(2).build();

    private static final NamespacedKey KEY = new NamespacedKey(LuckyBalls.getInstance(), "level_1_standard_core");

    public static void initRecipe() {
        //creates a shapeless recipe with key as NameSpacedKey and ITEMSTACK as result
        ShapedRecipe recipe = new ShapedRecipe(KEY, ITEMSTACK);

        //ads the NameSpacedKey to the Meta of the ItemStack
        ItemMeta meta = ITEMSTACK.getItemMeta();
        PersistentDataContainer persistentDataContainer = meta.getPersistentDataContainer();
        persistentDataContainer.set(KEY, PersistentDataType.BYTE, (byte) 1);
        ITEMSTACK.setItemMeta(meta);

        //defines the shape of the recipe
        recipe.shape("*&*",
                     "&%&",
                     "*&*");

        //defines the ingredients
        recipe.setIngredient('*', Material.AIR);
        recipe.setIngredient('&', new ItemBuilder(Material.WHEAT_SEEDS).setDisplayname(ChatColor.GRAY + "Raw Seed").addEnchantement(Enchantment.LUCK, 1, true).addItemFlags(ItemFlag.HIDE_ENCHANTS).build());
        recipe.setIngredient('%', new ItemBuilder(Material.REDSTONE_LAMP).setDisplayname(ChatColor.GRAY + "Core Containment Unit").addCustomModelData(1).addEnchantement(Enchantment.LUCK, 1, true).addItemFlags(ItemFlag.HIDE_ENCHANTS).build());

        //registers recipe
        LuckyBalls.getInstance().getServer().addRecipe(recipe);
    }

    //returns ITEMSTACK
    public static ItemStack getItemstack() {
        return ITEMSTACK;
    }

    //returns KEY
    public static NamespacedKey getKey() {
        return KEY;
    }


}
