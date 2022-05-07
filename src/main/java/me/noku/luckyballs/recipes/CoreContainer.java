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

public class CoreContainer {

    public static void initRecipe() {

        ItemStack result = new ItemBuilder(Material.REDSTONE_LAMP).setDisplayname(ChatColor.GRAY + "Core Containment Unit").addCustomModelData(1).addEnchantement(Enchantment.LUCK, 1, true).addItemFlags(ItemFlag.HIDE_ENCHANTS).build();

        NamespacedKey key = new NamespacedKey(LuckyBalls.getInstance(), "core_container");

        ShapedRecipe recipe = new ShapedRecipe(key, result);

        recipe.shape("%%%", "%*%", "%%%");

        recipe.setIngredient('%', Material.IRON_INGOT);
        recipe.setIngredient('*', Material.AIR);

        LuckyBalls.getInstance().getServer().addRecipe(recipe);
    }


}
