package net.enderkitty.world.feature;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;
import java.util.List;

public class ModPlacedFeatures {

    //Ore
    public static final RegistryEntry<PlacedFeature> SILVER_ORE_PLACED = PlacedFeatures.register("silver_ore_placed",
            ModConfiguredFeatures.SILVER_ORE, modifiersWithCount(7,
                    HeightRangePlacementModifier.trapezoid(YOffset.fixed(-64), YOffset.fixed(120))));
    public static final RegistryEntry<PlacedFeature> END_SILVER_ORE_PLACED = PlacedFeatures.register("end_silver_ore_placed",
            ModConfiguredFeatures.END_SILVER_ORE, modifiersWithCount(10,
                    HeightRangePlacementModifier.trapezoid(YOffset.fixed(-64), YOffset.fixed(120))));

    public static final RegistryEntry<PlacedFeature> ELECTRUM_ORE_PLACED = PlacedFeatures.register("electrum_ore_placed",
            ModConfiguredFeatures.ELECTRUM_ORE, modifiersWithCount(10,
                    HeightRangePlacementModifier.trapezoid(YOffset.fixed(-64), YOffset.fixed(120))));
    public static final RegistryEntry<PlacedFeature> NETHER_ELECTRUM_ORE_PLACED = PlacedFeatures.register("nether_electrum_ore_placed",
            ModConfiguredFeatures.NETHER_ELECTRUM_ORE, modifiersWithCount(10,
                    HeightRangePlacementModifier.trapezoid(YOffset.fixed(-64), YOffset.fixed(120))));
    public static final RegistryEntry<PlacedFeature> END_ELECTRUM_ORE_PLACED = PlacedFeatures.register("end_electrum_ore_placed",
            ModConfiguredFeatures.END_ELECTRUM_ORE, modifiersWithCount(10,
                    HeightRangePlacementModifier.trapezoid(YOffset.fixed(-64), YOffset.fixed(120))));

    public static final RegistryEntry<PlacedFeature> PLATINUM_ORE_PLACED = PlacedFeatures.register("platinum_ore_placed",
            ModConfiguredFeatures.PLATINUM_ORE, modifiersWithCount(6,
                    HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(100))));
    public static final RegistryEntry<PlacedFeature> SCULK_PLATINUM_ORE_PLACED = PlacedFeatures.register("sculk_platinum_ore_placed",
            ModConfiguredFeatures.SCULK_PLATINUM_ORE, modifiersWithCount(6,
                    HeightRangePlacementModifier.trapezoid(YOffset.fixed(-64), YOffset.fixed(0))));


    //Trees
    public static final RegistryEntry<PlacedFeature> ALDER_PLACED = PlacedFeatures.register("alder_placed",
            ModConfiguredFeatures.ALDER_SPAWN, VegetationPlacedFeatures.modifiers
                    (PlacedFeatures.createCountExtraModifier(0, 0.1f, 1)));
    public static final RegistryEntry<PlacedFeature> ASH_PLACED = PlacedFeatures.register("ash_placed",
            ModConfiguredFeatures.ASH_SPAWN, VegetationPlacedFeatures.modifiers
                    (PlacedFeatures.createCountExtraModifier(0, 0.1f, 1)));
    public static final RegistryEntry<PlacedFeature> BALSA_PLACED = PlacedFeatures.register("balsa_placed",
            ModConfiguredFeatures.BALSA_SPAWN, VegetationPlacedFeatures.modifiers
                    (PlacedFeatures.createCountExtraModifier(0, 0.1f, 1)));


    public static final RegistryEntry<PlacedFeature> YEAST_PLACED = PlacedFeatures.register("yeast_placed", ModConfiguredFeatures.YEAST_PLANT,
            RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());



    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }

    private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }

    private static List<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier heightModifier) {
        return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
    }
}
