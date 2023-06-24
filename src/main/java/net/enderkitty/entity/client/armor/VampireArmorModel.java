package net.enderkitty.entity.client.armor;

import net.enderkitty.DndMod;
import net.enderkitty.item.items.HalfPlateArmorItem;
import net.enderkitty.item.items.VampireArmorItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class VampireArmorModel extends AnimatedGeoModel<VampireArmorItem> {
    @Override
    public Identifier getModelResource(VampireArmorItem object) {
        return new Identifier(DndMod.MOD_ID, "geo/armor/vampire_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(VampireArmorItem object) {
        return new Identifier(DndMod.MOD_ID, "textures/models/armor/vampire_armor.png");
    }

    @Override
    public Identifier getAnimationResource(VampireArmorItem animatable) {
        return new Identifier(DndMod.MOD_ID, "animations/dagger.animation.json");
    }
}
