package me.noku.luckyballs.recipes.LvL1.standard.Core.ingredients;

import me.noku.luckyballs.LuckyBalls;
import me.noku.luckyballs.UTils.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.*;

public class RawSeed {

    public static void initRecipe() {

        ItemStack result = new ItemBuilder(Material.WHEAT_SEEDS).setDisplayname(ChatColor.GRAY + "Raw Seed").addEnchantement(Enchantment.LUCK, 1, true).addItemFlags(ItemFlag.HIDE_ENCHANTS).build();

        NamespacedKey key = new NamespacedKey(LuckyBalls.getInstance(), "raw_seed");

        ShapelessRecipe recipe = new ShapelessRecipe(key, result);

        recipe.addIngredient(4, Material.WHEAT_SEEDS);


        LuckyBalls.getInstance().getServer().addRecipe(recipe);

    }







}
