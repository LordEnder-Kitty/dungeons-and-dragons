package net.enderkitty.entity.client;

import net.enderkitty.DndMod;
import net.enderkitty.entity.custom.DaggerEntityDiamond;
import net.enderkitty.entity.custom.DaggerEntityIron;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DaggerModelDiamond extends AnimatedGeoModel<DaggerEntityDiamond> {

    @Override
    public Identifier getModelResource(DaggerEntityDiamond object) {
        return new Identifier(DndMod.MOD_ID, "geo/dagger.geo.json");
    }

    @Override
    public Identifier getTextureResource(DaggerEntityDiamond object) {
        return new Identifier(DndMod.MOD_ID, "textures/item/diamond_dagger.png");
    }

    @Override
    public Identifier getAnimationResource(DaggerEntityDiamond animatable) {
        return new Identifier(DndMod.MOD_ID, "animations/dagger.animation.json");
    }
}
