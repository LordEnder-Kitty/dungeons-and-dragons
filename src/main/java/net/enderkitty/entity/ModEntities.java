package net.enderkitty.entity;

import net.enderkitty.DndMod;
import net.enderkitty.entity.custom.*;
import net.enderkitty.entity.custom.HoundEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities {
    public static final EntityType<HoundEntity> HOUND = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(DndMod.MOD_ID, "hound"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, HoundEntity::new)
                    .dimensions(EntityDimensions.fixed(1f, 1f)).build());
    public static final EntityType<VampireSpawnEntity> VAMPIRE_SPAWN = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(DndMod.MOD_ID, "vampire_spawn"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, VampireSpawnEntity::new)
                    .dimensions(EntityDimensions.fixed(0.8f, 1.8f)).build());
    public static final EntityType<ShamblingMoundEntity> SHAMBLING_MOUND = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(DndMod.MOD_ID, "shambling_mound"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, ShamblingMoundEntity::new)
                    .dimensions(EntityDimensions.fixed(3.4f, 3.4f)).build());
    public static final EntityType<VampireEntity> VAMPIRE = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(DndMod.MOD_ID, "vampire"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, VampireEntity::new)
                    .dimensions(EntityDimensions.fixed(0.8f, 1.8f)).build());
    public static final EntityType<HostileVillagerEntity> HOSTILE_VILLAGER = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(DndMod.MOD_ID, "hostile_villager"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, HostileVillagerEntity::new)
                    .dimensions(EntityDimensions.fixed(0.8f, 1.8f)).build());
    public static final EntityType<PriestEntity> PRIEST = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(DndMod.MOD_ID, "priest"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, PriestEntity::new)
                    .dimensions(EntityDimensions.fixed(0.8f, 1.8f)).build());
    public static final EntityType<DeathKnightEntity> DEATH_KNIGHT = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(DndMod.MOD_ID, "death_knight"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, DeathKnightEntity::new)
                    .dimensions(EntityDimensions.fixed(0.8f, 1.8f)).build());

    public static final EntityType<DaggerEntity> DAGGER = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(DndMod.MOD_ID, "dagger"),
            FabricEntityTypeBuilder.<DaggerEntity>create(SpawnGroup.MISC, DaggerEntity::new)
                    .dimensions(EntityDimensions.fixed(0.4F, 0.4F)).trackRangeBlocks(4).trackedUpdateRate(10).build()
    );
}
