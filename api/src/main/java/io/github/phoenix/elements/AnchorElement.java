package io.github.phoenix.elements;

import io.github.phoenix.Menu;
import org.bukkit.entity.Player;

public abstract class AnchorElement extends Element {
    public abstract Menu onRedirect(Player player);

    @Override
    public void onClick(Player who) {
        Menu menu = onRedirect(who);
        who.closeInventory();
        menu.open(who);
    }
}
