package io.github.phoenix;

import io.github.phoenix.elements.Element;
import org.bukkit.entity.Player;

import java.util.HashMap;

public abstract class MenuTemplate {
    public abstract String getTitle();
    public abstract int getSize();

    public HashMap<Integer, Element> onDisplay(Player player) { return new HashMap<>(); }
    public void onClose(Player player) {}
}
