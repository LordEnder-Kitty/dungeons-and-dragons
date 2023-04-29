package net.enderkitty.fluid;

import net.enderkitty.DndMod;
import net.enderkitty.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModFluids {
    public static FlowableFluid STILL_BLOOD;
    public static FlowableFluid FLOWING_BLOOD;
    public static Block BLOOD_BLOCK;
    public static Item BLOOD_BUCKET;

    public static void register() {
        STILL_BLOOD = Registry.register(Registry.FLUID,
                new Identifier(DndMod.MOD_ID, "blood"), new BloodFluid.Still());
        FLOWING_BLOOD = Registry.register(Registry.FLUID,
                new Identifier(DndMod.MOD_ID, "flowing_blood"), new BloodFluid.Flowing());

        BLOOD_BLOCK = Registry.register(Registry.BLOCK, new Identifier(DndMod.MOD_ID, "blood_block"),
                new FluidBlock(ModFluids.STILL_BLOOD, FabricBlockSettings.copyOf(Blocks.WATER)){ });
        BLOOD_BUCKET = Registry.register(Registry.ITEM, new Identifier(DndMod.MOD_ID, "blood_bucket"),
                new BucketItem(ModFluids.STILL_BLOOD, new FabricItemSettings().group(ModItemGroup.ADVENTURING_GEAR).recipeRemainder(Items.BUCKET).maxCount(1)));
    }
}
