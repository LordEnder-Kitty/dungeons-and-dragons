package net.enderkitty.potion;

import net.enderkitty.DndMod;
import net.enderkitty.item.ModItems;
import net.enderkitty.mixin.BrewingRecipeRegistryMixin;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BloodLossPotion {
    public static Potion BLOOD_LOSS_POTION;

    public static Potion registerPotion(String name) {
        return Registry.register(Registry.POTION, new Identifier(DndMod.MOD_ID, name),
                new Potion(new StatusEffectInstance(StatusEffects.NAUSEA, 800, 2), new StatusEffectInstance(StatusEffects.WEAKNESS, 800, 0),
                        new StatusEffectInstance(StatusEffects.WITHER, 400, 1), new StatusEffectInstance(StatusEffects.SLOWNESS, 800, 1)));
    }

    public static void registerPotions() {
        BLOOD_LOSS_POTION = registerPotion("blood_loss_potion");

        registerPotionRecipes();
    }

    private static void registerPotionRecipes() {
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, ModItems.SHARPENED_BONE_FRAGMENT, BloodLossPotion.BLOOD_LOSS_POTION);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, ModItems.RAW_PLATINUM, Potions.POISON);
    }
}
