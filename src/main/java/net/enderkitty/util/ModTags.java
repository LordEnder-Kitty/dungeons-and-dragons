package net.enderkitty.util;

import net.enderkitty.DndMod;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModTags {

    public static final TagKey<Item> WEAPONS = TagKey.of(Registry.ITEM_KEY, new Identifier(DndMod.MOD_ID, "weapons"));
    public static final TagKey<Item> SIMPLE_WEAPONS = TagKey.of(Registry.ITEM_KEY, new Identifier(DndMod.MOD_ID, "simple_weapons"));
    public static final TagKey<Item> MARTIAL_WEAPONS = TagKey.of(Registry.ITEM_KEY, new Identifier(DndMod.MOD_ID, "martial_weapons"));
    public static final TagKey<Item> RANGED_WEAPONS = TagKey.of(Registry.ITEM_KEY, new Identifier(DndMod.MOD_ID, "ranged_weapons"));

    public static final TagKey<Item> ARMOR = TagKey.of(Registry.ITEM_KEY, new Identifier(DndMod.MOD_ID, "armor"));
    public static final TagKey<Item> LIGHT_ARMOR = TagKey.of(Registry.ITEM_KEY, new Identifier(DndMod.MOD_ID, "light_armor"));
    public static final TagKey<Item> MEDIUM_ARMOR = TagKey.of(Registry.ITEM_KEY, new Identifier(DndMod.MOD_ID, "medium_armor"));
    public static final TagKey<Item> HEAVY_ARMOR = TagKey.of(Registry.ITEM_KEY, new Identifier(DndMod.MOD_ID, "heavy_armor"));

}
