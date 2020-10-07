package pro.dracarys.inventoryevents.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.Inventory;

public class PlayerInventoryEvent extends Event {

    private final Player player;

    private final Inventory inventory;

    private static final HandlerList handlerList = new HandlerList();

    public PlayerInventoryEvent(Player player, Inventory inventory) {
        this.player = player;
        this.inventory = inventory;
    }

    public Player getPlayer() {
        return player;
    }

    public Inventory getInventory() {
        return inventory;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }
}
