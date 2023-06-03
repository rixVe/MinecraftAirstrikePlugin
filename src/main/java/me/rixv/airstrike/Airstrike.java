package me.rixv.airstrike;

import me.rixv.airstrike.ItemManager.ItemManager;
import me.rixv.airstrike.command.AirstrikeCommand;
import me.rixv.airstrike.listeners.PlayerInteractListener;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Airstrike extends JavaPlugin {

    public static List<Player> hasAimed = new ArrayList<>();

    @Override
    public void onEnable() {
        Objects.requireNonNull(getCommand("airstrike")).setExecutor(new AirstrikeCommand());

        ItemManager.init();

        getServer().getPluginManager().registerEvents(new PlayerInteractListener(this), this);
    }

}
