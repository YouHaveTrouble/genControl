package eu.endermite.gencontrol;

import net.pl3x.purpur.event.world.StructureGenerateEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class Listeners implements Listener {

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void onStructureGenerate(StructureGenerateEvent event) {
        if (GenControl.getInstance().getGCConfig().disabledStructures.contains(event.getStructureType()))
            event.setCancelled(true);
    }

}
