package net.enderkitty.entity.client.models;

import net.enderkitty.DndMod;
import net.enderkitty.entity.entities.VampireSpawnEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

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


    @Override
    public void setLivingAnimations(VampireSpawnEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}
