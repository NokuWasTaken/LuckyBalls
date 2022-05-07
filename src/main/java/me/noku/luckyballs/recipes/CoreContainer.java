package me.noku.luckyballs.recipes;

import me.noku.luckyballs.LuckyBalls;
import me.noku.luckyballs.UTils.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class CoreContainer {

    private static final NamespacedKey KEY = new NamespacedKey(LuckyBalls.getInstance(), "core_container");

    private static final ItemStack ITEMSTACK = new ItemBuilder(Material.REDSTONE_LAMP).setDisplayname(ChatColor.GRAY + "Core Containment Unit").addCustomModelData(1).addEnchantement(Enchantment.LUCK, 1, true).addItemFlags(ItemFlag.HIDE_ENCHANTS).addNameSpacedKey(KEY).build();

    public static void initRecipe() {
        //creates new shaped recipe with KEY as NameSpacedKey and ITEMSTACK as result
        ShapedRecipe recipe = new ShapedRecipe(KEY, ITEMSTACK);

        //defines the shape of the recipe
        recipe.shape("%%%",
                     "%*%",
                     "%%%" );

        //defines the ingredients of the recipe
        recipe.setIngredient('%', Material.IRON_INGOT);
        recipe.setIngredient('*', Material.AIR);

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
