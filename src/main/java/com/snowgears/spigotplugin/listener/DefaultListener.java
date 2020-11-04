package com.snowgears.spigotplugin.listener;

import com.snowgears.spigotplugin.SpigotPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class DefaultListener implements Listener {

    private SpigotPlugin plugin = SpigotPlugin.getPlugin();

    public DefaultListener(SpigotPlugin instance) {
        plugin = instance;
    }

    @EventHandler
    public void onPlayerJoin(InventoryClickEvent event){
       System.out.println("[SpigotPlugin] InventoryInteractEvent fired.");
    }
}