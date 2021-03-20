package eu.endermite.gencontrol;

import org.bukkit.plugin.java.JavaPlugin;

public final class GenControl extends JavaPlugin {

    private static GenControl plugin;
    private GCConfig config;

    @Override
    public void onEnable() {
        plugin = this;
        config = new GCConfig();
        getServer().getPluginManager().registerEvents(new Listeners(), this);
    }

    public static GenControl getInstance() {
        return plugin;
    }

    public GCConfig getGCConfig() {
        return config;
    }
}
