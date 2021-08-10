package eu.endermite.gencontrol;

import org.bukkit.StructureType;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import java.util.HashSet;
import java.util.Map;

public class GCConfig {

    GenControl plugin = GenControl.getInstance();
    HashSet<StructureType> disabledStructures = new HashSet<>();

    public GCConfig() {
        generateDefaultConfig();
        ConfigurationSection disabled_structures = plugin.getConfig().getConfigurationSection("disabled-structures");
        for (String key : disabled_structures.getKeys(false)) {
            StructureType structureType = StructureType.getStructureTypes().get(key);
            if (structureType == null) continue;
            if (disabled_structures.getBoolean(key))
                disabledStructures.add(structureType);
        }
    }

    private void generateDefaultConfig() {
        FileConfiguration config = plugin.getConfig();
        for (Map.Entry<String, StructureType> structure : StructureType.getStructureTypes().entrySet()) {
            String path = "disabled-structures."+structure.getKey();
            if (config.getString(path) == null)
                config.set(path, false);
        }
        plugin.saveConfig();
        plugin.reloadConfig();
    }

}
