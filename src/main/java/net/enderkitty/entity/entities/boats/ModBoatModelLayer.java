package net.enderkitty.entity.entities.boats;

import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.EntityModelLayer;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ModBoatModelLayer {

    public static final Map<EntityModelLayer, Supplier<TexturedModelData>> layerDefinitions = new HashMap<>();
    public static EntityModelLayer boat;
    public static EntityModelLayer boatChest;
}
