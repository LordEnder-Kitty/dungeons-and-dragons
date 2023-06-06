package net.enderkitty.entity.client.models;

import net.enderkitty.DndMod;
import net.enderkitty.entity.custom.ShamblingMoundEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ShamblingMoundModel extends AnimatedGeoModel<ShamblingMoundEntity> {
    @Override
    public Identifier getModelResource(ShamblingMoundEntity object) {
        return new Identifier(DndMod.MOD_ID, "geo/shambling_mound.geo.json");
    }

    @Override
    public Identifier getTextureResource(ShamblingMoundEntity object) {
        return new Identifier(DndMod.MOD_ID, "textures/entity/shambling_mound.png");
    }

    @Override
    public Identifier getAnimationResource(ShamblingMoundEntity animatable) {
        return new Identifier(DndMod.MOD_ID, "animations/shambling_mound.animation.json");
    }
}
