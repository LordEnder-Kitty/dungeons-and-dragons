package net.enderkitty.entity.client.renderers;

import net.enderkitty.DndMod;
import net.enderkitty.entity.client.models.HostileVillagerModel;
import net.enderkitty.entity.entities.HostileVillagerEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class HostileVillagerRenderer extends GeoEntityRenderer<HostileVillagerEntity> {
    public HostileVillagerRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new HostileVillagerModel());
        this.shadowRadius = 0.6f;
    }

    @Override
    public Identifier getTextureResource(HostileVillagerEntity instance) {
        return new Identifier(DndMod.MOD_ID, "textures/entity/villager/hostile_villager.png");
    }

    @Override
    public RenderLayer getRenderType(HostileVillagerEntity animatable, float partialTicks, MatrixStack stack,
                                     VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder,
                                     int packedLightIn, Identifier textureLocation) {
        stack.scale(1f, 1f, 1f);


        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
