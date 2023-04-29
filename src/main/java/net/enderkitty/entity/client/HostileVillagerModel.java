package net.enderkitty.entity.client;

import net.enderkitty.DndMod;
import net.enderkitty.entity.custom.HostileVillagerEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class HostileVillagerModel extends AnimatedGeoModel<HostileVillagerEntity> {
    @Override
    public Identifier getModelResource(HostileVillagerEntity object) {
        return new Identifier(DndMod.MOD_ID, "geo/hostile_villager.geo.json");
    }

    @Override
    public Identifier getTextureResource(HostileVillagerEntity object) {
        return new Identifier(DndMod.MOD_ID, "textures/entity/villager/hostile_villager.png");
    }

    @Override
    public Identifier getAnimationResource(HostileVillagerEntity animatable) {
        return new Identifier(DndMod.MOD_ID, "animations/hostile_villager.animation.json");
    }
}
