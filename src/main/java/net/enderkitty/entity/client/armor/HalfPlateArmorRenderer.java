package net.enderkitty.entity.client.armor;

import net.enderkitty.item.items.HalfPlateArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class HalfPlateArmorRenderer extends GeoArmorRenderer<HalfPlateArmorItem> {
    public HalfPlateArmorRenderer() {
        super(new HalfPlateArmorModel());

        this.headBone = "armorHead";
        this.bodyBone = "armorBody";
        this.rightArmBone = "armorRightArm";
        this.leftArmBone = "armorLeftArm";
        this.rightLegBone = "armorRightLeg";
        this.leftLegBone = "armorLeftLeg";
        this.rightBootBone = "armorRightBoot";
        this.leftBootBone = "armorLeftBoot";
    }
}
