package io.github.phoenix;

import io.github.phoenix.elements.Element;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SelectMenu implements Menu {
    private String title;
    private final int size;
    private final HashMap<Integer, Element> elements;
    private final Set<MenuHolder> holders;

    public SelectMenu(String title, int size) {
        this.title = title;
        this.size = size;
        this.elements = new HashMap<>();
        this.holders = new HashSet<>();
    }

    public void draw(MenuHolder holder) {
        holder.getInventory().clear();
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
        Inventory inv = Bukkit.createInventory(holder, size, title);

        holder.setInventory(inv);
        draw(holder);
        player.openInventory(inv);
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public HashMap<Integer, Element> getElements() {
        return elements;
    }

    public Set<MenuHolder> getHolders() {
        return holders;
    }
}
