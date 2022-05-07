package me.noku.luckyballs.recipes.LvL1.standard;

import me.noku.luckyballs.LuckyBalls;
import me.noku.luckyballs.UTils.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class LvL1StandardLuckyBall {

    public static void initRecipe() {

        ItemStack result = new ItemBuilder(Material.NOTE_BLOCK).setDisplayname(ChatColor.BLUE + "Lucky Ball").setLore(ChatColor.GRAY + "Level 1").addCustomModelData(1).build();

        NamespacedKey key = new NamespacedKey(LuckyBalls.getInstance(), "level_1_standard_lucky_ball");

        ShapedRecipe recipe = new ShapedRecipe(key, result);

        recipe.shape("%&%", "&§&","%&%");

        recipe.setIngredient('%', Material.COAL);
        recipe.setIngredient('&', Material.OAK_LOG);
        recipe.setIngredient('§', new ItemBuilder(Material.REDSTONE_LAMP).setDisplayname(ChatColor.BLUE + "Core").setLore(ChatColor.GRAY + "Level 1").addCustomModelData(2).build());

        LuckyBalls.getInstance().getServer().addRecipe(recipe);

    }
}
