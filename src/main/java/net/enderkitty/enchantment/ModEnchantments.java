package net.enderkitty.enchantment;

import net.enderkitty.DndMod;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEnchantments {

    public static Enchantment LIGHTNING = register("lightning",
            new LightningEnchantment(Enchantment.Rarity.RARE, EnchantmentTarget.WEAPON));



    private static Enchantment register(String name, Enchantment enchantment) {
        return Registry.register(Registry.ENCHANTMENT, new Identifier(DndMod.MOD_ID, name), enchantment);
    }

    public static void registerModEnchantments() {
        System.out.println("Registering Enchantments for " + DndMod.MOD_ID);
    }
}
