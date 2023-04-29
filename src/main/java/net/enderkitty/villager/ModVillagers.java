package net.enderkitty.villager;

import com.google.common.collect.ImmutableSet;
import net.enderkitty.DndMod;
import net.enderkitty.block.ModBlocks;
import net.enderkitty.fluid.ModFluids;
import net.enderkitty.item.ModItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.object.builder.v1.villager.VillagerProfessionBuilder;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class ModVillagers {
    public static final PointOfInterestType ALCHEMIST_POI = registerPOI("alchemist_poi", ModBlocks.ALCHEMY_TABLE);
    public static final PointOfInterestType ADVENTURER_POI = registerPOI("adventurer_poi", ModBlocks.ADVENTURING_TABLE);

    public static final VillagerProfession ALCHEMIST = registerProfession("alchemist",
            RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(DndMod.MOD_ID, "alchemist_poi")));
    public static final VillagerProfession ADVENTURER = registerProfession("adventurer",
            RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(DndMod.MOD_ID, "adventurer_poi")));


    public static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registry.VILLAGER_PROFESSION, new Identifier(DndMod.MOD_ID, name),
                VillagerProfessionBuilder.create().id(new Identifier(DndMod.MOD_ID, name)).workstation(type)
                        .workSound(SoundEvents.ENTITY_VILLAGER_WORK_CLERIC).build());
    }

    public static PointOfInterestType registerPOI(String name, Block block) {
        return PointOfInterestHelper.register(new Identifier(DndMod.MOD_ID, name),
                1, 1, ImmutableSet.copyOf(block.getStateManager().getStates()));
    }

    public static void registerVillagers() {
        DndMod.LOGGER.debug("Registering Villager for " + DndMod.MOD_ID);
    }




    //Trades
    public static void registerTrades() {

        //Alchemist
        TradeOfferHelper.registerVillagerOffers(ALCHEMIST, 1, factories -> {
            factories.add(((entity, random) -> new TradeOffer(
                new ItemStack(Items.EMERALD, 6),
                    new ItemStack(ModFluids.BLOOD_BUCKET, 1),
                    4, 2, 0.02f)));});
        TradeOfferHelper.registerVillagerOffers(ALCHEMIST, 1, factories -> {
            factories.add(((entity, random) -> new TradeOffer(
                new ItemStack(Items.EMERALD, 2),
                    new ItemStack(ModItems.BOTTLE_OF_BLOOD, 1),
                    8, 2, 0.02f)));});
        TradeOfferHelper.registerVillagerOffers(ALCHEMIST, 2, factories -> {
            factories.add(((entity, random) -> new TradeOffer(
                new ItemStack(ModFluids.BLOOD_BUCKET, 1),
                    new ItemStack(Items.GLASS_BOTTLE, 2),
                    new ItemStack(ModItems.BOTTLE_OF_BLOOD, 2),
                    4, 3, 0.02f)));});
        TradeOfferHelper.registerVillagerOffers(ALCHEMIST, 2, factories -> {
            factories.add(((entity, random) -> new TradeOffer(
                new ItemStack(Items.EMERALD, 2),
                    new ItemStack(Items.BONE, 1),
                    new ItemStack(ModItems.SHARPENED_BONE_FRAGMENT, 2),
                    6, 3, 0.02f)));});
        TradeOfferHelper.registerVillagerOffers(ALCHEMIST, 2, factories -> {
            factories.add(((entity, random) -> new TradeOffer(
                new ItemStack(Items.EMERALD, 2),
                    new ItemStack(ModItems.LEATHER_RINGING, 2),
                    6, 2, 0.02f)));});
        TradeOfferHelper.registerVillagerOffers(ALCHEMIST, 3, factories -> {
            factories.add(((entity, random) -> new TradeOffer(
                new ItemStack(Items.REDSTONE, 10),
                    new ItemStack(Items.GLASS_BOTTLE, 3),
                    16, 2, 0.02f)));});
        TradeOfferHelper.registerVillagerOffers(ALCHEMIST, 3, factories -> {
            factories.add(((entity, random) -> new TradeOffer(
                new ItemStack(Items.EMERALD, 20),
                    new ItemStack(Items.BLAZE_ROD, 2),
                    6, 3, 0.02f)));});
        TradeOfferHelper.registerVillagerOffers(ALCHEMIST, 3, factories -> {
            factories.add(((entity, random) -> new TradeOffer(
                new ItemStack(Items.OAK_PLANKS, 2),
                    new ItemStack(Items.CRAFTING_TABLE, 2),
                    10, 2, 0.02f)));});
        TradeOfferHelper.registerVillagerOffers(ALCHEMIST, 4, factories -> {
            factories.add(((entity, random) -> new TradeOffer(
                new ItemStack(Items.DIAMOND, 1),
                    new ItemStack(Items.STONE, 3),
                    new ItemStack(Items.BREWING_STAND, 1),
                    2, 1, 0.02f)));});

        //Adventurer
        TradeOfferHelper.registerVillagerOffers(ADVENTURER, 1, factories -> {
            factories.add(((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(ModItems.SILVER_INGOT, 1),
                    new ItemStack(ModItems.SILVERED_RAPIER, 1),
                    4, 2, 0.02f)));});
        TradeOfferHelper.registerVillagerOffers(ADVENTURER, 1, factories -> {
            factories.add(((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(ModItems.SILVER_INGOT, 2),
                    new ItemStack(ModItems.SILVERED_GREATSWORD, 1),
                    4, 2, 0.02f)));});
        TradeOfferHelper.registerVillagerOffers(ADVENTURER, 2, factories -> {
            factories.add(((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(ModItems.SILVER_INGOT, 1),
                    new ItemStack(ModItems.SILVERED_SHORTSWORD, 1),
                    4, 2, 0.02f)));});
        TradeOfferHelper.registerVillagerOffers(ADVENTURER, 2, factories -> {
            factories.add(((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 2),
                    new ItemStack(ModItems.SILVER_INGOT, 1),
                    new ItemStack(ModItems.SILVERED_IRON_SWORD, 1),
                    4, 2, 0.02f)));});
        TradeOfferHelper.registerVillagerOffers(ADVENTURER, 2, factories -> {
            factories.add(((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(ModItems.SILVER_INGOT, 2),
                    new ItemStack(ModItems.SILVERED_LONGSWORD, 1),
                    4, 2, 0.02f)));});
        TradeOfferHelper.registerVillagerOffers(ADVENTURER, 3, factories -> {
            factories.add(((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 2),
                    new ItemStack(ModItems.SILVER_INGOT, 1),
                    new ItemStack(ModItems.SILVERED_IRON_AXE, 1),
                    4, 2, 0.02f)));});
        TradeOfferHelper.registerVillagerOffers(ADVENTURER, 3, factories -> {
            factories.add(((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(ModItems.SILVER_INGOT, 1),
                    new ItemStack(ModItems.SILVERED_IRON_DAGGER, 1),
                    4, 2, 0.02f)));});
        TradeOfferHelper.registerVillagerOffers(ADVENTURER, 3, factories -> {
            factories.add(((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(ModItems.SILVER_INGOT, 2),
                    new ItemStack(ModItems.SILVERED_GLAIVE, 1),
                    4, 2, 0.02f)));});
        TradeOfferHelper.registerVillagerOffers(ADVENTURER, 4, factories -> {
            factories.add(((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(ModItems.SILVER_INGOT, 1),
                    new ItemStack(ModItems.SILVERED_IRON_SICKLE, 1),
                    4, 2, 0.02f)));});
    }
}
