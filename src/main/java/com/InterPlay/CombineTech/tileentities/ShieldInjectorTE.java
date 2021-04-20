package com.InterPlay.CombineTech.tileentities;

import com.InterPlay.CombineTech.util.RegistryHandler;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class ShieldInjectorTE extends TileEntity implements IAnimatable {
    // CRIANDO A TILE ENTITY! ---------------------------------------------------------------------------

    // Aqui estou dizendo que esta Tile Entity aqui (através do "this") está registrada com este nome
    public ShieldInjectorTE(){
        super(RegistryHandler.TILE_ENTITY_SHIELD_INJECTOR.get());
    }

    // LIDANDO COM AS ANIMAÇÕES! ------------------------------------------------------------------------

    private <E extends TileEntity & IAnimatable> PlayState predicate(AnimationEvent<E> event){
        // Futuro if
        event.getController().transitionLengthTicks = 0;
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.injector.mekanism", true));
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller", 0, this::predicate));
    }

    private AnimationFactory factory = new AnimationFactory(this);

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

}
