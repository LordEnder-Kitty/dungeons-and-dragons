package net.enderkitty.entity.client.models;

import net.enderkitty.DndMod;
import net.enderkitty.entity.custom.DaggerEntityStone;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DaggerModelStone extends AnimatedGeoModel<DaggerEntityStone> {

    @Override
    public Identifier getModelResource(DaggerEntityStone object) {
        return new Identifier(DndMod.MOD_ID, "geo/dagger.geo.json");
    }

    @Override
    public Identifier getTextureResource(DaggerEntityStone object) {
        return new Identifier(DndMod.MOD_ID, "textures/item/stone_dagger.png");
    }

    @Override
    public Identifier getAnimationResource(DaggerEntityStone animatable) {
        return new Identifier(DndMod.MOD_ID, "animations/dagger.animation.json");
    }
}
