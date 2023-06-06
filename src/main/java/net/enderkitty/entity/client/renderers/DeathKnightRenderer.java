package net.enderkitty.entity.client.renderers;

import net.enderkitty.DndMod;
import net.enderkitty.entity.client.models.DeathKnightModel;
import net.enderkitty.entity.custom.DeathKnightEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class DeathKnightRenderer extends GeoEntityRenderer<DeathKnightEntity> {
    public DeathKnightRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new DeathKnightModel());
        this.shadowRadius = 0.4f;
    }

    @Override
    public Identifier getTextureResource(DeathKnightEntity instance) {
        return new Identifier(DndMod.MOD_ID, "textures/entity/knight.png");
    }

    @Override
    public RenderLayer getRenderType(DeathKnightEntity animatable, float partialTicks, MatrixStack stack,
                                     VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder,
                                     int packedLightIn, Identifier textureLocation) {
        stack.scale(1f, 1f, 1f);

        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
