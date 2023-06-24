package net.enderkitty.entity.client.armor;

import net.enderkitty.item.items.VampireArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class VampireArmorRenderer extends GeoArmorRenderer<VampireArmorItem> {
    public VampireArmorRenderer() {
        super(new VampireArmorModel());

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
