package net.enderkitty.item;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    //Light Armor
    PADDED("padded", 5, new int[]{1, 2, 3, 1}, 12,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () -> {
        return Ingredient.ofItems(Items.LEATHER);}),
    STUDDED("studded", 6, new int[]{1, 3, 3, 1}, 12,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () -> {
        return Ingredient.ofItems(Items.LEATHER);}),

    //Medium Armor
    HIDE("hide", 8, new int[]{2, 2, 3, 1}, 12,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 1.0F, 0.0F, () -> {
        return Ingredient.ofItems(Items.LEATHER);}),
    SCALE("scale", 10, new int[]{2, 2, 3, 1}, 12,
            SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0.0F, 0.0F, () -> {
        return Ingredient.ofItems(ModItems.LEATHER_RINGING);}),
    HALF_PLATE("half_plate", 15, new int[]{2, 2, 6, 2}, 10,
    SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
        return Ingredient.ofItems(Items.IRON_INGOT);}),

    //Heavy Armor
    RING_MAIL("ring_mail", 14, new int[]{1, 3, 4, 1}, 11,
    SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0.0F, 0.0F, () -> {
        return Ingredient.ofItems(ModItems.LEATHER_RINGING);}),
    SPLINT("splint", 15, new int[]{1, 4, 5, 2}, 12,
    SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
        return Ingredient.ofItems(Items.IRON_INGOT);}),

    //Cloak
    CLOAK("cloak", 14, new int[]{1, 3, 3, 1}, 20,
    SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0f, 0.0f, () -> {
        return Ingredient.ofItems(Items.LEATHER);});


    private static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Lazy<Ingredient> repairIngredientSupplier;

    private ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier repairIngredientSupplier) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredientSupplier = new Lazy(repairIngredientSupplier);
    }

    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * this.durabilityMultiplier;
    }

    public int getProtectionAmount(EquipmentSlot slot) {
        return this.protectionAmounts[slot.getEntitySlotId()];
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    public Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredientSupplier.get();
    }

    public String getName() {
        return this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
