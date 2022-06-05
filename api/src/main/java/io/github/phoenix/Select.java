package io.github.phoenix;

import org.bukkit.Bukkit;

public interface Select {
    Menu createMenu(String title, int size);

    static Select getInstance() {
        return (Select) Bukkit.getPluginManager().getPlugin("Select");
    }
}
