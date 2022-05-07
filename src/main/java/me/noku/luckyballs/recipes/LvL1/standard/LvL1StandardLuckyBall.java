package me.noku.luckyballs.recipes.LvL1.standard;

import me.noku.luckyballs.LuckyBalls;
import me.noku.luckyballs.UTils.ItemBuilder;
import me.noku.luckyballs.recipes.LvL1.standard.Core.LvL1StandardCore;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class LvL1StandardLuckyBall {

    private static final NamespacedKey KEY = new NamespacedKey(LuckyBalls.getInstance(), "level_1_standard_lucky_ball");

    private static final ItemStack ITEMSTACK = new ItemBuilder(Material.NOTE_BLOCK).setDisplayname(ChatColor.BLUE + "Lucky Ball").setLore(ChatColor.GRAY + "Level 1").addCustomModelData(1).addNameSpacedKey(KEY).build();

    public static void initRecipe() {
        //creates a shaped recipe with KEY as NameSpacedKey and ITEMSTACK as result
        ShapedRecipe recipe = new ShapedRecipe(KEY, ITEMSTACK);


        //defines the shape of the recipe
        recipe.shape("%&%",
                     "&§&",
                     "%&%" );

        //defines the ingredients
        recipe.setIngredient('%', Material.COAL);
        recipe.setIngredient('&', Material.OAK_LOG);
        recipe.setIngredient('§', LvL1StandardCore.getItemstack());

        //registers the recipe
        LuckyBalls.getInstance().getServer().addRecipe(recipe);

    }

    //return ITEMSTACK
    public static ItemStack getItemstack() {
        return ITEMSTACK;
    }

    //returns KEY
    public static NamespacedKey getKey() {
        return KEY;
    }
}
