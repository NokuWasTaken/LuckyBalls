package me.noku.luckyballs.recipes.LvL1.standard.Core.ingredients;

import me.noku.luckyballs.LuckyBalls;
import me.noku.luckyballs.UTils.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.*;

public class RawSeed {

    private static final NamespacedKey KEY = new NamespacedKey(LuckyBalls.getInstance(), "raw_seed");

    private static final ItemStack ITEMSTACK = new ItemBuilder(Material.WHEAT_SEEDS).setDisplayname(ChatColor.GRAY + "Raw Seed").addEnchantement(Enchantment.LUCK, 1, true).addItemFlags(ItemFlag.HIDE_ENCHANTS).addNameSpacedKey(KEY).build();

    public static void initRecipe() {
        //creates a shapeless recipe with KEY as NameSpacedKey and ITEMSTACK as result
        ShapelessRecipe recipe = new ShapelessRecipe(KEY, ITEMSTACK);

        //ads 4 seeds as Ingedrients
        recipe.addIngredient(4, Material.WHEAT_SEEDS);

        //registers recipe
        LuckyBalls.getInstance().getServer().addRecipe(recipe);

    }

    //returns ITEMSTACK
    public static ItemStack getItemstack() {
        return ITEMSTACK;
    }

    //return KEY
    public static NamespacedKey getKey() {
        return KEY;
    }






}
