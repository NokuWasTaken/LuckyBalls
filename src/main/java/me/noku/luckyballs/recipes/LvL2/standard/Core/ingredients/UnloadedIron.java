package me.noku.luckyballs.recipes.LvL2.standard.Core.ingredients;

import me.noku.luckyballs.LuckyBalls;
import me.noku.luckyballs.UTils.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class UnloadedIron {

    private static final NamespacedKey KEY = new NamespacedKey(LuckyBalls.getInstance(), "iron_ingot_unloaded");

    private static final ItemStack ITEMSTACK = new ItemBuilder(Material.IRON_INGOT).setDisplayname(ChatColor.BLUE + "Unloaded Iron").addCustomModelData(1).build();

    public static void initRecipe() {
        //creates new shapeless recipe with KEY as NameSpacedKey and ITEMSTACK as result
        ShapelessRecipe recipe = new ShapelessRecipe(KEY, ITEMSTACK);

        //ads the NameSpacedKey to the Meta of the ItemStack
        ItemMeta meta = ITEMSTACK.getItemMeta();
        PersistentDataContainer persistentDataContainer = meta.getPersistentDataContainer();
        persistentDataContainer.set(KEY, PersistentDataType.BYTE, (byte) 1);
        ITEMSTACK.setItemMeta(meta);

        //defines the ingredients
        recipe.addIngredient(Material.IRON_INGOT);

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
