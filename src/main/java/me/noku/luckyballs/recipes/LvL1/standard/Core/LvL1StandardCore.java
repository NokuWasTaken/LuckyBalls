package me.noku.luckyballs.recipes.LvL1.standard.Core;

import me.noku.luckyballs.LuckyBalls;
import me.noku.luckyballs.UTils.ItemBuilder;
import me.noku.luckyballs.recipes.CoreContainer;
import me.noku.luckyballs.recipes.LvL1.standard.Core.ingredients.RawSeed;
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

    private static final NamespacedKey KEY = new NamespacedKey(LuckyBalls.getInstance(), "level_1_standard_core");

    private static final ItemStack ITEMSTACK = new ItemBuilder(Material.REDSTONE_LAMP).setDisplayname(ChatColor.BLUE + "Core").setLore(ChatColor.GRAY + "Level 1").addCustomModelData(2).addNameSpacedKey(KEY).build();

    public static void initRecipe() {
        //creates a shapeless recipe with key as NameSpacedKey and ITEMSTACK as result
        ShapedRecipe recipe = new ShapedRecipe(KEY, ITEMSTACK);

        //defines the shape of the recipe
        recipe.shape("*&*",
                     "&%&",
                     "*&*");

        //defines the ingredients
        recipe.setIngredient('*', Material.AIR);
        recipe.setIngredient('&', RawSeed.getItemstack());
        recipe.setIngredient('%', CoreContainer.getItemstack());

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
