package io.github.phoenix;

import io.github.phoenix.elements.Element;
import org.bukkit.entity.Player;

import java.util.HashMap;

public interface Menu {
    String getTitle();
    int getSize();
    void setTitle(String title);
    HashMap<Integer, Element> getElements();

    void open(Player player);
}
