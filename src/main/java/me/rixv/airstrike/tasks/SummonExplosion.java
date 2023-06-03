package me.rixv.airstrike.tasks;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;

public class SummonExplosion extends BukkitRunnable {

    private final Location location;
    private final World world;

    public SummonExplosion(Location location, World world) {
        this.location = location;
        this.world = world;
    }

    @Override
    public void run() {

        this.location.setY(this.world.getHighestBlockYAt((int) this.location.getX(), (int) this.location.getZ()) + 1);
        this.world.createExplosion(this.location, 5, false, false);

    }
}
