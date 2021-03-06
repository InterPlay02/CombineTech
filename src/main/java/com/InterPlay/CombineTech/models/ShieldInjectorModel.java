package com.InterPlay.CombineTech.models;

import com.InterPlay.CombineTech.CombineTech;
import com.InterPlay.CombineTech.tileentities.ShieldInjectorTE;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

    // Aqui eu apenas estou dizendo onde estão localizados os recursos do block animado
    // É necessário ter o Geckolib como uma dependência
    // Todas as letras aqui, dentro das aspas verdes devem ser minusculas e, portanto, os arquivos associados tbm.
public class ShieldInjectorModel extends AnimatedGeoModel<ShieldInjectorTE> {

    @Override
    public ResourceLocation getModelLocation(ShieldInjectorTE shieldInjector) {
        return new ResourceLocation(CombineTech.MOD_ID, "geo/shield_injector.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(ShieldInjectorTE shieldInjector) {
        return new ResourceLocation(CombineTech.MOD_ID, "textures/tileentities/shield_injector.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(ShieldInjectorTE shieldInjector) {
        return new ResourceLocation(CombineTech.MOD_ID, "animations/injector.animation.json");
    }

}
