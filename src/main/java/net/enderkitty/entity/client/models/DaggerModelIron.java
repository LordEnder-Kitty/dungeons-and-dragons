package net.enderkitty.entity.client.models;

import net.enderkitty.DndMod;
import net.enderkitty.entity.entities.DaggerEntityIron;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DaggerModelIron extends AnimatedGeoModel<DaggerEntityIron> {

    @Override
    public Identifier getModelResource(DaggerEntityIron object) {
        return new Identifier(DndMod.MOD_ID, "geo/dagger.geo.json");
    }

    @Override
    public Identifier getTextureResource(DaggerEntityIron object) {
        return new Identifier(DndMod.MOD_ID, "textures/item/iron_dagger.png");
    }

    @Override
    public Identifier getAnimationResource(DaggerEntityIron animatable) {
        return new Identifier(DndMod.MOD_ID, "animations/dagger.animation.json");
    }
}
