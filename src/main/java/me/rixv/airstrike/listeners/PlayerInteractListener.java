package me.rixv.airstrike.listeners;

import me.rixv.airstrike.ItemLogicManager.ItemLogicManager;
import me.rixv.airstrike.ItemManager.ItemManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;

import java.util.Objects;

public class PlayerInteractListener implements Listener {

    private final Plugin plugin;

    public PlayerInteractListener(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {

        Player player = event.getPlayer();

        int delay = 100;

        if((event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) && Objects.equals(player.getInventory().getItemInMainHand(), ItemManager.airstrikeMarker)) {
            ItemLogicManager.leftClick(event, player, delay, plugin);
        }

        if((event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) && Objects.equals(player.getInventory().getItemInMainHand(), ItemManager.airstrikeMarker)) {
            ItemLogicManager.rightClick(event, player);
        }
    }
}
