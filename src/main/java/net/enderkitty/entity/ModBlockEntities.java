package net.enderkitty.entity;

import net.enderkitty.DndMod;
import net.enderkitty.block.ModBlocks;
import net.enderkitty.entity.blocks.KegBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlockEntities {
    public static final BlockEntityType<KegBlockEntity> KEG_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            new Identifier(DndMod.MOD_ID, "keg_block_entity"),
            FabricBlockEntityTypeBuilder.create(KegBlockEntity::new, ModBlocks.KEG_OF_ALE).build()
    );

    public static void registerBlockEntities() {DndMod.LOGGER.debug("Registering block entities for DndMod");}
}
