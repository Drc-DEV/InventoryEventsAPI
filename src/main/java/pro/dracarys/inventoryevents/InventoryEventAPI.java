package pro.dracarys.inventoryevents;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import pro.dracarys.inventoryevents.event.PlayerInventoryCloseEvent;
import pro.dracarys.inventoryevents.event.PlayerInventoryOpenEvent;

public class InventoryEventAPI {

    private static InventoryEventAPI instance;

    private JavaPlugin plugin;

    public static InventoryEventAPI getInstance() {
        if (instance == null)
            instance = new InventoryEventAPI();
        return instance;
    }

    private InventoryEventAPI() {
    }

    private ProtocolManager protocolManager;


    public void register(JavaPlugin plugin) {
        this.plugin = plugin;
        protocolManager = ProtocolLibrary.getProtocolManager();

        protocolManager.addPacketListener(
                new PacketAdapter(plugin, ListenerPriority.NORMAL,
                        PacketType.Play.Client.CLOSE_WINDOW) {
                    @Override
                    public void onPacketReceiving(PacketEvent event) {
                        if (event.getPacketType() ==
                                PacketType.Play.Client.CLOSE_WINDOW) {
                            Bukkit.getScheduler().runTask(plugin, () -> Bukkit.getPluginManager().callEvent(new PlayerInventoryCloseEvent(event.getPlayer(), event.getPlayer().getInventory())));
                        }
                    }
                });
        protocolManager.addPacketListener(
                new PacketAdapter(plugin, ListenerPriority.NORMAL,
                        PacketType.Play.Server.OPEN_WINDOW) {
                    @Override
                    public void onPacketSending(PacketEvent event) {
                        if (event.getPacketType() ==
                                PacketType.Play.Server.OPEN_WINDOW) {
                            Bukkit.getScheduler().runTask(plugin, () -> Bukkit.getPluginManager().callEvent(new PlayerInventoryOpenEvent(event.getPlayer(), event.getPlayer().getInventory())));
                        }
                    }
                });
    }

}