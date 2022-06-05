package io.github.phoenix.elements;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public abstract class SwitchElement extends Element {
    private final ItemStack display;

    public SwitchElement(ItemStack display) {
        this.display = display;
    }

    public abstract boolean isEnabled(Player player);

    @Override
    public ItemStack onDisplay(Player viewer) {
        ItemStack is = new ItemStack(display);
        if (isEnabled(viewer)) is.addEnchantment(Enchantment.ARROW_DAMAGE, 1);
        else {
            for (Enchantment e : display.getEnchantments().keySet()) is.removeEnchantment(e);

            ItemMeta im = is.getItemMeta();
            for (Enchantment e : im.getEnchants().keySet()) im.removeEnchant(e);
            is.setItemMeta(im);
        }

        return is;
    }
}
