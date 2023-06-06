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

    public static final EntityType<DaggerEntityIron> DAGGER_IRON = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(DndMod.MOD_ID, "dagger_iron"),
            FabricEntityTypeBuilder.<DaggerEntityIron>create(SpawnGroup.MISC, DaggerEntityIron::new)
                    .dimensions(EntityDimensions.fixed(0.4F, 0.4F)).trackRangeBlocks(4).trackedUpdateRate(10).build());
    public static final EntityType<DaggerEntityWood> DAGGER_WOOD = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(DndMod.MOD_ID, "dagger_wood"),
            FabricEntityTypeBuilder.<DaggerEntityWood>create(SpawnGroup.MISC, DaggerEntityWood::new)
                    .dimensions(EntityDimensions.fixed(0.4F, 0.4F)).trackRangeBlocks(4).trackedUpdateRate(10).build());
    public static final EntityType<DaggerEntityStone> DAGGER_STONE = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(DndMod.MOD_ID, "dagger_stone"),
            FabricEntityTypeBuilder.<DaggerEntityStone>create(SpawnGroup.MISC, DaggerEntityStone::new)
                    .dimensions(EntityDimensions.fixed(0.4F, 0.4F)).trackRangeBlocks(4).trackedUpdateRate(10).build());
    public static final EntityType<DaggerEntityGold> DAGGER_GOLD = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(DndMod.MOD_ID, "dagger_gold"),
            FabricEntityTypeBuilder.<DaggerEntityGold>create(SpawnGroup.MISC, DaggerEntityGold::new)
                    .dimensions(EntityDimensions.fixed(0.4F, 0.4F)).trackRangeBlocks(4).trackedUpdateRate(10).build());
    public static final EntityType<DaggerEntityDiamond> DAGGER_DIAMOND = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(DndMod.MOD_ID, "dagger_diamond"),
            FabricEntityTypeBuilder.<DaggerEntityDiamond>create(SpawnGroup.MISC, DaggerEntityDiamond::new)
                    .dimensions(EntityDimensions.fixed(0.4F, 0.4F)).trackRangeBlocks(4).trackedUpdateRate(10).build());
    public static final EntityType<DaggerEntityNetherite> DAGGER_NETHERITE = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(DndMod.MOD_ID, "dagger_netherite"),
            FabricEntityTypeBuilder.<DaggerEntityNetherite>create(SpawnGroup.MISC, DaggerEntityNetherite::new)
                    .dimensions(EntityDimensions.fixed(0.4F, 0.4F)).trackRangeBlocks(4).trackedUpdateRate(10).build());
}
