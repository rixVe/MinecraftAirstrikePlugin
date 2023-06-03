package me.rixv.airstrike.ItemLogicManager;

import me.rixv.airstrike.Airstrike;
import me.rixv.airstrike.tasks.SummonExplosion;
import me.rixv.airstrike.tasks.SummonSound;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ItemLogicManager {
    public static void rightClick(PlayerInteractEvent event, Player player){
        event.setCancelled(true);
        if(Airstrike.hasAimed.contains(player)) {
            player.removePotionEffect(PotionEffectType.SLOW);
            Airstrike.hasAimed.remove(player);
        }
        else {
            player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, Integer.MAX_VALUE - 1, false, false, false));
            Airstrike.hasAimed.add(player);
        }
    }

    public static void leftClick(PlayerInteractEvent event, Player player, long delay, Plugin plugin) {
        event.setCancelled(true);
        Location location = Objects.requireNonNull(player.getTargetBlock(120)).getLocation();
        if(location.getBlock().getType() == Material.AIR) return;
        List<Location> tempLocations = new ArrayList<>();
        switch(player.getFacing()) {
            case EAST:
                for (int i = 0; i < 10; i++) {
                    tempLocations.add(new Location(location.getWorld(), location.getX() + i * 3, location.getY(), location.getZ()));
                }
                break;
            case WEST:
                for (int i = 0; i < 10; i++) {
                    tempLocations.add(new Location(location.getWorld(), location.getX() + i * -3, location.getY(), location.getZ()));

                }
                break;
            case NORTH:
                for (int i = 0; i < 10; i++) {
                    tempLocations.add(new Location(location.getWorld(), location.getX(), location.getY(), location.getZ() + i * -3));

                }
                break;
            case SOUTH:
                for (int i = 0; i < 10; i++) {
                    tempLocations.add(new Location(location.getWorld(), location.getX(), location.getY(), location.getZ() + i * 3));

                }
                break;
            default:
                break;
        }
        for(int i = 0; i < 2; i++) {
            for(int j = 0 ; j < 10; j++){
                if(i == 0) {
                    if(j == 0)  new SummonSound(player, location).runTaskLater(plugin, 0);
                    new SummonExplosion(tempLocations.get(j), player.getWorld()).runTaskLater(plugin,  delay + (long) j * 2);
                }
                else {
                    new SummonExplosion(tempLocations.get(j), player.getWorld()).runTaskLater(plugin,   2 * delay + 20 + j * 2);
                }
            }
        }
        player.getInventory().setItemInMainHand(null);
        if(Airstrike.hasAimed.contains(player)) {
            player.removePotionEffect(PotionEffectType.SLOW);
            Airstrike.hasAimed.remove(player);
        }
    }
}
