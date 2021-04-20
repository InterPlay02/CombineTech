package com.InterPlay.CombineTech.tileentities.renderer;

import com.InterPlay.CombineTech.tileentities.ShieldInjectorTE;
import com.InterPlay.CombineTech.models.ShieldInjectorModel;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

public class ShieldInjectorRenderer extends GeoBlockRenderer<ShieldInjectorTE> {

    @Override
    public RenderType getRenderType(ShieldInjectorTE animate, float partialTicks, MatrixStack stack,
    IRenderTypeBuffer renderTypeBuffer, IVertexBuilder vertexBuilder, int packedLightIn, ResourceLocation resourceLocation) {
        return RenderType.entitySolid(getTextureLocation(animate));

    }

    public ShieldInjectorRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn, new ShieldInjectorModel());
    }
}
