package com.InterPlay.CombineTech.machines;

import com.InterPlay.CombineTech.models.ShieldInjectorModel;
import com.InterPlay.CombineTech.tileentities.renderer.ShieldInjectorRenderer;
import com.InterPlay.CombineTech.util.RegistryHandler;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;
import org.jetbrains.annotations.Nullable;

// Aqui estou criando e determinando que o injetor de escudo terá propriedades de um bloco.
// Por isso é necessário extender a classe "Block".
public class ShieldInjectorBlock extends Block {

    // Aqu estou determinando as propriedades do bloco, assim como nos outros blocos comuns.
    public ShieldInjectorBlock() {
        super(AbstractBlock.Properties
                .of(Material.METAL) // feito de metal
                .strength(10f) // 10f de resistencia
                .sound(SoundType.METAL) // tem som de metal
                .harvestLevel(2) // precisa de picareta de ferro ou melhor pra minerar
                .harvestTool(ToolType.PICKAXE) // precisa de uma ferramenta do tipo picareta pra minerar
        );
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true; // aqui estou dizendo que este bloco possui uma tile entity conectada a ele
    }

    @Nullable
    @Override
    // Aqui estou dizendo onde está registrada a tile entity que está conectada a ele
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return RegistryHandler.TILE_ENTITY_SHIELD_INJECTOR.get().create();
        // Termina com "create" pra criar a tile entity
    }

    public ShieldInjectorRenderer shieldInjectorRenderer(ShieldInjectorModel shieldInjectorModel) {
        return shieldInjectorRenderer(new ShieldInjectorModel());
    }

}
