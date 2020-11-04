package com.snowgears.spigotplugin;

import com.snowgears.spigotplugin.listener.DefaultListener;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class SpigotPlugin extends JavaPlugin {

    private static SpigotPlugin plugin;

    private DefaultListener defaultListener;

    private boolean useVariable;

    private YamlConfiguration config;

    public static SpigotPlugin getPlugin() {
        return plugin;
    }

    @Override
    //@SuppressWarnings("deprecation")
    public void onEnable() {
        plugin = this;

        File configFile = new File(getDataFolder(), "config.yml");
        if (!configFile.exists()) {
            configFile.getParentFile().mkdirs();
            copy(getResource("config.yml"), configFile);
        }
        config = YamlConfiguration.loadConfiguration(configFile);

        defaultListener = new DefaultListener(this);

        useVariable = config.getBoolean("useVariable");

        getServer().getPluginManager().registerEvents(defaultListener, this);
    }

    @Override
    public void onDisable(){

    }

    public void reload(){
        HandlerList.unregisterAll(defaultListener);

        onEnable();
    }

    public DefaultListener getShopListener() {
        return defaultListener;
    }

    public boolean useVariable() {
        return useVariable;
    }


    private void copy(InputStream in, File file) {
        try {
            OutputStream out = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            out.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}