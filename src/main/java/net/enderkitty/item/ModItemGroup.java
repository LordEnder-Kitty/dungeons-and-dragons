package net.enderkitty.item;

import net.enderkitty.DndMod;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;

public class ModItemGroup {

    public static final ItemGroup MISC = FabricItemGroupBuilder.build(new Identifier(DndMod.MOD_ID, "misc"), () -> new ItemStack(ModItems.PLATINUM_INGOT));

    public static final ItemGroup ARMOR = FabricItemGroupBuilder.build(new Identifier(DndMod.MOD_ID, "armor"), () -> new ItemStack(ModItems.HIDE_CHESTPLATE));
    public static final ItemGroup WEAPONS = FabricItemGroupBuilder.build(new Identifier(DndMod.MOD_ID, "weapons"), () -> new ItemStack(ModItems.GREATSWORD));
    public static final ItemGroup ADVENTURING_GEAR = FabricItemGroupBuilder.build(new Identifier(DndMod.MOD_ID, "adventuring_gear"), () -> new ItemStack(ModItems.SCAB));

    public static final ItemGroup THE_TAVERN = FabricItemGroupBuilder.build(new Identifier(DndMod.MOD_ID, "the_tavern"), () -> new ItemStack(ModItems.MUG_OF_ALE));
}
