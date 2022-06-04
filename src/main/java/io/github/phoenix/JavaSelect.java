package io.github.phoenix;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class JavaSelect extends JavaPlugin implements Listener, Select {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public Menu createMenu(String title, int size) {
        return new SelectMenu(title, size);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (e.getInventory().getHolder() instanceof MenuHolder) {
            e.setCancelled(true);
            MenuHolder holder = (MenuHolder) e.getInventory().getHolder();
            holder.getMenu().getElements().get(e.getSlot()).onClick(holder.getPlayer());
            holder.getMenu().draw(holder);
        }
    }
}
