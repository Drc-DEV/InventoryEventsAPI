package pro.dracarys.inventoryevents.event;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

/**
 * Fired when a player opens any inventory.
 */
public class PlayerInventoryOpenEvent extends PlayerInventoryEvent {
    public PlayerInventoryOpenEvent(Player player, Inventory inventory) {
        super(player, inventory);
    }
}