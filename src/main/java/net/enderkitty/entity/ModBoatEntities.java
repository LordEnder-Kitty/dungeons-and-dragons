package net.enderkitty.entity;

import net.enderkitty.DndMod;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.Supplier;

public class ModBoatEntities {

    public static <T extends Entity> Supplier<EntityType<T>>
    registerEntity(String name, EntityType.EntityFactory<T> entityFactory, SpawnGroup category, float width, float height, int clientTrackingRange) {
        EntityType<T> registry = Registry.register(Registry.ENTITY_TYPE, new Identifier(DndMod.MOD_ID, name),
                FabricEntityTypeBuilder.create(category, entityFactory).dimensions(EntityDimensions.fixed(width, height)).trackRangeChunks(clientTrackingRange).build());
        return () -> registry;
    }

    public static final Supplier<EntityType<ModBoatEntity>> BOAT = ModBoatEntities.registerEntity("boat",
            ModBoatEntity::new, SpawnGroup.MISC, 1.375F, 0.5625F, 10);

    public static final Supplier<EntityType<ModChestBoatEntity>> CHEST_BOAT = ModBoatEntities.registerEntity("chest_boat",
            ModChestBoatEntity::new, SpawnGroup.MISC, 1.375F, 0.5625F, 10);

    public static void registerBoatEntities() {

    }
}
