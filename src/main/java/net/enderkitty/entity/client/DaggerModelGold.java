package net.enderkitty.entity.client;

import net.enderkitty.DndMod;
import net.enderkitty.entity.custom.DaggerEntityGold;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DaggerModelGold extends AnimatedGeoModel<DaggerEntityGold> {

    @Override
    public Identifier getModelResource(DaggerEntityGold object) {
        return new Identifier(DndMod.MOD_ID, "geo/dagger.geo.json");
    }

    @Override
    public Identifier getTextureResource(DaggerEntityGold object) {
        return new Identifier(DndMod.MOD_ID, "textures/item/golden_dagger.png");
    }

    @Override
    public Identifier getAnimationResource(DaggerEntityGold animatable) {
        return new Identifier(DndMod.MOD_ID, "animations/dagger.animation.json");
    }
}
