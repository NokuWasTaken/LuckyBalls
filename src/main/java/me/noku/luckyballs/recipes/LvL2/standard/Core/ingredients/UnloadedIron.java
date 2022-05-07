package me.noku.luckyballs.recipes.LvL2.standard.Core.ingredients;

import me.noku.luckyballs.LuckyBalls;
import me.noku.luckyballs.UTils.HiddenSTringUTils;
import me.noku.luckyballs.UTils.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.lang.reflect.Field;
import java.util.Random;

public class UnloadedIron {

    private static final NamespacedKey key = new NamespacedKey(LuckyBalls.getInstance(), "unloaded_iron");

    public static void initRecipe() {



        ItemStack result = new ItemBuilder(Material.IRON_INGOT).setDisplayname(ChatColor.BLUE + "Unloaded Iron").addCustomModelData(1).build();



        ItemMeta meta = result.getItemMeta();
        PersistentDataContainer persistentDataContainer = meta.getPersistentDataContainer();
        persistentDataContainer.set(key, PersistentDataType.BYTE, (byte) 1);
        result.setItemMeta(meta);

        ShapelessRecipe recipe = new ShapelessRecipe(key, result);

        recipe.addIngredient(Material.IRON_INGOT);

        LuckyBalls.getInstance().getServer().addRecipe(recipe);

    }

    public static NamespacedKey getKey() {
        return key;
    }


}
