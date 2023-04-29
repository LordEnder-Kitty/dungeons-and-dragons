package net.enderkitty.entity.client;

import net.enderkitty.DndMod;
import net.enderkitty.entity.custom.DeathKnightEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DeathKnightModel extends AnimatedGeoModel<DeathKnightEntity> {
    @Override
    public Identifier getModelResource(DeathKnightEntity object) {
        return new Identifier(DndMod.MOD_ID, "geo/knight.geo.json");
    }

    @Override
    public Identifier getTextureResource(DeathKnightEntity object) {
        return new Identifier(DndMod.MOD_ID, "textures/entity/knight.png");
    }

    @Override
    public Identifier getAnimationResource(DeathKnightEntity animatable) {
        return new Identifier(DndMod.MOD_ID, "animations/knight.animation.json");
    }
}
