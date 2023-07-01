package net.enderkitty.item;

import net.enderkitty.DndMod;
import net.enderkitty.block.ModBlocks;
import net.enderkitty.entity.ModEntities;
import net.enderkitty.entity.entities.boats.ModBoatEntity;
import net.enderkitty.entity.entities.boats.ModChestBoatEntity;
import net.enderkitty.item.items.*;
import net.enderkitty.item.items.daggers.*;
import net.enderkitty.sound.ModSounds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

import java.util.function.Supplier;

public class ModItems {

    //Marked For Deprecation
    @Deprecated
    public static final Item RICK_ROLL_MUSIC_DISC = registerItem("rick_roll_music_disc", new MusicDiscItem(7, ModSounds.RICK_ROLL,
            new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC).group(ModItemGroup.MISC), 333));
    @Deprecated
    public static final Item BLUE_DRAGON_BREATH_WEAPON = registerItem("blue_dragon_breath_weapon",
            new BlueDragonBreathWeaponItem(ToolMaterials.DIAMOND, 4, -1f, new FabricItemSettings().rarity(Rarity.EPIC).maxDamage(-1).group(ModItemGroup.WEAPONS)));
    @Deprecated
    public static final Item VAMPIRE_FIST = registerItem("vampire_fist", new VampireFistItem(ToolMaterials.STONE, 4, -1f,
            new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(-1).rarity(Rarity.EPIC)));




    //Materials
    public static final Item SILVER_INGOT = registerItem("silver_ingot", new Item(new FabricItemSettings().group(ModItemGroup.MISC)));
    public static final Item SILVER_NUGGET = registerItem("silver_nugget", new Item(new FabricItemSettings().group(ModItemGroup.MISC)));
    public static final Item RAW_SILVER = registerItem("raw_silver", new Item(new FabricItemSettings().group(ModItemGroup.MISC)));
    public static final Item SILVER_CARROT = registerItem("silver_carrot", new Item(new FabricItemSettings().group(ModItemGroup.MISC).food(ModFoods.SILVER_CARROT)));
    public static final Item SILVER_MELON = registerItem("silver_melon", new Item(new FabricItemSettings().group(ModItemGroup.MISC).food(ModFoods.SILVER_MELON)));

    public static final Item ELECTRUM_NUGGET = registerItem("electrum_nugget", new Item(new FabricItemSettings().group(ModItemGroup.MISC)));
    public static final Item ELECTRUM_INGOT = registerItem("electrum_ingot", new Item(new FabricItemSettings().group(ModItemGroup.MISC)));
    public static final Item RAW_ELECTRUM = registerItem("raw_electrum", new Item(new FabricItemSettings().group(ModItemGroup.MISC)));

    public static final Item PLATINUM_INGOT = registerItem("platinum_ingot", new PlatinumIngotItem(new FabricItemSettings().group(ModItemGroup.MISC).food(ModFoods.PLATINUM)));
    public static final Item RAW_PLATINUM = registerItem("raw_platinum", new RawPlatinumItem(new FabricItemSettings().group(ModItemGroup.MISC).food(ModFoods.PLATINUM)));
    public static final Item PLATINUM_NUGGET = registerItem("platinum_nugget", new PlatinumNuggetItem(new FabricItemSettings().group(ModItemGroup.MISC).food(ModFoods.PLATINUM)));

    public static final Item PLATINUM_PIECE = registerItem("platinum_piece", new PlatinumPieceItem(new FabricItemSettings().group(ModItemGroup.MISC).food(ModFoods.PLATINUM)));
    public static final Item ELECTRUM_PIECE = registerItem("electrum_piece", new Item(new FabricItemSettings().group(ModItemGroup.MISC)));
    public static final Item GOLD_PIECE = registerItem("gold_piece", new Item(new FabricItemSettings().group(ModItemGroup.MISC)));
    public static final Item SILVER_PIECE = registerItem("silver_piece", new Item(new FabricItemSettings().group(ModItemGroup.MISC)));
    public static final Item COPPER_PIECE = registerItem("copper_piece", new Item(new FabricItemSettings().group(ModItemGroup.MISC)));


    //Other
    public static final Item LEATHER_RINGING = registerItem("leather_ringing", new Item(new FabricItemSettings().group(ModItemGroup.MISC)));
    public static final Item SHARPENED_BONE_FRAGMENT = registerItem("sharpened_bone_fragment", new Item(new FabricItemSettings().group(ModItemGroup.MISC)));
    public static final Item BOTTLE_OF_BLOOD = registerItem("bottle_of_blood", new BottleOfBloodItem(new FabricItemSettings().group(ModItemGroup.MISC).food(ModFoods.BOTTLE_OF_BLOOD)));
    public static final Item SCAB = registerItem("scab", new Item(new FabricItemSettings().group(ModItemGroup.MISC)));

    public static final Item MAP1 = registerItem("map1", new Item(new FabricItemSettings().group(ModItemGroup.MISC)));
    public static final Item MAP2 = registerItem("map2", new Item(new FabricItemSettings().group(ModItemGroup.MISC)));
    public static final Item MAP3 = registerItem("map3", new Item(new FabricItemSettings().group(ModItemGroup.MISC)));
    public static final Item MAP4 = registerItem("map4", new Item(new FabricItemSettings().group(ModItemGroup.MISC)));
    public static final Item MAP5 = registerItem("map5", new Item(new FabricItemSettings().group(ModItemGroup.MISC)));

    public static final Item WIZARD_STAFF = registerItem("wizard_staff", new WizardStaffItem(ToolMaterials.WOOD, 3, -2f,
            new FabricItemSettings().maxDamage(-1).rarity(Rarity.RARE).group(ModItemGroup.WEAPONS)));



    //You meet in a tavern
    public static final Item MUG = registerItem("mug", new MugItem(ModBlocks.MUG, new FabricItemSettings().group(ModItemGroup.THE_TAVERN)));
    public static final Item MUG_OF_WATER = registerItem("mug_of_water", new MugOfWaterItem(ModBlocks.MUG_OF_WATER, new FabricItemSettings().maxCount(16).group(ModItemGroup.THE_TAVERN).food(ModFoods.MUG_OF_WATER)));
    public static final Item MUG_OF_ALE = registerItem("mug_of_ale", new MugOfAleItem(ModBlocks.MUG_OF_ALE, new FabricItemSettings().maxCount(16).group(ModItemGroup.THE_TAVERN).food(ModFoods.ALE)));

    public static final Item HARVESTED_YEAST = registerItem("harvested_yeast", new Item(new FabricItemSettings().group(ModItemGroup.THE_TAVERN)));
    public static final Item YEAST = registerItem("yeast", new Item(new FabricItemSettings().group(ModItemGroup.THE_TAVERN)));
    public static final Item BOWL_OF_YEAST = registerItem("bowl_of_yeast", new StewItem(new FabricItemSettings().maxCount(1).food(ModFoods.YEAST).recipeRemainder(Items.BOWL).group(ModItemGroup.THE_TAVERN)));
    public static final Item HOP = registerItem("hop", new Item(new FabricItemSettings().group(ModItemGroup.THE_TAVERN)));

    public static final Item BUCKET_OF_ALE = registerItem("ale_bucket", new BucketRemainderFoodItem(new FabricItemSettings().maxCount(1).recipeRemainder(Items.BUCKET).food(ModFoods.ALE_BUCKET).group(ModItemGroup.THE_TAVERN)));







