package net.enderkitty.item.items;

import net.enderkitty.effect.ModEffects;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.ItemStack;
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
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ITEM_FIRECHARGE_USE, SoundCategory.NEUTRAL, 0.5F, 2);

        if (!world.isClient) {
            FireballEntity proj = new FireballEntity(EntityType.FIREBALL, world);
            proj.setPos(user.getX(), user.getEyeY() - .5, user.getZ());
            proj.setOwner(user);
          //proj.setVelocity(user, user.getPitch(), user.getYaw(), 0, 4, 1);
            world.spawnEntity(proj);
        }

        user.getItemCooldownManager().set(this, 20 * 3);

        return TypedActionResult.success(itemStack, world.isClient());
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
