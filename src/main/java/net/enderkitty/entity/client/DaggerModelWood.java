package net.enderkitty.entity.client;

import net.enderkitty.DndMod;
import net.enderkitty.entity.custom.DaggerEntityIron;
import net.enderkitty.entity.custom.DaggerEntityWood;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DaggerModelWood extends AnimatedGeoModel<DaggerEntityWood> {

    @Override
    public Identifier getModelResource(DaggerEntityWood object) {
        return new Identifier(DndMod.MOD_ID, "geo/dagger.geo.json");
    }

    @Override
    public Identifier getTextureResource(DaggerEntityWood object) {
        return new Identifier(DndMod.MOD_ID, "textures/item/wooden_dagger.png");
    }

    @Override
    public Identifier getAnimationResource(DaggerEntityWood animatable) {
        return new Identifier(DndMod.MOD_ID, "animations/dagger.animation.json");
    }
}
