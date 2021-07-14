package net.choco.whocraftit.listeners;

import net.choco.whocraftit.Main;
import net.choco.whocraftit.utility.ChatUtils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class CraftListener implements Listener {

    @EventHandler
    public void onPlayerCraft(CraftItemEvent event) {
        Player player = (Player)event.getWhoClicked();
        ItemStack item = event.getCurrentItem();
        ItemMeta itemMeta = item.getItemMeta();
        List<String> list = new ArrayList<>();
        Main.getInstance().getFileManager().getConfig("config.yml").get().getStringList("craft.lore").forEach(line -> list.add(ChatUtils.color(line).replace("{player}", player.getName())));
        itemMeta.setLore(list);
        item.setItemMeta(itemMeta);
    }
}
