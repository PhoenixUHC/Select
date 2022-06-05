package io.github.phoenix;

import io.github.phoenix.elements.Element;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SelectMenu implements Menu {
    private MenuTemplate template;
    private final Set<MenuHolder> holders;

    public SelectMenu(MenuTemplate template) {
        this.template = template;
        this.holders = new HashSet<>();
    }

    public void draw(MenuHolder holder) {
        holder.getInventory().clear();
        HashMap<Integer, Element> elements = template.onDisplay(holder.getPlayer());
        for (int i : elements.keySet()) {
            holder.getInventory().setItem(i, elements.get(i).onDisplay((holder).getPlayer()));
        }
    }

    public void draw() {
        for (MenuHolder holder : holders) {
            draw(holder);
        }
    }

    @Override
    public void open(Player player) {
        MenuHolder holder = new MenuHolder(this, player);
        Inventory inv = Bukkit.createInventory(holder, template.getSize(), template.getTitle());

        holder.setInventory(inv);
        draw(holder);
        player.openInventory(inv);
    }

    public MenuTemplate getTemplate() {
        return this.template;
    }
}
