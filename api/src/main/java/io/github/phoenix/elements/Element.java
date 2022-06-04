package io.github.phoenix.elements;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public abstract class Element {
    public abstract ItemStack onDisplay(Player viewer);
    public void onClick(Player who) {}
}
