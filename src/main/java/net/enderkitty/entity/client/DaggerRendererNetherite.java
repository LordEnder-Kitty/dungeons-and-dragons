package net.enderkitty.entity.client;

import net.enderkitty.DndMod;
import net.enderkitty.entity.custom.DaggerEntityIron;
import net.enderkitty.entity.custom.DaggerEntityNetherite;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoProjectilesRenderer;

public class DaggerRendererNetherite extends GeoProjectilesRenderer<DaggerEntityNetherite> {
    public DaggerRendererNetherite(EntityRendererFactory.Context ctx) {
        super(ctx, new DaggerModelNetherite());
    }

    @Override
    public Identifier getTextureLocation(DaggerEntityNetherite entity) {
        return new Identifier(DndMod.MOD_ID, "textures/item/netherite_dagger.png");
    }

    @Override
    public RenderLayer getRenderType(DaggerEntityNetherite animatable, float partialTicks, MatrixStack stack,
                                     VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder,
                                     int packedLightIn, Identifier textureLocation) {
        stack.scale(0.75f, 0.75f, 0.75f);

        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
