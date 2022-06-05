package io.github.phoenix;

import org.bukkit.Bukkit;

public interface Select {
    Menu createMenu(MenuTemplate template);

    static Select getInstance() {
        return (Select) Bukkit.getPluginManager().getPlugin("Select");
    }
}
