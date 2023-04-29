package net.enderkitty.world.feature;

import net.enderkitty.DndMod;
import net.enderkitty.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.AcaciaFoliagePlacer;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.DarkOakFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.DarkOakTrunkPlacer;
import net.minecraft.world.gen.trunk.LargeOakTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures {
    public static final List<OreFeatureConfig.Target> OVERWORLD_SILVER_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.SILVER_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_SILVER_ORE.getDefaultState()));
    public static final List<OreFeatureConfig.Target> OVERWORLD_ELECTRUM_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.ELECTRUM_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_ELECTRUM_ORE.getDefaultState()));
    public static final List<OreFeatureConfig.Target> NETHER_ELECTRUM_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.NETHERRACK, ModBlocks.NETHERRACK_ELECTRUM_ORE.getDefaultState()));

    public static final List<OreFeatureConfig.Target> END_SILVER_ORES = List.of(
            OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.END_STONE), ModBlocks.ENDSTONE_SILVER_ORE.getDefaultState()));
    public static final List<OreFeatureConfig.Target> END_ELECTRUM_ORES = List.of(
            OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.END_STONE), ModBlocks.ENDSTONE_ELECTRUM_ORE.getDefaultState()));

    public static final List<OreFeatureConfig.Target> OVERWORLD_PLATINUM_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.PLATINUM_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_PLATINUM_ORE.getDefaultState()));
    public static final List<OreFeatureConfig.Target> SCULK_PLATINUM_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.SCULK_PLATINUM_ORE.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> SILVER_ORE =
            ConfiguredFeatures.register("silver_ore", Feature.ORE, new OreFeatureConfig(OVERWORLD_SILVER_ORES, 9));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> END_SILVER_ORE =
            ConfiguredFeatures.register("end_silver_ore", Feature.ORE, new OreFeatureConfig(END_SILVER_ORES, 9));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ELECTRUM_ORE =
            ConfiguredFeatures.register("elevtrum_ore", Feature.ORE, new OreFeatureConfig(OVERWORLD_ELECTRUM_ORES, 8));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> NETHER_ELECTRUM_ORE =
            ConfiguredFeatures.register("nether_elevtrum_ore", Feature.ORE, new OreFeatureConfig(NETHER_ELECTRUM_ORES, 10));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> END_ELECTRUM_ORE =
            ConfiguredFeatures.register("end_electrum_ore", Feature.ORE, new OreFeatureConfig(END_ELECTRUM_ORES, 8));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> PLATINUM_ORE =
            ConfiguredFeatures.register("platinum_ore", Feature.ORE, new OreFeatureConfig(OVERWORLD_PLATINUM_ORES, 6));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> SCULK_PLATINUM_ORE =
            ConfiguredFeatures.register("sculk_platinum_ore", Feature.ORE, new OreFeatureConfig(SCULK_PLATINUM_ORES, 8));



    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> ALDER_TREE =
            ConfiguredFeatures.register("alder_tree", Feature.TREE, new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(ModBlocks.ALDER_LOG),
                    new StraightTrunkPlacer(7, 13, 4),
                    BlockStateProvider.of(ModBlocks.ALDER_LEAVES),
                    new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 5),
                    new TwoLayersFeatureSize(1, 0, 2)).build());
    public static final RegistryEntry<PlacedFeature> ALDER_CHECKED = PlacedFeatures.register("alder_checked",
            ModConfiguredFeatures.ALDER_TREE, List.of(PlacedFeatures.wouldSurvive(ModBlocks.ALDER_SAPLING)));
    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> ALDER_SPAWN =
            ConfiguredFeatures.register("alder_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfig(List.of(new RandomFeatureEntry(ALDER_CHECKED, 0.5f)), ALDER_CHECKED));

    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> ASH_TREE =
            ConfiguredFeatures.register("ash_tree", Feature.TREE, new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(ModBlocks.ASH_LOG),
                    new DarkOakTrunkPlacer(7, 10, 5),
                    BlockStateProvider.of(ModBlocks.ASH_LEAVES),
                    new DarkOakFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0)),
                    new TwoLayersFeatureSize(1, 0, 2)).build());
    public static final RegistryEntry<PlacedFeature> ASH_CHECKED = PlacedFeatures.register("ash_checked",
            ModConfiguredFeatures.ASH_TREE, List.of(PlacedFeatures.wouldSurvive(ModBlocks.ASH_SAPLING)));
    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> ASH_SPAWN =
            ConfiguredFeatures.register("ash_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfig(List.of(new RandomFeatureEntry(ASH_CHECKED, 0.5f)), ASH_CHECKED));

    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> BALSA_TREE =
            ConfiguredFeatures.register("balsa_tree", Feature.TREE, new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(ModBlocks.BALSA_LOG),
                    new LargeOakTrunkPlacer(7, 13, 4),
                    BlockStateProvider.of(ModBlocks.BALSA_LEAVES),
                    new AcaciaFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1)),
                    new TwoLayersFeatureSize(1, 0, 4)).build());
    public static final RegistryEntry<PlacedFeature> BALSA_CHECKED = PlacedFeatures.register("balsa_checked",
            ModConfiguredFeatures.BALSA_TREE, List.of(PlacedFeatures.wouldSurvive(ModBlocks.BALSA_SAPLING)));
    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> BALSA_SPAWN =
            ConfiguredFeatures.register("balsa_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfig(List.of(new RandomFeatureEntry(BALSA_CHECKED, 0.5f)), BALSA_CHECKED));



    public static void registerConfiguredFeatures() {
        DndMod.LOGGER.debug("Registering the ModConfiguredFeatures for " + DndMod.MOD_ID);
    }
}
