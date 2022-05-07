package me.noku.luckyballs;

import me.noku.luckyballs.Constants.TextConstants;
import me.noku.luckyballs.Events.IronLoadEvent;
import me.noku.luckyballs.UTils.UTils;
import me.noku.luckyballs.recipes.CoreContainer;
import me.noku.luckyballs.recipes.LvL1.standard.Core.LvL1StandardCore;
import me.noku.luckyballs.recipes.LvL1.standard.Core.ingredients.RawSeed;
import me.noku.luckyballs.recipes.LvL1.standard.LvL1StandardLuckyBall;
import me.noku.luckyballs.recipes.LvL2.standard.Core.LvL2StandardCore;
import me.noku.luckyballs.recipes.LvL2.standard.Core.ingredients.UnloadedIron;
import me.noku.luckyballs.recipes.LvL2.standard.Ingredients.CompressedLapisLazuli;
import me.noku.luckyballs.recipes.LvL2.standard.Ingredients.CompressedRedstone;
import me.noku.luckyballs.recipes.LvL2.standard.LvL2StandardLuckyBall;
import org.bukkit.plugin.java.JavaPlugin;


public final class LuckyBalls extends JavaPlugin {
    private static LuckyBalls instance;
    private UTils utils;
    
    
    @Override
    public void onEnable() {
    load();

    }

    @Override
    public void onDisable() {
    }

    void load() {
        //registers instances
        instance = this;
        utils = new UTils();
        utils.log(TextConstants.DEBUG_PREFIX() + "instances registered");

        //registers listeners
        listenerRegistry();
        utils.log(TextConstants.DEBUG_PREFIX() + "listeners registered");

        //registers recipes
        recipeRegistry();
        utils.log(TextConstants.DEBUG_PREFIX() + "recipes registered");

        //displays some fancy ASCII Art
        utils.log("  _                _          ____        _ _     \n" +
                       " | |              | |        |  _ \\      | | |    \n" +
                       " | |    _   _  ___| | ___   _| |_) | __ _| | |___ \n" +
                       " | |   | | | |/ __| |/ / | | |  _ < / _` | | / __|\n" +
                       " | |___| |_| | (__|   <| |_| | |_) | (_| | | \\__ \\\n" +
                       " |______\\__,_|\\___|_|\\_\\\\__, |____/ \\__,_|_|_|___/\n" +
                       "                         __/ |                   By Noku \n" +
                       "                        |___/                     ");
    }
    
    void listenerRegistry() {
        utils.event(new IronLoadEvent(), this);
    }
    
    void recipeRegistry() {
        //General Purpose recipes
        CoreContainer.initRecipe();

        //Lvl 1 recipes
         //LvL1 Core recipes
        RawSeed.initRecipe();
        LvL1StandardCore.initRecipe();
         //LvL 1 Lucky Ball recipes
        LvL1StandardLuckyBall.initRecipe();

        //LvL 2 recipes
         //LvL 2 Core recipes
        UnloadedIron.initRecipe();
        LvL2StandardCore.initRecipe();
         //LvL 2 Lucky Ball recipes
        CompressedRedstone.initRecipe();
        CompressedLapisLazuli.initRecipe();
        LvL2StandardLuckyBall.initRecipe();
        
    }

    public static LuckyBalls getInstance() {
        return instance;
    }
    public UTils getUtils() {
        return utils;
    }
}
