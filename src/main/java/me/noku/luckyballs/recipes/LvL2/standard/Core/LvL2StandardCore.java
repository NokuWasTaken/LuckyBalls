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

    private static final ItemStack ITEMSTACK = new ItemBuilder(Material.REDSTONE_LAMP).setDisplayname(ChatColor.GREEN + "Core").setLore("Level 2").addCustomModelData(3).build();

    private static final NamespacedKey KEY = new NamespacedKey(LuckyBalls.getInstance(), "level_1_standard_core");

    public void initRecipe() {
        //creates new shaped recipe with KEY as NameSpacedKey and ITEMSTACK as result
        ShapedRecipe recipe = new ShapedRecipe(KEY, ITEMSTACK);

        //ads the NameSpacedKey to the Meta of the ItemStack
        ItemMeta meta = ITEMSTACK.getItemMeta();
        PersistentDataContainer persistentDataContainer = meta.getPersistentDataContainer();
        persistentDataContainer.set(KEY, PersistentDataType.BYTE, (byte) 1);
        ITEMSTACK.setItemMeta(meta);

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
