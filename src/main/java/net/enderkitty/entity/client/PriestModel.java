package net.enderkitty.entity.client;

import net.enderkitty.DndMod;
import net.enderkitty.entity.custom.PriestEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PriestModel extends AnimatedGeoModel<PriestEntity> {
    @Override
    public Identifier getModelResource(PriestEntity object) {
        return new Identifier(DndMod.MOD_ID, "geo/priest.geo.json");
    }

    @Override
    public Identifier getTextureResource(PriestEntity object) {
        return new Identifier(DndMod.MOD_ID, "textures/entity/priest.png");
    }

    @Override
    public Identifier getAnimationResource(PriestEntity animatable) {
        return new Identifier(DndMod.MOD_ID, "animations/priest.animation.json");
    }
}
