package net.enderkitty.entity.client.models;

import net.enderkitty.DndMod;
import net.enderkitty.entity.entities.BallistaEntity;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class BallistaModel <T extends MobEntity> extends AnimatedGeoModel<BallistaEntity> {
    @Override
    public Identifier getModelResource(BallistaEntity object) {
        return new Identifier(DndMod.MOD_ID, "geo/vampire.geo.json");
    }

    @Override
    public Identifier getTextureResource(BallistaEntity object) {
        return new Identifier(DndMod.MOD_ID, "textures/entity/vampire/vampire.png");
    }

    @Override
    public Identifier getAnimationResource(BallistaEntity animatable) {
        return new Identifier(DndMod.MOD_ID, "animations/vampire.animation.json");
    }

    @Override
    public void setLivingAnimations(BallistaEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setCustomAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("Head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}
