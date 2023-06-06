package net.enderkitty.entity.client;

import net.enderkitty.DndMod;
import net.enderkitty.entity.custom.DaggerEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DaggerModel extends AnimatedGeoModel<DaggerEntity> {

    @Override
    public Identifier getModelResource(DaggerEntity object) {
        return new Identifier(DndMod.MOD_ID, "geo/dagger.geo.json");
    }

    @Override
    public Identifier getTextureResource(DaggerEntity object) {
        return new Identifier(DndMod.MOD_ID, "textures/item/iron_dagger.png");
    }

    @Override
    public Identifier getAnimationResource(DaggerEntity animatable) {
        return new Identifier(DndMod.MOD_ID, "animations/dagger.animation.json");
    }
}
