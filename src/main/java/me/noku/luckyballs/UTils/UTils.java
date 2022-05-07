package me.noku.luckyballs.UTils;

import me.noku.luckyballs.LuckyBalls;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class UTils {

    public void command (String command, CommandExecutor executor) {
        LuckyBalls.getInstance().getCommand(command).setExecutor(executor);
    }

    public void event (Listener listener, Plugin plugin) {
        Bukkit.getPluginManager().registerEvents(listener, plugin);
    }

    public void log (String msg) {
        Bukkit.getConsoleSender().sendMessage(msg);
    }

    public void broadcast (String msg) {
        Bukkit.broadcastMessage(msg);
    }

    public void sendTitle (String title, String subtitle, int fadein, int stay, int fadeout) {
        for (Player allPlayer : Bukkit.getOnlinePlayers()) {
            allPlayer.sendTitle(title, subtitle, fadein, stay, fadeout);
        }
    }



}
