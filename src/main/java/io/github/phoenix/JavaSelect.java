package io.github.phoenix;

import io.github.phoenix.elements.Element;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class JavaSelect extends JavaPlugin implements Listener, Select {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public Menu createMenu(MenuTemplate template) {
        return new SelectMenu(template);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (e.getInventory().getHolder() instanceof MenuHolder) {
            e.setCancelled(true);
            MenuHolder holder = (MenuHolder) e.getInventory().getHolder();
            HashMap<Integer, Element> elements = holder.getMenu().getTemplate().onDisplay(holder.getPlayer());
            if (elements.get(e.getSlot()) == null) return;

            elements.get(e.getSlot()).onClick(holder.getPlayer());
            holder.getMenu().draw(holder);
        }
    }
}
