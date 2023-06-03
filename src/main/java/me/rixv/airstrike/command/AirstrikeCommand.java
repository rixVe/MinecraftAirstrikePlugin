package me.rixv.airstrike.command;

import me.rixv.airstrike.ItemManager.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class AirstrikeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "You have to be a player to use this command");
            return true;
        }
        Player player = (Player) sender;
        player.sendMessage(ChatColor.GREEN + "Airstrike");
        player.getInventory().addItem(ItemManager.airstrikeMarker);
        return true;
    }
}
