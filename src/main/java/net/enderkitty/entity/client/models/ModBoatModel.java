package net.enderkitty.entity.client.models;

import net.enderkitty.DndMod;
import net.enderkitty.entity.ModBoatModelLayer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.BoatEntityModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

import java.util.function.Function;
import java.util.function.Supplier;

public class ModBoatModel {
    private static boolean isInitialized = false;

    private static void initialize() {
        if (isInitialized) return;
        isInitialized = true;

        ModBoatModelLayer.boat = addModel("boats", () -> BoatEntityModel.getTexturedModelData(false), r -> new BoatEntityModel(r, false));
        ModBoatModelLayer.boatChest = addModel("boat_chest", () -> BoatEntityModel.getTexturedModelData(true), r -> new BoatEntityModel(r, true));
    }

    private static EntityModelLayer addModel(String name, Supplier<TexturedModelData> supplier, Function<ModelPart, EntityModel<?>> modelConstructor) {
        return addLayer(name, supplier);
    }

    private static EntityModelLayer addLayer(String name, Supplier<TexturedModelData> supplier) {
        EntityModelLayer location = new EntityModelLayer(new Identifier(DndMod.MOD_ID, name), "main");
        ModBoatModelLayer.layerDefinitions.put(location, supplier);
        return location;
    }

    public static void registerLayers() {
        initialize();

        for (EntityModelLayer location : ModBoatModelLayer.layerDefinitions.keySet()) {
            EntityModelLayerRegistry.registerModelLayer(location, () -> ModBoatModelLayer.layerDefinitions.get(location).get());
        }
    }
}
