package net.enderkitty.entity.client.renderers;

import net.enderkitty.DndMod;
import net.enderkitty.entity.client.models.VampireSpawnModel;
import net.enderkitty.entity.entities.VampireSpawnEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class VampireSpawnRenderer extends GeoEntityRenderer<VampireSpawnEntity> {
    public VampireSpawnRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new VampireSpawnModel());
        this.shadowRadius = 0.4f;
    }

    @Override
    public Identifier getTextureResource(VampireSpawnEntity instance) {
        return new Identifier(DndMod.MOD_ID, "textures/entity/vampire/vampire_spawn.png");
    }

    @Override
    public RenderLayer getRenderType(VampireSpawnEntity animatable, float partialTicks, MatrixStack stack,
                                     VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder,
                                     int packedLightIn, Identifier textureLocation) {
        stack.scale(1f, 1f, 1f);

        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
