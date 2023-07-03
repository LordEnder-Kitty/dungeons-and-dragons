package net.enderkitty.item.items;

import net.enderkitty.effect.ModEffects;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class WizardStaffItem extends SwordItem {
    public WizardStaffItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ITEM_FIRECHARGE_USE, SoundCategory.NEUTRAL, 0.5F, 1);

        ItemStack fireCharge = new ItemStack(Items.FIRE_CHARGE);
        Direction direction = user.getHorizontalFacing();

        /* Middle Fireball */
        FireballEntity proj = new FireballEntity(EntityType.FIREBALL, world);
        if (!world.isClient && direction == Direction.NORTH && user.getInventory().count(fireCharge.getItem()) > 0) {
            proj.setPos(user.getX(), user.getEyeY() +1, user.getZ() -2);
            proj.setOwner(user); world.spawnEntity(proj); user.getInventory().removeOne(fireCharge);
        } else if (direction == Direction.EAST && user.getInventory().count(fireCharge.getItem()) > 0) {
            proj.setPos(user.getX() +2, user.getEyeY() +1, user.getZ());
            proj.setOwner(user); world.spawnEntity(proj); user.getInventory().removeOne(fireCharge);;
        } else if (direction == Direction.SOUTH && user.getInventory().count(fireCharge.getItem()) > 0) {
            proj.setPos(user.getX(), user.getEyeY() +1, user.getZ() +2);
            proj.setOwner(user); world.spawnEntity(proj); user.getInventory().removeOne(fireCharge);;
        } else if (direction == Direction.WEST && user.getInventory().count(fireCharge.getItem()) > 0) {
            proj.setPos(user.getX() -2, user.getEyeY() +1, user.getZ());
            proj.setOwner(user); world.spawnEntity(proj); user.getInventory().removeOne(fireCharge);;
        }

        /* Left Fireball */
        FireballEntity proj2 = new FireballEntity(EntityType.FIREBALL, world);
        if (!world.isClient && user.isSneaking() && direction == Direction.NORTH && user.getInventory().count(fireCharge.getItem()) > 0) {
            proj2.setPos(user.getX() -2, user.getEyeY() -.5, user.getZ() -2);
            proj2.setOwner(user); world.spawnEntity(proj2); user.getInventory().removeOne(fireCharge);;
        } else if (user.isSneaking() && direction == Direction.SOUTH && user.getInventory().count(fireCharge.getItem()) > 0) {
            proj2.setPos(user.getX() -2, user.getEyeY() -.5, user.getZ() +2);
            proj2.setOwner(user); world.spawnEntity(proj2); user.getInventory().removeOne(fireCharge);;
        } else if (user.isSneaking() && direction == Direction.EAST && user.getInventory().count(fireCharge.getItem()) > 0) {
            proj2.setPos(user.getX() +2, user.getEyeY() -.5, user.getZ() -2);
            proj2.setOwner(user); world.spawnEntity(proj2); user.getInventory().removeOne(fireCharge);;
        } else if (user.isSneaking() && direction == Direction.WEST && user.getInventory().count(fireCharge.getItem()) > 0) {
            proj2.setPos(user.getX() -2, user.getEyeY() -.5, user.getZ() -2);
            proj2.setOwner(user); world.spawnEntity(proj2); user.getInventory().removeOne(fireCharge);;
        }

        /* Right Fireball */
        FireballEntity proj3 = new FireballEntity(EntityType.FIREBALL, world);
        if (!world.isClient && user.isSneaking() && direction == Direction.NORTH && user.getInventory().count(fireCharge.getItem()) > 0) {
            proj3.setPos(user.getX() +2, user.getEyeY() -.5, user.getZ() -2);
            proj3.setOwner(user); world.spawnEntity(proj3); user.getInventory().removeOne(fireCharge);;
        } else if (user.isSneaking() && direction == Direction.SOUTH && user.getInventory().count(fireCharge.getItem()) > 0) {
            proj3.setPos(user.getX() +2, user.getEyeY() -.5, user.getZ() +2);
            proj3.setOwner(user);world.spawnEntity(proj3); user.getInventory().removeOne(fireCharge);;
        } else if (user.isSneaking() && direction == Direction.EAST && user.getInventory().count(fireCharge.getItem()) > 0) {
            proj3.setPos(user.getX() +2, user.getEyeY() -.5, user.getZ() +2);
            proj3.setOwner(user);world.spawnEntity(proj3); user.getInventory().removeOne(fireCharge);;
        } else if (user.isSneaking() && direction == Direction.WEST && user.getInventory().count(fireCharge.getItem()) > 0) {
            proj3.setPos(user.getX() -2, user.getEyeY() -.5, user.getZ() +2);
            proj3.setOwner(user);world.spawnEntity(proj3); user.getInventory().removeOne(fireCharge);;
        }


        user.getItemCooldownManager().set(this, 20);

        ItemStack thisItemStack = user.getStackInHand(hand);
        return TypedActionResult.success(thisItemStack, world.isClient());
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker.isSneaking()) {
            target.addStatusEffect(new StatusEffectInstance(ModEffects.FREEZE, 200, 0), attacker);
        }
        return super.postHit(stack, target, attacker);
    }


    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.mage_staff.fireball"));
        tooltip.add(Text.translatable("tooltip.mage_staff.freeze"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
