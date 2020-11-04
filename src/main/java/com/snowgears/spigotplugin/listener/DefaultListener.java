package com.snowgears.spigotplugin.listener;

import com.snowgears.spigotplugin.SpigotPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryInteractEvent;

import java.util.HashMap;

public class DefaultListener implements Listener {

    private SpigotPlugin plugin = SpigotPlugin.getPlugin();
    private HashMap<String, Integer> shopBuildLimits = new HashMap<String, Integer>();

    public DefaultListener(SpigotPlugin instance) {
        plugin = instance;
    }

    @EventHandler
    public void onPlayerJoin(InventoryInteractEvent event){
       System.out.println("[SpigotPlugin] InventoryInteractEvent fired.");
    }
}