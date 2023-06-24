package net.enderkitty.item.items;

import net.enderkitty.item.ModItems;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.*;

public class HalfPlateArmorItem extends ArmorItem implements IAnimatable {
    private final AnimationFactory factory = new AnimationFactory(this);

    public HalfPlateArmorItem(ArmorMaterial materialIn, EquipmentSlot slot, Settings builder) {
        super(materialIn, slot, builder);
    }

    // Predicate runs every frame
    private <P extends IAnimatable> PlayState predicate(AnimationEvent<P> event) {
        LivingEntity livingEntity = event.getExtraDataOfType(LivingEntity.class).get(0);


        if (livingEntity.isSprinting() && !livingEntity.isSneaking()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.running", true));
        } else if (livingEntity.isSneaking()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.crouching", true));
        } else if (!livingEntity.isSprinting() && !livingEntity.isSneaking()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.normal", true));
            return PlayState.CONTINUE;
        }

        if (livingEntity instanceof ArmorStandEntity) {
            return PlayState.CONTINUE;
        }

        List<Item> armorList = new ArrayList<>(4);
        for (EquipmentSlot slot : EquipmentSlot.values()) {
            if (slot.getType() == EquipmentSlot.Type.ARMOR) {
                if (livingEntity.getEquippedStack(slot) != null) {
                    armorList.add(livingEntity.getEquippedStack(slot).getItem());
                }
            }
        }

        boolean isWearingAll = new HashSet<>(armorList).contains(ModItems.HALF_PLATE_CHESTPLATE);
        return isWearingAll ? PlayState.CONTINUE : PlayState.STOP;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller", 20, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }
}
