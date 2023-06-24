package net.enderkitty.entity.client.armor;

import net.enderkitty.DndMod;
import net.enderkitty.item.items.HalfPlateArmorItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class HalfPlateArmorModel extends AnimatedGeoModel<HalfPlateArmorItem> {
    @Override
    public Identifier getModelResource(HalfPlateArmorItem object) {
        return new Identifier(DndMod.MOD_ID, "geo/armor/half_plate_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(HalfPlateArmorItem object) {
        return new Identifier(DndMod.MOD_ID, "textures/models/armor/half_plate_armor.png");
    }

    @Override
    public Identifier getAnimationResource(HalfPlateArmorItem animatable) {
        return new Identifier(DndMod.MOD_ID, "animations/half_plate_armor.animation.json");
    }
}
