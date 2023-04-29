package net.enderkitty.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent BOTTLE_OF_BLOOD = (new FoodComponent.Builder()).hunger(4).saturationModifier(0.1F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600, 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200, 0), 1.0F).alwaysEdible().build();
    public static final FoodComponent SILVER_CARROT = (new FoodComponent.Builder()).hunger(6).saturationModifier(1.2F).build();
    public static final FoodComponent SILVER_MELON = (new FoodComponent.Builder()).hunger(8).saturationModifier(1F).build();
    public static final FoodComponent PLATINUM = (new FoodComponent.Builder()).hunger(0).saturationModifier(0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600, 0), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 300, 0), 1.0f).build();

    //The Tavern
    public static final FoodComponent ALE = (new FoodComponent.Builder()).hunger(1).saturationModifier(0.3f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 1000, 0), 0.5f).alwaysEdible().build();
    public static final FoodComponent MUG_OF_WATER = (new FoodComponent.Builder()).hunger(0).saturationModifier(0f).alwaysEdible().build();

    public static final FoodComponent SMALL_BREAD = new FoodComponent.Builder().hunger(4).saturationModifier(0.4f).build();


}
