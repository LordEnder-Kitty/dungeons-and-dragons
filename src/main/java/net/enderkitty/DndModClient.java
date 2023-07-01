package net.enderkitty;

import net.enderkitty.block.ModBlocks;
import net.enderkitty.bombage.BombEntity;
import net.enderkitty.bombage.DndModBlockEntityRenderer;
import net.enderkitty.entity.client.armor.VampireArmorRenderer;
import net.enderkitty.entity.entities.boats.ModBoatEntities;
import net.enderkitty.entity.ModEntities;
import net.enderkitty.entity.client.armor.HalfPlateArmorRenderer;
import net.enderkitty.entity.client.models.ModBoatModel;
import net.enderkitty.entity.client.renderers.*;
import net.enderkitty.fluid.ModFluids;
import net.enderkitty.item.ModItems;
import net.enderkitty.screen.AlchemyScreen;
import net.enderkitty.screen.ModScreenHandlers;
import net.enderkitty.util.ModModelPredicateProvider;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

import java.util.function.Function;

public class DndModClient implements ClientModInitializer {
    public static void registryRenders() {
        registerBlockEntityRender(ModEntities.MY_BOMB, e -> ModBlocks.MY_BOMB.getDefaultState());
    }
    private static <T extends BombEntity> void registerBlockEntityRender(EntityType<T> block, Function<T, BlockState> stateGetter) {
        EntityRendererRegistry.register(block, ctx -> new DndModBlockEntityRenderer<>(ctx, stateGetter));
    }

    @Override
    public void onInitializeClient() {

        ModModelPredicateProvider.registerModModels();
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_BLOOD, ModFluids.FLOWING_BLOOD,
                new SimpleFluidRenderHandler(
                        new Identifier("minecraft:block/water_still"),
                        new Identifier("minecraft:block/water_flow"),
                        0xA1c40000
                ));

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.STILL_BLOOD, ModFluids.FLOWING_BLOOD);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ALCHEMY_TABLE, RenderLayer.getTranslucent());
        HandledScreens.register(ModScreenHandlers.ALCHEMY_SCREEN_HANDLER, AlchemyScreen::new);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ADVENTURING_TABLE, RenderLayer.getTranslucent());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.STONE_STATUE, RenderLayer.getCutout());

        GeoArmorRenderer.registerArmorRenderer(new HalfPlateArmorRenderer(), ModItems.HALF_PLATE_BOOTS,
                ModItems.HALF_PLATE_LEGGINGS, ModItems.HALF_PLATE_CHESTPLATE, ModItems.HALF_PLATE_HELMET);
        GeoArmorRenderer.registerArmorRenderer(new VampireArmorRenderer(), ModItems.VAMPIRE_BOOTS,
                ModItems.VAMPIRE_LEGGINGS, ModItems.VAMPIRE_CHESTPLATE, ModItems.VAMPIRE_HELMET);


        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BALL_BEARINGS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ALDER_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_ALDER_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ASH_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_ASH_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BALSA_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_BALSA_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ALDER_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ALDER_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ASH_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ASH_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BALSA_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BALSA_TRAPDOOR, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HOP_PLANT, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FOG_BLOCK, RenderLayer.getTranslucent());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MUG_OF_WATER, RenderLayer.getTranslucent());


        EntityRendererRegistry.register(ModEntities.HOUND, HoundRenderer::new);
        EntityRendererRegistry.register(ModEntities.VAMPIRE_SPAWN, VampireSpawnRenderer::new);
        EntityRendererRegistry.register(ModEntities.SHAMBLING_MOUND, ShamblingMoundRenderer::new);
        EntityRendererRegistry.register(ModEntities.VAMPIRE, VampireRenderer::new);
        EntityRendererRegistry.register(ModEntities.HOSTILE_VILLAGER, HostileVillagerRenderer::new);
        EntityRendererRegistry.register(ModEntities.PRIEST, PriestRenderer::new);
        EntityRendererRegistry.register(ModEntities.DEATH_KNIGHT, DeathKnightRenderer::new);

        EntityRendererRegistry.register(ModEntities.DAGGER_WOOD, DaggerRendererWood::new);
        EntityRendererRegistry.register(ModEntities.DAGGER_STONE, DaggerRendererStone::new);
        EntityRendererRegistry.register(ModEntities.DAGGER_GOLD, DaggerRendererGold::new);
        EntityRendererRegistry.register(ModEntities.DAGGER_IRON, DaggerRendererIron::new);
        EntityRendererRegistry.register(ModEntities.DAGGER_DIAMOND, DaggerRendererDiamond::new);
        EntityRendererRegistry.register(ModEntities.DAGGER_NETHERITE, DaggerRendererNetherite::new);

        EntityRendererRegistry.register(ModBoatEntities.BOAT.get(), context -> new ModBoatRenderer<>(context,false));
        EntityRendererRegistry.register(ModBoatEntities.CHEST_BOAT.get(), context -> new ModBoatRenderer<>(context, true));
        ModBoatModel.registerLayers();

        DndModClient.registryRenders();
    }
}