//Armor

    //Misc
    public static final Item VAMPIRE_HELMET = registerItem("vampire_helmet", new VampireArmorItem(ArmorMaterials.DIAMOND, EquipmentSlot.HEAD, new FabricItemSettings().group(ModItemGroup.ARMOR)));
    public static final Item VAMPIRE_CHESTPLATE = registerItem("vampire_chestplate", new VampireArmorItem(ArmorMaterials.DIAMOND, EquipmentSlot.CHEST, new FabricItemSettings().group(ModItemGroup.ARMOR)));
    public static final Item VAMPIRE_LEGGINGS = registerItem("vampire_leggings", new VampireArmorItem(ArmorMaterials.DIAMOND, EquipmentSlot.LEGS, new FabricItemSettings().group(ModItemGroup.ARMOR)));
    public static final Item VAMPIRE_BOOTS = registerItem("vampire_boots", new VampireArmorItem(ArmorMaterials.DIAMOND, EquipmentSlot.FEET, new FabricItemSettings().group(ModItemGroup.ARMOR)));

    public static final Item CLOAK_HELMET = registerItem("cloak_helmet", new DyeableArmorItem(ModArmorMaterials.CLOAK, EquipmentSlot.HEAD, new FabricItemSettings().group(ModItemGroup.ARMOR)));
    public static final Item CLOAK_CHESTPLATE = registerItem("cloak_chestplate", new DyeableArmorItem(ModArmorMaterials.CLOAK, EquipmentSlot.CHEST, new FabricItemSettings().group(ModItemGroup.ARMOR)));
    public static final Item CLOAK_LEGGINGS = registerItem("cloak_leggings", new DyeableArmorItem(ModArmorMaterials.CLOAK, EquipmentSlot.LEGS, new FabricItemSettings().group(ModItemGroup.ARMOR)));
    public static final Item CLOAK_BOOTS = registerItem("cloak_boots", new DyeableArmorItem(ModArmorMaterials.CLOAK, EquipmentSlot.FEET, new FabricItemSettings().group(ModItemGroup.ARMOR)));

    //Light Armor
    public static final Item PADDED_HELMET = registerItem("padded_helmet", new ArmorItem(ModArmorMaterials.PADDED, EquipmentSlot.HEAD, new FabricItemSettings().group(ModItemGroup.ARMOR)));
    public static final Item PADDED_CHESTPLATE = registerItem("padded_chestplate", new ArmorItem(ModArmorMaterials.PADDED, EquipmentSlot.CHEST, new FabricItemSettings().group(ModItemGroup.ARMOR)));
    public static final Item PADDED_LEGGINGS = registerItem("padded_leggings", new ArmorItem(ModArmorMaterials.PADDED, EquipmentSlot.LEGS, new FabricItemSettings().group(ModItemGroup.ARMOR)));
    public static final Item PADDED_BOOTS = registerItem("padded_boots", new ArmorItem(ModArmorMaterials.PADDED, EquipmentSlot.FEET, new FabricItemSettings().group(ModItemGroup.ARMOR)));

    public static final Item STUDDED_LEATHER_HELMET = registerItem("studded_leather_helmet", new ArmorItem(ModArmorMaterials.STUDDED, EquipmentSlot.HEAD, new FabricItemSettings().group(ModItemGroup.ARMOR)));
    public static final Item STUDDED_LEATHER_CHESTPLATE = registerItem("studded_leather_chestplate", new ArmorItem(ModArmorMaterials.STUDDED, EquipmentSlot.CHEST, new FabricItemSettings().group(ModItemGroup.ARMOR)));
    public static final Item STUDDED_LEATHER_LEGGINGS = registerItem("studded_leather_leggings", new ArmorItem(ModArmorMaterials.STUDDED, EquipmentSlot.LEGS, new FabricItemSettings().group(ModItemGroup.ARMOR)));
    public static final Item STUDDED_LEATHER_BOOTS = registerItem("studded_leather_boots", new ArmorItem(ModArmorMaterials.STUDDED, EquipmentSlot.FEET, new FabricItemSettings().group(ModItemGroup.ARMOR)));

    //Medium Armor
    public static final Item HIDE_HELMET = registerItem("hide_helmet", new ArmorItem(ModArmorMaterials.HIDE, EquipmentSlot.HEAD, new FabricItemSettings().group(ModItemGroup.ARMOR)));
    public static final Item HIDE_CHESTPLATE = registerItem("hide_chestplate", new ArmorItem(ModArmorMaterials.HIDE, EquipmentSlot.CHEST, new FabricItemSettings().group(ModItemGroup.ARMOR)));
    public static final Item HIDE_LEGGINGS = registerItem("hide_leggings", new ArmorItem(ModArmorMaterials.HIDE, EquipmentSlot.LEGS, new FabricItemSettings().group(ModItemGroup.ARMOR)));
    public static final Item HIDE_BOOTS = registerItem("hide_boots", new ArmorItem(ModArmorMaterials.HIDE, EquipmentSlot.FEET, new FabricItemSettings().group(ModItemGroup.ARMOR)));

    public static final Item SCALE_HELMET = registerItem("scale_helmet", new ArmorItem(ModArmorMaterials.SCALE, EquipmentSlot.HEAD, new FabricItemSettings().group(ModItemGroup.ARMOR)));
    public static final Item SCALE_CHESTPLATE = registerItem("scale_chestplate", new ArmorItem(ModArmorMaterials.SCALE, EquipmentSlot.CHEST, new FabricItemSettings().group(ModItemGroup.ARMOR)));
    public static final Item SCALE_LEGGINGS = registerItem("scale_leggings", new ArmorItem(ModArmorMaterials.SCALE, EquipmentSlot.LEGS, new FabricItemSettings().group(ModItemGroup.ARMOR)));
    public static final Item SCALE_BOOTS = registerItem("scale_boots", new ArmorItem(ModArmorMaterials.SCALE, EquipmentSlot.FEET, new FabricItemSettings().group(ModItemGroup.ARMOR)));

    public static final Item HALF_PLATE_HELMET = registerItem("half_plate_helmet", new HalfPlateArmorItem(ModArmorMaterials.HALF_PLATE, EquipmentSlot.HEAD, new FabricItemSettings().group(ModItemGroup.ARMOR)));
    public static final Item HALF_PLATE_CHESTPLATE = registerItem("half_plate_chestplate", new HalfPlateArmorItem(ModArmorMaterials.HALF_PLATE, EquipmentSlot.CHEST, new FabricItemSettings().group(ModItemGroup.ARMOR)));
    public static final Item HALF_PLATE_LEGGINGS = registerItem("half_plate_leggings", new HalfPlateArmorItem(ModArmorMaterials.HALF_PLATE, EquipmentSlot.LEGS, new FabricItemSettings().group(ModItemGroup.ARMOR)));
    public static final Item HALF_PLATE_BOOTS = registerItem("half_plate_boots", new HalfPlateArmorItem(ModArmorMaterials.HALF_PLATE, EquipmentSlot.FEET, new FabricItemSettings().group(ModItemGroup.ARMOR)));

    //Heavy Armor
    public static final Item RING_MAIL_HELMET = registerItem("ring_mail_helmet", new ArmorItem(ModArmorMaterials.RING_MAIL, EquipmentSlot.HEAD, new FabricItemSettings().group(ModItemGroup.ARMOR)));
    public static final Item RING_MAIL_CHESTPLATE = registerItem("ring_mail_chestplate", new ArmorItem(ModArmorMaterials.RING_MAIL, EquipmentSlot.CHEST, new FabricItemSettings().group(ModItemGroup.ARMOR)));
    public static final Item RING_MAIL_LEGGINGS = registerItem("ring_mail_leggings", new ArmorItem(ModArmorMaterials.RING_MAIL, EquipmentSlot.LEGS, new FabricItemSettings().group(ModItemGroup.ARMOR)));
    public static final Item RING_MAIL_BOOTS = registerItem("ring_mail_boots", new ArmorItem(ModArmorMaterials.RING_MAIL, EquipmentSlot.FEET, new FabricItemSettings().group(ModItemGroup.ARMOR)));

    public static final Item SPLINT_HELMET = registerItem("splint_helmet", new ArmorItem(ModArmorMaterials.SPLINT, EquipmentSlot.HEAD, new FabricItemSettings().group(ModItemGroup.ARMOR)));
    public static final Item SPLINT_CHESTPLATE = registerItem("splint_chestplate", new ArmorItem(ModArmorMaterials.SPLINT, EquipmentSlot.CHEST, new FabricItemSettings().group(ModItemGroup.ARMOR)));
    public static final Item SPLINT_LEGGINGS = registerItem("splint_leggings", new ArmorItem(ModArmorMaterials.SPLINT, EquipmentSlot.LEGS, new FabricItemSettings().group(ModItemGroup.ARMOR)));
    public static final Item SPLINT_BOOTS = registerItem("splint_boots", new ArmorItem(ModArmorMaterials.SPLINT, EquipmentSlot.FEET, new FabricItemSettings().group(ModItemGroup.ARMOR)));


