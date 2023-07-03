package net.enderkitty.entity.client.renderers;

import net.enderkitty.DndMod;
import net.enderkitty.entity.client.models.BallistaModel;
import net.enderkitty.entity.entities.BallistaEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class BallistaRenderer extends GeoEntityRenderer<BallistaEntity> {
    public BallistaRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new BallistaModel());
        this.shadowRadius = 1f;
    }

    @Override
    public Identifier getTextureResource(BallistaEntity instance) {
        return new Identifier(DndMod.MOD_ID, "textures/entity/vampire/vampire.png");
    }

    @Override
    public RenderLayer getRenderType(BallistaEntity animatable, float partialTicks, MatrixStack stack,
                                     VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder,
                                     int packedLightIn, Identifier textureLocation) {
        stack.scale(1f, 1f, 1f);


        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
