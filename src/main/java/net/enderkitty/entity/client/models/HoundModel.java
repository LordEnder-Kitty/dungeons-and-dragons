package net.enderkitty.entity.client.models;

import net.enderkitty.DndMod;
import net.enderkitty.entity.entities.HoundEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class HoundModel extends AnimatedGeoModel<HoundEntity> {
    @Override
    public Identifier getModelResource(HoundEntity object) {
        return new Identifier(DndMod.MOD_ID, "geo/hound.geo.json");
    }

    @Override
    public Identifier getTextureResource(HoundEntity object) {
        return new Identifier(DndMod.MOD_ID, "textures/entity/hound.png");
    }

    @Override
    public Identifier getAnimationResource(HoundEntity animatable) {
        return new Identifier(DndMod.MOD_ID, "animations/hound.animation.json");
    }
}
