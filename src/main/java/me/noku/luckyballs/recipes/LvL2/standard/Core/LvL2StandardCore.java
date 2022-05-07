package me.noku.luckyballs.recipes.LvL2.standard.Core;

import me.noku.luckyballs.Events.IronLoadEvent;
import me.noku.luckyballs.LuckyBalls;
import me.noku.luckyballs.UTils.ItemBuilder;
import me.noku.luckyballs.recipes.CoreContainer;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class LvL2StandardCore {

    private static final NamespacedKey KEY = new NamespacedKey(LuckyBalls.getInstance(), "level_2_standard_core");

    private static final ItemStack ITEMSTACK = new ItemBuilder(Material.REDSTONE_LAMP).setDisplayname(ChatColor.GREEN + "Core").setLore(ChatColor.GRAY + "Level 2").addCustomModelData(3).addNameSpacedKey(KEY).build();

    public static void initRecipe() {
        //creates new shaped recipe with KEY as NameSpacedKey and ITEMSTACK as result
        ShapedRecipe recipe = new ShapedRecipe(KEY, ITEMSTACK);

        //defines the shape of the recipe
        recipe.shape("*%*", "%&%", "*%*");

        //defines the ingredients of the recipe
        recipe.setIngredient('*', Material.AIR);
        recipe.setIngredient('%', IronLoadEvent.getItemstack());
        recipe.setIngredient('&', CoreContainer.getItemstack());

        //registers recipe
        LuckyBalls.getInstance().getServer().addRecipe(recipe);
    }

    //returns ITEMSTACK
    public static ItemStack getItemstack() {
        return ITEMSTACK;
    }

    //reurns KEY
    public static NamespacedKey getKey() {
        return KEY;
    }
}
