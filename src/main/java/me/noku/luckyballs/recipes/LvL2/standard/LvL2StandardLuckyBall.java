package me.noku.luckyballs.recipes.LvL2.standard;

import me.noku.luckyballs.LuckyBalls;
import me.noku.luckyballs.UTils.ItemBuilder;
import me.noku.luckyballs.recipes.LvL2.standard.Core.LvL2StandardCore;
import me.noku.luckyballs.recipes.LvL2.standard.Ingredients.CompressedLapisLazuli;
import me.noku.luckyballs.recipes.LvL2.standard.Ingredients.CompressedRedstone;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.checkerframework.checker.units.qual.K;

public class LvL2StandardLuckyBall {

    private static final NamespacedKey KEY = new NamespacedKey(LuckyBalls.getInstance(), "level_2_standard_lucky_ball");

    private static final ItemStack ITEMSTACK = new ItemBuilder(Material.NOTE_BLOCK).setDisplayname(ChatColor.GREEN + "Lucky Ball").setLore(ChatColor.GRAY + "Level 2").addCustomModelData(2).addNameSpacedKey(KEY).build();

    public static void initRecipe () {
        //creates new shaped recipe with KEY as NameSpacedKey and ITEMSTACK as ItemStack
        ShapedRecipe recipe = new ShapedRecipe(KEY, ITEMSTACK);

        //defines shape of the recipe
        recipe.shape("&%&",
                     "%§%",
                     "&%&" );

        //defines the ingredients of the recipe
        recipe.setIngredient('§', LvL2StandardCore.getItemstack());
        recipe.setIngredient('%', CompressedLapisLazuli.getItemstack());
        recipe.setIngredient('&', CompressedRedstone.getItemstack());

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