//Weapons

    //Ancient Weaponry
    public static final Item ANCIENT_SWORD = registerItem("ancient_sword", new SwordItem(ToolMaterials.IRON, 7, -2.6f,
            new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(-1).rarity(Rarity.EPIC)));
    public static final Item ANCIENT_AXE = registerItem("ancient_axe", new AxeItem(ToolMaterials.IRON, 7f, -2.8f,
            new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(-1).rarity(Rarity.EPIC)));
    public static final Item ANCIENT_MACE = registerItem("ancient_mace", new SwordItem(ToolMaterials.IRON, 7, -2.6f,
            new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(-1).rarity(Rarity.EPIC)));
    public static final Item ANCIENT_STAFF = registerItem("ancient_staff", new SwordItem(ToolMaterials.IRON, 8, -2.6f,
            new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(-1).rarity(Rarity.EPIC)));
    public static final Item ANCIENT_BOW = registerItem("ancient_bow", new BowItem(new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(-1).rarity(Rarity.EPIC)));

    //Silvered Tools
    public static final Item SILVERED_IRON_SWORD = registerItem("silvered_iron_sword", new SwordItem(ToolMaterials.IRON, 4, -2.4f,
            new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(250).rarity(Rarity.UNCOMMON)));
    public static final Item SILVERED_IRON_AXE = registerItem("silvered_iron_axe", new AxeItem(ToolMaterials.IRON, 8f, -3.1f,
            new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(250).rarity(Rarity.UNCOMMON)));
    public static final Item SILVERED_HANDAXE = registerItem("silvered_handaxe", new SilveredThrowableItem(
            new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(90).rarity(Rarity.UNCOMMON)));
    public static final Item SILVERED_GLAIVE = registerItem("silvered_glaive", new SwordItem(ToolMaterials.IRON, 5, -2.8f,
            new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(250).rarity(Rarity.UNCOMMON)));
    public static final Item SILVERED_GREATSWORD =registerItem("silvered_greatsword", new SwordItem(ToolMaterials.IRON, 5, -3f,
            new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(280).rarity(Rarity.UNCOMMON)));
    public static final Item SILVERED_LONGSWORD = registerItem("silvered_longsword", new SwordItem(ToolMaterials.IRON, 5, -2.8f,
            new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(250).rarity(Rarity.UNCOMMON)));
    public static final Item SILVERED_RAPIER = registerItem("silvered_rapier", new SwordItem(ToolMaterials.IRON, 4, -2,
            new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(220).rarity(Rarity.UNCOMMON)));
    public static final Item SILVERED_SCIMITAR = registerItem("silvered_scimitar", new SwordItem(ToolMaterials.IRON, 5, -2.2f,
            new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(230).rarity(Rarity.UNCOMMON)));
    public static final Item SILVERED_SHORTSWORD = registerItem("silvered_shortsword", new SwordItem(ToolMaterials.IRON, 4, -2.2f,
            new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(230).rarity(Rarity.UNCOMMON)));
    public static final Item SILVERED_IRON_SICKLE = registerItem("silvered_iron_sickle", new SwordItem(ToolMaterials.IRON, 4, -2f,
            new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(140)));


    //Simple Melee Weapons
    public static final Item WOODEN_CLUB = registerItem("wooden_club", new BluntItem(ToolMaterials.WOOD, 3.0f, -2.2f, new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(68)));
    public static final Item STONE_CLUB = registerItem("stone_club", new BluntItem(ToolMaterials.STONE, 3.5f, -2.6f, new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(96)));
    public static final Item GOLDEN_CLUB = registerItem("golden_club", new BluntItem(ToolMaterials.GOLD, 4.0f, -2.6f, new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(60)));
    public static final Item IRON_CLUB = registerItem("iron_club", new BluntItem(ToolMaterials.IRON, 4.5f, -2.6f, new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(216)));
    public static final Item DIAMOND_CLUB = registerItem("diamond_club", new BluntItem(ToolMaterials.DIAMOND, 5.0f, -2.6f, new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(436)));
    public static final Item NETHERITE_CLUB = registerItem("netherite_club", new BluntItem(ToolMaterials.NETHERITE, 5.5f, -2.6f, new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(954)));
    public static final Item SILVERED_IRON_CLUB = registerItem("silvered_iron_club", new BluntItem(ToolMaterials.IRON, 6f, -2.6f, new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(216)));

    public static final Item WOODEN_DAGGER = registerItem("wooden_dagger", new DaggerWoodItem(new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(148)));
    public static final Item STONE_DAGGER = registerItem("stone_dagger", new DaggerStoneItem(new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(246)));
    public static final Item GOLDEN_DAGGER = registerItem("golden_dagger", new DaggerGoldItem(new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(140)));
    public static final Item IRON_DAGGER = registerItem("iron_dagger", new DaggerIronItem(new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(678)));
    public static final Item DIAMOND_DAGGER = registerItem("diamond_dagger", new DaggerDiamondItem(new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(1056)));
    public static final Item NETHERITE_DAGGER = registerItem("netherite_dagger", new DaggerNetheriteItem(new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(2068)));
    public static final Item SILVERED_IRON_DAGGER = registerItem("silvered_iron_dagger", new SilveredThrowableItem(new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(678).rarity(Rarity.UNCOMMON)));

    public static final Item WOODEN_GREATCLUB = registerItem("wooden_greatclub", new BluntItem(ToolMaterials.WOOD, 4f, -2.8f, new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(70)));
    public static final Item STONE_GREATCLUB = registerItem("stone_greatclub", new BluntItem(ToolMaterials.STONE, 4.5f, -2.8f, new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(70)));
    public static final Item GOLDEN_GREATCLUB = registerItem("golden_greatclub", new BluntItem(ToolMaterials.GOLD, 5f, -2.8f, new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(70)));
    public static final Item IRON_GREATCLUB = registerItem("iron_greatclub", new BluntItem(ToolMaterials.IRON, 5.5f, -2.8f, new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(70)));
    public static final Item DIAMOND_GREATCLUB = registerItem("diamond_greatclub", new BluntItem(ToolMaterials.DIAMOND, 6f, -2.8f, new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(70)));
    public static final Item NETHERITE_GREATCLUB = registerItem("netherite_greatclub", new BluntItem(ToolMaterials.NETHERITE, 6.5f, -2.8f, new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(70)));



    public static final Item HANDAXE = registerItem("handaxe", new ThrowableItem(new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(94)));
    public static final Item JAVELIN = registerItem("javelin", new TridentItem(new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(128)));
    public static final Item LIGHT_HAMMER = registerItem("light_hammer", new ThrowableItem(new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(110)));
    public static final Item MACE = registerItem("mace", new AxeItem(ToolMaterials.IRON, 3.8f, -2.6f, new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(148)));
    public static final Item QUARTERSTAFF = registerItem("quarterstaff", new SwordItem(ToolMaterials.WOOD, 3, -2f, new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(114)));
    public static final Item SICKLE = registerItem("sickle", new SwordItem(ToolMaterials.IRON, 3, -2f, new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(140)));
    public static final Item SPEAR =registerItem("spear", new ThrowableItem(new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(120)));

    //Simple Ranged Weapons
    public static final Item SLING = registerItem("sling", new BowItem(new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(74)));
    public static final Item DART = registerItem("dart", new DartItem(new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(32)));

    //Martial Weapons
    public static final Item BATTLEAXE = registerItem("battleaxe", new AxeItem(ToolMaterials.IRON, 4f, -3f, new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(244)));
    public static final Item FLAIL = registerItem("flail", new SwordItem(ToolMaterials.IRON,4, -2.8f, new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(238)));
    public static final Item GLAIVE = registerItem("glaive", new SwordItem(ToolMaterials.IRON, 4, -2.8f, new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(258)));
    public static final Item GREATAXE = registerItem("greataxe", new AxeItem(ToolMaterials.IRON, 4.4f, -3f, new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(256)));
    public static final Item GREATSWORD =registerItem("greatsword", new SwordItem(ToolMaterials.IRON, 4, -3f, new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(284)));
    public static final Item HALBERD = registerItem("halberd", new SwordItem(ToolMaterials.IRON, 4, -2.6f, new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(246)));
    public static final Item LANCE = registerItem("lance", new BluntItem(ToolMaterials.IRON, 6.6f, -3.4f, new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(268)));
    public static final Item LONGSWORD = registerItem("longsword", new SwordItem(ToolMaterials.IRON, 4, -2.8f, new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(256)));
    public static final Item MAUL = registerItem("maul", new BluntItem(ToolMaterials.IRON, 4, -2.8f, new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(248)));
    public static final Item MORNING_STAR = registerItem("morning_star", new BluntItem(ToolMaterials.IRON, 4, -2.8f, new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(250)));
    public static final Item PIKE = registerItem("pike", new SwordItem(ToolMaterials.IRON, 4, -2.8f, new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(256)));
    public static final Item RAPIER = registerItem("rapier", new SwordItem(ToolMaterials.IRON, 3, -2, new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(224)));
    public static final Item SCIMITAR = registerItem("scimitar", new SwordItem(ToolMaterials.IRON, 3, -2.2f, new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(234)));
    public static final Item SHORTSWORD = registerItem("shortsword", new SwordItem(ToolMaterials.IRON, 3, -2.2f, new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(238)));
    public static final Item WAR_PICK = registerItem("war_pick", new SwordItem(ToolMaterials.IRON, 3, -2f, new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(218)));
    public static final Item WARHAMMER = registerItem("warhammer", new BluntItem(ToolMaterials.IRON, 3, -3f, new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(264)));
    public static final Item WHIP = registerItem("whip", new SwordItem(ToolMaterials.IRON, 3, -2.6f, new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(264)));

    //Martial Ranged Weapons
    public static final Item BLOWGUN = registerItem("blowgun", new BowItem(new FabricItemSettings().group(ModItemGroup.WEAPONS).maxDamage(96)));


