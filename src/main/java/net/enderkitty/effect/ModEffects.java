package net.enderkitty.effect;

import net.enderkitty.DndMod;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEffects {
    public static final StatusEffect FREEZE = registerEffect("freeze", new FreezeEffect(StatusEffectCategory.HARMFUL, 3124687));

    private static StatusEffect registerEffect(String name, StatusEffect effect)
    {return Registry.register(Registry.STATUS_EFFECT, new Identifier(DndMod.MOD_ID, name), effect);}
    public static void registerEffects() {}
}
