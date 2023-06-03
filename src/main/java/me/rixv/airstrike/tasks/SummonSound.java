package me.rixv.airstrike.tasks;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class SummonSound extends BukkitRunnable {

    Player player;
    Location location;
    World world;

    public SummonSound(Player player, Location location) {
        this.player = player;
        this.location = location;
        this.world = player.getWorld();
    }

    @Override
    public void run() {
        this.location.setY(this.world.getHighestBlockYAt((int) this.location.getX(), (int) this.location.getZ()) + 1);
        player.getWorld().playSound(this.location, Sound.ENTITY_AXOLOTL_DEATH, 10, 1);
    }
}
