/*
 * Decompiled with CFR 0.2.0 (FabricMC d28b102d).
 */
package net.enderkitty.entity.client;

import net.enderkitty.entity.custom.DaggerEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.TridentEntityModel;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3f;

@Environment(value=EnvType.CLIENT)
public class DaggerRenderer extends EntityRenderer<DaggerEntity> {
    public static final Identifier TEXTURE = new Identifier("textures/entity/trident.png");
    private final DaggerModel model;

    public DaggerRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.model = new DaggerModel(context.getPart(EntityModelLayers.TRIDENT));
    }

    @Override
    public void render(DaggerEntity daggerEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(MathHelper.lerp(g, daggerEntity.prevYaw, daggerEntity.getYaw()) - 90.0f));
        matrixStack.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(MathHelper.lerp(g, daggerEntity.prevPitch, daggerEntity.getPitch()) + 90.0f));
        VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumerProvider, this.model.getLayer(this.getTexture(daggerEntity)), false, daggerEntity.shouldRenderName());
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0f, 1.0f, 1.0f, 1.0f);
        matrixStack.pop();
        super.render(daggerEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(DaggerEntity daggerEntity) {
        return TEXTURE;
    }
}
