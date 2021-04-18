package com.InterPlay.CombineTech.tileentities.renderer;

import com.InterPlay.CombineTech.tileentities.ShieldInjectorTE;
import com.InterPlay.CombineTech.models.ShieldInjectorModel;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

public class ShieldInjectorRenderer extends GeoBlockRenderer<ShieldInjectorTE> {

    public ShieldInjectorRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn, new ShieldInjectorModel());
    }
}
