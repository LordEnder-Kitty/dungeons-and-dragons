package net.enderkitty;

import net.enderkitty.block.ModBlocks;
import net.enderkitty.commands.CommandGamerule;
import net.enderkitty.commands.StopDoomCommand;
import net.enderkitty.commands.DoomCommand;
import net.enderkitty.effect.ModEffects;
import net.enderkitty.enchantment.ModEnchantments;
import net.enderkitty.entity.ModBlockEntities;
import net.enderkitty.entity.ModEntities;
import net.enderkitty.entity.entities.*;
import net.enderkitty.entity.entities.boats.ModBoatEntities;
import net.enderkitty.fluid.ModFluids;
import net.enderkitty.item.ModItems;
import net.enderkitty.potion.RegisterModPotions;
import net.enderkitty.recipe.ModRecipes;
import net.enderkitty.screen.ModScreenHandlers;
import net.enderkitty.sound.ModSounds;
import net.enderkitty.util.ModDamageSources;
import net.enderkitty.util.ModFlammableBlocks;
import net.enderkitty.util.ModLootTableModifiers;
import net.enderkitty.util.ModStrippableBlocks;
import net.enderkitty.villager.ModVillagers;
import net.enderkitty.world.feature.ModConfiguredFeatures;
import net.enderkitty.world.gen.ModWorldGen;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib3.GeckoLib;

public class DndMod implements ModInitializer {
    public static final String MOD_ID = "dndmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModConfiguredFeatures.registerConfiguredFeatures();
        ModWorldGen.generateWorldGen();

        ModItems.registerModItems();
        RegisterModPotions.registerPotions();
        ModRecipes.registerRecipes();
        ModEnchantments.registerModEnchantments();

        ModBlocks.registerModBlocks();
        ModBlockEntities.registerBlockEntities();
        ModFlammableBlocks.registerFlammableBlocks();
        ModStrippableBlocks.registerStrippables();
        ModFluids.register();

        ModLootTableModifiers.modifyLootTables();
        ModSounds.registerModSounds();
        ModScreenHandlers.registerAllScreenHandlers();

        GeckoLib.initialize();
        ModEffects.registerEffects();
        ModVillagers.registerVillagers();
        ModVillagers.registerTrades();
        ModDamageSources.registerDamageSources();
        ModBoatEntities.registerBoatEntities();


        FabricDefaultAttributeRegistry.register(ModEntities.HOUND, HoundEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.VAMPIRE_SPAWN, VampireSpawnEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.SHAMBLING_MOUND, ShamblingMoundEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.VAMPIRE, VampireEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.HOSTILE_VILLAGER, HostileVillagerEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.PRIEST, PriestEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.DEATH_KNIGHT, DeathKnightEntity.setAttributes());


        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            DoomCommand.register(dispatcher);
            StopDoomCommand.register(dispatcher);
        });
        CommandGamerule.register();
    }
}
