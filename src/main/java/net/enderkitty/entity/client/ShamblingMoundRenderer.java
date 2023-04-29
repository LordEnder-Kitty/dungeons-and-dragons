package net.enderkitty.entity.client;

import net.enderkitty.DndMod;
import net.enderkitty.entity.custom.ShamblingMoundEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class ShamblingMoundRenderer extends GeoEntityRenderer<ShamblingMoundEntity> {
    public ShamblingMoundRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new ShamblingMoundModel());
        this.shadowRadius = 2f;
    }

    @Override
    public Identifier getTextureResource(ShamblingMoundEntity instance) {
        return new Identifier(DndMod.MOD_ID, "textures/entity/shambling_mound.png");
    }

    @Override
    public RenderLayer getRenderType(ShamblingMoundEntity animatable, float partialTicks, MatrixStack stack,
                                     VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder,
                                     int packedLightIn, Identifier textureLocation) {
        stack.scale(2.4f, 2.4f, 2.4f);


        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
