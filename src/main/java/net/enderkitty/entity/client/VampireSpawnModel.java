package net.enderkitty.entity.client;

import net.enderkitty.DndMod;
import net.enderkitty.entity.custom.VampireSpawnEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class VampireSpawnModel extends AnimatedGeoModel<VampireSpawnEntity> {
    @Override
    public Identifier getModelResource(VampireSpawnEntity object) {
        return new Identifier(DndMod.MOD_ID, "geo/vampire_spawn.geo.json");
    }

    @Override
    public Identifier getTextureResource(VampireSpawnEntity object) {
        return new Identifier(DndMod.MOD_ID, "textures/entity/vampire/vampire_spawn.png");
    }

    @Override
    public Identifier getAnimationResource(VampireSpawnEntity animatable) {
        return new Identifier(DndMod.MOD_ID, "animations/vampire_spawn.animation.json");
    }
}
