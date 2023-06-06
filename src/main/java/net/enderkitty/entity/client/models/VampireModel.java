package net.enderkitty.entity.client.models;

import net.enderkitty.DndMod;
import net.enderkitty.entity.entities.VampireEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class VampireModel extends AnimatedGeoModel<VampireEntity> {
    @Override
    public Identifier getModelResource(VampireEntity object) {
        return new Identifier(DndMod.MOD_ID, "geo/vampire.geo.json");
    }

    @Override
    public Identifier getTextureResource(VampireEntity object) {
        return new Identifier(DndMod.MOD_ID, "textures/entity/vampire/vampire.png");
    }

    @Override
    public Identifier getAnimationResource(VampireEntity animatable) {
        return new Identifier(DndMod.MOD_ID, "animations/vampire.animation.json");
    }
}
