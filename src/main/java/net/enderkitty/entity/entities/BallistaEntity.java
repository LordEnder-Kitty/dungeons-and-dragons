package net.enderkitty.entity.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.AnimationState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class BallistaEntity extends AbstractBallistaEntity implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);

    public BallistaEntity(EntityType<? extends AbstractBallistaEntity> entityType, World world) {super(entityType, world);}

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.vampire.idle", true));
        return PlayState.CONTINUE;
    }


    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController(this, "controller",
                0, this::predicate));
    }


    @Override
    public boolean canFreeze() {return false;}
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {return SoundEvents.ENTITY_SKELETON_HURT;}
    @Override
    protected SoundEvent getDeathSound() {return SoundEvents.ENTITY_SKELETON_DEATH;}

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }
}
