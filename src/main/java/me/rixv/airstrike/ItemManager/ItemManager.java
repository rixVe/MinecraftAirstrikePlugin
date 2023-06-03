package me.rixv.airstrike.ItemManager;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {
    public static ItemStack airstrikeMarker;

    public static void init() {
        CreateAirstrikeMarker();
    }

    private static void CreateAirstrikeMarker() {

        ItemStack item = new ItemStack(Material.END_STONE_BRICK_WALL, 1);

        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("Airstrike Marker");
        meta.setUnbreakable(true);

        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY + "Select a place and enjoy the show");
        meta.setLore(lore);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);

        item.setItemMeta(meta);

        airstrikeMarker = item;
    }
}
