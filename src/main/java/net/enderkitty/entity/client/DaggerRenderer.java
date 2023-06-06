package net.enderkitty.entity.client;

import net.enderkitty.DndMod;
import net.enderkitty.entity.custom.DaggerEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoProjectilesRenderer;

public class DaggerRenderer extends GeoProjectilesRenderer<DaggerEntity> {
    public DaggerRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new DaggerModel());
    }

    @Override
    public Identifier getTextureLocation(DaggerEntity entity) {
        return new Identifier(DndMod.MOD_ID, "textures/item/iron_dagger.png");
    }

    @Override
    public RenderLayer getRenderType(DaggerEntity animatable, float partialTicks, MatrixStack stack,
                                     VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder,
                                     int packedLightIn, Identifier textureLocation) {
        stack.scale(0.75f, 0.75f, 0.75f);

        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
