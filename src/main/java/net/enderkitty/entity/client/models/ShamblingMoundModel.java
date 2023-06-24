package net.enderkitty.entity.client.models;

import net.enderkitty.DndMod;
import net.enderkitty.entity.entities.ShamblingMoundEntity;
import net.enderkitty.entity.entities.VampireSpawnEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class ShamblingMoundModel extends AnimatedGeoModel<ShamblingMoundEntity> {
    @Override
    public Identifier getModelResource(ShamblingMoundEntity object) {
        return new Identifier(DndMod.MOD_ID, "geo/shambling_mound.geo.json");
    }

    @Override
    public Identifier getTextureResource(ShamblingMoundEntity object) {
        return new Identifier(DndMod.MOD_ID, "textures/entity/shambling_mound.png");
    }

    @Override
    public Identifier getAnimationResource(ShamblingMoundEntity animatable) {
        return new Identifier(DndMod.MOD_ID, "animations/shambling_mound.animation.json");
    }

    @Override
    public void setLivingAnimations(ShamblingMoundEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}
