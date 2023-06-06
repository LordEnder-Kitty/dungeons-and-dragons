package net.enderkitty.entity.client.renderers;

import net.enderkitty.DndMod;
import net.enderkitty.entity.client.models.DaggerModelStone;
import net.enderkitty.entity.custom.DaggerEntityStone;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoProjectilesRenderer;

public class DaggerRendererStone extends GeoProjectilesRenderer<DaggerEntityStone> {
    public DaggerRendererStone(EntityRendererFactory.Context ctx) {
        super(ctx, new DaggerModelStone());
    }

    @Override
    public Identifier getTextureLocation(DaggerEntityStone entity) {
        return new Identifier(DndMod.MOD_ID, "textures/item/stone_dagger.png");
    }

    @Override
    public RenderLayer getRenderType(DaggerEntityStone animatable, float partialTicks, MatrixStack stack,
                                     VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder,
                                     int packedLightIn, Identifier textureLocation) {
        stack.scale(0.75f, 0.75f, 0.75f);

        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
