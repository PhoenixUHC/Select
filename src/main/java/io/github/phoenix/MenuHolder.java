package io.github.phoenix;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class MenuHolder implements InventoryHolder {
    private final SelectMenu menu;
    private final Player player;
    private Inventory inventory;

    public MenuHolder(SelectMenu menu, Player player) {
        this.menu = menu;
        this.player = player;
    }

    public SelectMenu getMenu() {
        return menu;
    }

    public Player getPlayer() {
        return player;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
