package me.noku.luckyballs.recipes.LvL1.standard.Core;

import me.noku.luckyballs.LuckyBalls;
import me.noku.luckyballs.UTils.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class LvL1StandardCore {

    public static void initRecipe() {

        ItemStack result = new ItemBuilder(Material.REDSTONE_LAMP).setDisplayname(ChatColor.BLUE + "Core").setLore(ChatColor.GRAY + "Level 1").addCustomModelData(2).build();

        NamespacedKey key = new NamespacedKey(LuckyBalls.getInstance(), "level_1_standard_core");

        ShapedRecipe recipe = new ShapedRecipe(key, result);

        recipe.shape("*&*", "&%&", "*&*");

        recipe.setIngredient('*', Material.AIR);
        recipe.setIngredient('&', new ItemBuilder(Material.WHEAT_SEEDS).setDisplayname(ChatColor.GRAY + "Raw Seed").addEnchantement(Enchantment.LUCK, 1, true).addItemFlags(ItemFlag.HIDE_ENCHANTS).build());
        recipe.setIngredient('%', new ItemBuilder(Material.REDSTONE_LAMP).setDisplayname(ChatColor.GRAY + "Core Containment Unit").addCustomModelData(1).addEnchantement(Enchantment.LUCK, 1, true).addItemFlags(ItemFlag.HIDE_ENCHANTS).build());

        LuckyBalls.getInstance().getServer().addRecipe(recipe);


    }




}
