package net.enderkitty.util;

import net.enderkitty.block.ModBlocks;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;

public class ModStrippableBlocks {
    public static void registerStrippables() {
        StrippableBlockRegistry.register(ModBlocks.ALDER_LOG, ModBlocks.STRIPPED_ALDER_LOG);
        StrippableBlockRegistry.register(ModBlocks.ALDER_WOOD, ModBlocks.STRIPPED_ALDER_WOOD);

        StrippableBlockRegistry.register(ModBlocks.ASH_LOG, ModBlocks.STRIPPED_ASH_LOG);
        StrippableBlockRegistry.register(ModBlocks.ASH_WOOD, ModBlocks.STRIPPED_ASH_WOOD);

        StrippableBlockRegistry.register(ModBlocks.ASH_LOG, ModBlocks.STRIPPED_ASH_LOG);
        StrippableBlockRegistry.register(ModBlocks.ASH_WOOD, ModBlocks.STRIPPED_ASH_WOOD);
    }
}