//Adventuring Gear

    public static final Item ABACUS = registerItem("abacus", new Item(new FabricItemSettings().group(ModItemGroup.ADVENTURING_GEAR)));


//Boats
    public static final Supplier<Item> ALDER_BOAT = registerBoatItem("alder_boat", () ->
            new ModBoatItem(false, ModBoatEntity.Type.ALDER, new FabricItemSettings().maxCount(1).group(ModItemGroup.MISC)));
    public static final Supplier<Item> ALDER_CHEST_BOAT = registerBoatItem("alder_chest_boat", () ->
            new ModBoatItem(true, ModChestBoatEntity.Type.ALDER, new FabricItemSettings().maxCount(1).group(ModItemGroup.MISC)));
    public static final Supplier<Item> ASH_BOAT = registerBoatItem("ash_boat", () ->
            new ModBoatItem(false, ModBoatEntity.Type.ASH, new FabricItemSettings().maxCount(1).group(ModItemGroup.MISC)));
    public static final Supplier<Item> ASH_CHEST_BOAT = registerBoatItem("ash_chest_boat", () ->
            new ModBoatItem(true, ModChestBoatEntity.Type.ASH, new FabricItemSettings().maxCount(1).group(ModItemGroup.MISC)));
    public static final Supplier<Item> BALSA_BOAT = registerBoatItem("balsa_boat", () ->
            new ModBoatItem(false, ModBoatEntity.Type.BALSA, new FabricItemSettings().maxCount(1).group(ModItemGroup.MISC)));
    public static final Supplier<Item> BALSA_CHEST_BOAT = registerBoatItem("balsa_chest_boat", () ->
            new ModBoatItem(true, ModChestBoatEntity.Type.BALSA, new FabricItemSettings().maxCount(1).group(ModItemGroup.MISC)));

