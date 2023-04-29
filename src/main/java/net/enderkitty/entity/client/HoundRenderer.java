package net.enderkitty.entity.client;

import net.enderkitty.DndMod;
import net.enderkitty.entity.custom.HoundEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class HoundRenderer extends GeoEntityRenderer<HoundEntity> {
    public HoundRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new HoundModel());
        this.shadowRadius = 1f;
    }

    @Override
    public Identifier getTextureResource(HoundEntity instance) {
        return new Identifier(DndMod.MOD_ID, "textures/entity/hound.png");
    }

    @Override
    public RenderLayer getRenderType(HoundEntity animatable, float partialTicks, MatrixStack stack,
                                     VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder,
                                     int packedLightIn, Identifier textureLocation) {
        stack.scale(1f, 1f, 1f);


        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
