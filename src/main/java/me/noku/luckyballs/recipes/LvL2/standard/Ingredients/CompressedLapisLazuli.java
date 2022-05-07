package me.noku.luckyballs.recipes.LvL2.standard.Ingredients;

import me.noku.luckyballs.LuckyBalls;
import me.noku.luckyballs.UTils.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;

public class CompressedLapisLazuli {

    private static final NamespacedKey KEY = new NamespacedKey(LuckyBalls.getInstance(), "lapis_lazuli_compressed");

    private static final ItemStack ITEMSTACK = new ItemBuilder(Material.LAPIS_LAZULI).setDisplayname(ChatColor.GRAY + "Compressed Lapis Lazuli").addEnchantement(Enchantment.LURE,1,true).addItemFlags(ItemFlag.HIDE_ENCHANTS).addNameSpacedKey(KEY).addCustomModelData(1).build();

    public static void initRecipe() {
        //creates a shapeless recipe with KEY as NameSpacedKey and ITEMSTACK as result
        ShapelessRecipe recipe = new ShapelessRecipe(KEY,ITEMSTACK);

        //defines ingredients of the recipe
        recipe.addIngredient(4, Material.LAPIS_LAZULI);

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
