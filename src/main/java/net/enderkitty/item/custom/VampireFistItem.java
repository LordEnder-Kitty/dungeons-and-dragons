package net.enderkitty.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class VampireFistItem extends SwordItem {
    public VampireFistItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 800, 2), attacker);
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 800, 1), attacker);
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 400, 1), attacker);
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 800, 0), attacker);
        return super.postHit(stack, target, attacker);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.literal("Claws that where surgically removed from a vampires hands.").formatted(Formatting.DARK_PURPLE));
        } else {
            tooltip.add(Text.literal("Press SHIFT").formatted(Formatting.DARK_RED));
        }

        super.appendTooltip(stack, world, tooltip, context);
    }


}
