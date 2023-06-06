package net.enderkitty.entity.client.renderers;

import com.google.common.collect.Maps;
import net.enderkitty.DndMod;
import net.enderkitty.entity.ModBoatEntity;
import net.enderkitty.entity.ModBoatModelLayer;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.BoatEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import com.ibm.icu.impl.Pair;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Quaternion;
import net.minecraft.util.math.Vec3f;

import java.util.Map;

public class ModBoatRenderer <T extends ModBoatEntity> extends EntityRenderer<T> {
    private final Map<ModBoatEntity.Type, Pair<Identifier, BoatEntityModel>> boatResources = Maps.newHashMap();

    public ModBoatRenderer(EntityRendererFactory.Context context, boolean hasChest) {
        super(context);
        for (ModBoatEntity.Type type : ModBoatEntity.Type.values()) {
            String folder = hasChest ? "chest_boat" : "boat";
            Identifier texture = new Identifier(DndMod.MOD_ID, "textures/entity/" + folder + "/" + type.getName() + ".png");
            BoatEntityModel model = new BoatEntityModel(context.getPart(hasChest ? ModBoatModelLayer.boatChest : ModBoatModelLayer.boat), hasChest);
            boatResources.put(type, Pair.of(texture, model));
        }
    }

    @Override
    public void render(T boat, float entityYaw, float partialTicks, MatrixStack matrixStack, VertexConsumerProvider buffer, int packedLight) {
        matrixStack.push();
        matrixStack.translate(0.0, 0.375, 0.0);
        matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(180.0f - entityYaw));

        float f = (float) boat.getDamageWobbleTicks() - partialTicks;
        float g = boat.getDamageWobbleStrength() - partialTicks;
        if (g < 0.0f) g = 0.0f;
        if (f > 0.0f)
            matrixStack.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(MathHelper.sin(f) * f * g / 10.0f * (float) boat.getDamageWobbleSide()));

        if (!MathHelper.approximatelyEquals(boat.interpolateBubbleWobble(partialTicks), 0.0f)) {
            matrixStack.multiply(new Quaternion(new Vec3f(1.0f, 0.0f, 1.0f), boat.interpolateBubbleWobble(partialTicks), true));
        }

        Pair<Identifier, BoatEntityModel> pair = this.boatResources.get(boat.getWoodType());
        Identifier resourceLocation = pair.first;
        BoatEntityModel boatModel = pair.second;
        matrixStack.scale(-1.0f, -1.0f, 1.0f);
        matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(90.0f));
        boatModel.setAngles(boat, partialTicks, 0.0f, -0.1f, 0.0f, 0.0f);

        VertexConsumer vertexConsumer = buffer.getBuffer(boatModel.getLayer(resourceLocation));
        boatModel.render(matrixStack, vertexConsumer, packedLight, OverlayTexture.DEFAULT_UV, 1.0f, 1.0f, 1.0f, 1.0f);

        if (!boat.isSubmergedInWater()) {
            VertexConsumer vertexConsumer2 = buffer.getBuffer(RenderLayer.getWaterMask());
            boatModel.getWaterPatch().render(matrixStack, vertexConsumer2, packedLight, OverlayTexture.DEFAULT_UV);
        }

        matrixStack.pop();

        super.render(boat, entityYaw, partialTicks, matrixStack, buffer, packedLight);
    }

    @Override
    public Identifier getTexture(ModBoatEntity boat) {
        return boatResources.get(boat.getWoodType()).first;
    }
}
