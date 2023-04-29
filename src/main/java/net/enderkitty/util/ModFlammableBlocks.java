package net.enderkitty.util;

import net.enderkitty.block.ModBlocks;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;

public class ModFlammableBlocks {
    public static void registerFlammableBlocks() {
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();

        registry.add(ModBlocks.ALDER_LEAVES, 30, 60);
        registry.add(ModBlocks.ALDER_LOG, 5, 5);
        registry.add(ModBlocks.ALDER_WOOD, 5, 5);
        registry.add(ModBlocks.STRIPPED_ALDER_LOG, 5, 5);
        registry.add(ModBlocks.STRIPPED_ALDER_WOOD, 5, 5);
        registry.add(ModBlocks.ALDER_PLANKS, 5, 20);

        registry.add(ModBlocks.ASH_LEAVES, 30, 60);
        registry.add(ModBlocks.ASH_LOG, 5, 5);
        registry.add(ModBlocks.ASH_WOOD, 5, 5);
        registry.add(ModBlocks.STRIPPED_ASH_LOG, 5, 5);
        registry.add(ModBlocks.STRIPPED_ASH_WOOD, 5, 5);
        registry.add(ModBlocks.ASH_PLANKS, 5, 20);

        registry.add(ModBlocks.BALSA_LEAVES, 30, 60);
        registry.add(ModBlocks.BALSA_LOG, 5, 5);
        registry.add(ModBlocks.BALSA_WOOD, 5, 5);
        registry.add(ModBlocks.STRIPPED_BALSA_LOG, 5, 5);
        registry.add(ModBlocks.STRIPPED_BALSA_WOOD, 5, 5);
        registry.add(ModBlocks.BALSA_PLANKS, 5, 20);
    }
}
