package net.enderkitty.entity.client.models;

import net.enderkitty.DndMod;
import net.enderkitty.entity.entities.VampireEntity;
import net.enderkitty.entity.entities.VampireSpawnEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class VampireModel extends AnimatedGeoModel<VampireEntity> {
    @Override
    public Identifier getModelResource(VampireEntity object) {
        return new Identifier(DndMod.MOD_ID, "geo/vampire.geo.json");
    }

    @Override
    public Identifier getTextureResource(VampireEntity object) {
        return new Identifier(DndMod.MOD_ID, "textures/entity/vampire/vampire.png");
    }

    @Override
    public Identifier getAnimationResource(VampireEntity animatable) {
        return new Identifier(DndMod.MOD_ID, "animations/vampire.animation.json");
    }

    @Override
    public void setLivingAnimations(VampireEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("Head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}
