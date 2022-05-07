package me.noku.luckyballs;

import me.noku.luckyballs.Constants.TextConstants;
import me.noku.luckyballs.Events.ItemUseEvent;
import me.noku.luckyballs.UTils.UTils;
import me.noku.luckyballs.recipes.CoreContainer;
import me.noku.luckyballs.recipes.LvL1.standard.Core.LvL1StandardCore;
import me.noku.luckyballs.recipes.LvL1.standard.Core.ingredients.RawSeed;
import me.noku.luckyballs.recipes.LvL1.standard.LvL1StandardLuckyBall;
import me.noku.luckyballs.recipes.LvL2.standard.Core.ingredients.UnloadedIron;
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
        instance = this;
        utils = new UTils();
        utils.log(TextConstants.DEBUG_PREFIX() + "instances registered");
        
        commandRegistry();
        utils.log(TextConstants.DEBUG_PREFIX() + "commands registered");
        
        listenerRegistry();
        utils.log(TextConstants.DEBUG_PREFIX() + "listener registered");

        recipeRegistry();
        utils.log(TextConstants.DEBUG_PREFIX() + "recipes registered");

        utils.log("  _                _          ____        _ _     \n" +
                       " | |              | |        |  _ \\      | | |    \n" +
                       " | |    _   _  ___| | ___   _| |_) | __ _| | |___ \n" +
                       " | |   | | | |/ __| |/ / | | |  _ < / _` | | / __|\n" +
                       " | |___| |_| | (__|   <| |_| | |_) | (_| | | \\__ \\\n" +
                       " |______\\__,_|\\___|_|\\_\\\\__, |____/ \\__,_|_|_|___/\n" +
                       "                         __/ |                   By Noku \n" +
                       "                        |___/                     ");
    }
    
    void commandRegistry() {
        
    }
    
    void listenerRegistry() {
        utils.event(new ItemUseEvent(), this);
    }
    
    void recipeRegistry() {
        CoreContainer.initRecipe();

        RawSeed.initRecipe();
        LvL1StandardCore.initRecipe();
        LvL1StandardLuckyBall.initRecipe();

        UnloadedIron.initRecipe();
        
    }

    public static LuckyBalls getInstance() {
        return instance;
    }
    public UTils getUtils() {
        return utils;
    }
}
