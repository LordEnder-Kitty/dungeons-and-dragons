package net.enderkitty.entity.client.renderers;

import net.enderkitty.DndMod;
import net.enderkitty.entity.client.models.DaggerModelGold;
import net.enderkitty.entity.custom.DaggerEntityGold;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoProjectilesRenderer;

public class DaggerRendererGold extends GeoProjectilesRenderer<DaggerEntityGold> {
    public DaggerRendererGold(EntityRendererFactory.Context ctx) {
        super(ctx, new DaggerModelGold());
    }

    @Override
    public Identifier getTextureLocation(DaggerEntityGold entity) {
        return new Identifier(DndMod.MOD_ID, "textures/item/golden_dagger.png");
    }

    @Override
    public RenderLayer getRenderType(DaggerEntityGold animatable, float partialTicks, MatrixStack stack,
                                     VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder,
                                     int packedLightIn, Identifier textureLocation) {
        stack.scale(0.75f, 0.75f, 0.75f);

        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
