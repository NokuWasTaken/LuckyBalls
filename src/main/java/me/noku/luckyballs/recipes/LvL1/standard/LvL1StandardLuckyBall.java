package me.noku.luckyballs.recipes.LvL1.standard;

import me.noku.luckyballs.LuckyBalls;
import me.noku.luckyballs.UTils.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class LvL1StandardLuckyBall {

    private static final ItemStack ITEMSTACK = new ItemBuilder(Material.NOTE_BLOCK).setDisplayname(ChatColor.BLUE + "Lucky Ball").setLore(ChatColor.GRAY + "Level 1").addCustomModelData(1).build();

    private static final NamespacedKey KEY = new NamespacedKey(LuckyBalls.getInstance(), "level_1_standard_lucky_ball");
    public static void initRecipe() {
        //creates a shaped recipe with KEY as NameSpacedKey and ITEMSTACK as result
        ShapedRecipe recipe = new ShapedRecipe(KEY, ITEMSTACK);

        //ads the NameSpacedKey to the Meta of the ItemStack
        ItemMeta meta = ITEMSTACK.getItemMeta();
        PersistentDataContainer persistentDataContainer = meta.getPersistentDataContainer();
        persistentDataContainer.set(KEY, PersistentDataType.BYTE, (byte) 1);
        ITEMSTACK.setItemMeta(meta);

        //defines the shape of the recipe
        recipe.shape("%&%",
                     "&§&",
                     "%&%" );

        //defines the ingredients
        recipe.setIngredient('%', Material.COAL);
        recipe.setIngredient('&', Material.OAK_LOG);
        recipe.setIngredient('§', new ItemBuilder(Material.REDSTONE_LAMP).setDisplayname(ChatColor.BLUE + "Core").setLore(ChatColor.GRAY + "Level 1").addCustomModelData(2).build());

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
