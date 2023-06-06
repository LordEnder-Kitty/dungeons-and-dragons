package net.enderkitty.entity.client.renderers;

import net.enderkitty.DndMod;
import net.enderkitty.entity.client.models.PriestModel;
import net.enderkitty.entity.custom.PriestEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class PriestRenderer extends GeoEntityRenderer<PriestEntity> {
    public PriestRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new PriestModel());
        this.shadowRadius = 0.6f;
    }

    @Override
    public Identifier getTextureResource(PriestEntity instance) {
        return new Identifier(DndMod.MOD_ID, "textures/entity/priest.png");
    }

    @Override
    public RenderLayer getRenderType(PriestEntity animatable, float partialTicks, MatrixStack stack,
                                     VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder,
                                     int packedLightIn, Identifier textureLocation) {
        stack.scale(1f, 1f, 1f);


        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
