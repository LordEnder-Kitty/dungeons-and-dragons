package net.enderkitty.entity.client.renderers;

import net.enderkitty.DndMod;
import net.enderkitty.entity.client.models.DaggerModelWood;
import net.enderkitty.entity.custom.DaggerEntityWood;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoProjectilesRenderer;

public class DaggerRendererWood extends GeoProjectilesRenderer<DaggerEntityWood> {
    public DaggerRendererWood(EntityRendererFactory.Context ctx) {
        super(ctx, new DaggerModelWood());
    }

    @Override
    public Identifier getTextureLocation(DaggerEntityWood entity) {
        return new Identifier(DndMod.MOD_ID, "textures/item/wooden_dagger.png");
    }

    @Override
    public RenderLayer getRenderType(DaggerEntityWood animatable, float partialTicks, MatrixStack stack,
                                     VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder,
                                     int packedLightIn, Identifier textureLocation) {
        stack.scale(0.75f, 0.75f, 0.75f);

        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
