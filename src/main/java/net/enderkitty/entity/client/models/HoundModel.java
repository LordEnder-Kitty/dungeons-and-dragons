package net.enderkitty.entity.client.models;

import net.enderkitty.DndMod;
import net.enderkitty.entity.entities.HoundEntity;
import net.enderkitty.entity.entities.VampireSpawnEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class HoundModel extends AnimatedGeoModel<HoundEntity> {
    @Override
    public Identifier getModelResource(HoundEntity object) {
        return new Identifier(DndMod.MOD_ID, "geo/hound.geo.json");
    }

    @Override
    public Identifier getTextureResource(HoundEntity object) {
        return new Identifier(DndMod.MOD_ID, "textures/entity/hound.png");
    }

    @Override
    public Identifier getAnimationResource(HoundEntity animatable) {
        return new Identifier(DndMod.MOD_ID, "animations/hound.animation.json");
    }

    @Override
    public void setLivingAnimations(HoundEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}