//Signs
    public static final Item ALDER_SIGN = registerItem("alder_sign", new ModSignItem(new FabricItemSettings().maxCount(16).group(ModItemGroup.MISC), ModBlocks.ALDER_SIGN, ModBlocks.ALDER_WALL_SIGN));




//Spawn Eggs
    public static final Item HOUND_SPAWN_EGG = registerItem("hound_spawn_egg", new SpawnEggItem(ModEntities.HOUND, 0x000000, 0x8b0000, new FabricItemSettings().group(ModItemGroup.MISC)));
    public static final Item VAMPIRE_SPAWN_SPAWN_EGG = registerItem("vampire_spawn_spawn_egg", new SpawnEggItem(ModEntities.VAMPIRE_SPAWN, 0xF8F0E3, 0x8b0000, new FabricItemSettings().group(ModItemGroup.MISC)));
    public static final Item SHAMBLING_MOUND_SPAWN_EGG = registerItem("shambling_mound_spawn_egg", new SpawnEggItem(ModEntities.SHAMBLING_MOUND, 0x006400, 0x5C4033, new FabricItemSettings().group(ModItemGroup.MISC)));
    public static final Item VAMPIRE_SPAWN_EGG = registerItem("vampire_spawn_egg", new SpawnEggItem(ModEntities.VAMPIRE, 0x8B0000, 0x000000, new FabricItemSettings().group(ModItemGroup.MISC)));
    public static final Item HOSTILE_VILLAGER_SPAWN_EGG = registerItem("hostile_villager_spawn_egg", new SpawnEggItem(ModEntities.HOSTILE_VILLAGER, 5651507, 12422002, new FabricItemSettings().group(ModItemGroup.MISC)));
    public static final Item PRIEST_SPAWN_EGG = registerItem("priest_spawn_egg", new SpawnEggItem(ModEntities.PRIEST, 0xFFFFFF, 0xFFAE42, new FabricItemSettings().group(ModItemGroup.MISC)));
    public static final Item DEATH_KNIGHT_SPAWN_EGG = registerItem("death_knight_spawn_egg", new SpawnEggItem(ModEntities.DEATH_KNIGHT, 0xFAF9F6, 0xB59410, new FabricItemSettings().group(ModItemGroup.MISC)));



    public static <T extends Item> Supplier<T> registerBoatItem(String name, Supplier<T> item) {var register = Registry.register(Registry.ITEM, new Identifier(DndMod.MOD_ID, name), item.get()); return () -> register;}
    private static Item registerItem(String name, Item item) {return Registry.register(Registry.ITEM, new Identifier(DndMod.MOD_ID, name), item);}

    public static void registerModItems() {DndMod.LOGGER.debug("Registering D&D Items");}
}
