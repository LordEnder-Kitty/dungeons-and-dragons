package net.enderkitty.entity.client.models;

import net.enderkitty.DndMod;
import net.enderkitty.entity.entities.DaggerEntityNetherite;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DaggerModelNetherite extends AnimatedGeoModel<DaggerEntityNetherite> {

    @Override
    public Identifier getModelResource(DaggerEntityNetherite object) {
        return new Identifier(DndMod.MOD_ID, "geo/dagger.geo.json");
    }

    @Override
    public Identifier getTextureResource(DaggerEntityNetherite object) {
        return new Identifier(DndMod.MOD_ID, "textures/item/netherite_dagger.png");
    }

    @Override
    public Identifier getAnimationResource(DaggerEntityNetherite animatable) {
        return new Identifier(DndMod.MOD_ID, "animations/dagger.animation.json");
    }
}
