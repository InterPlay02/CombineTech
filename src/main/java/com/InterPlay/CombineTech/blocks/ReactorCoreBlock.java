package com.InterPlay.CombineTech.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class ReactorCoreBlock extends Block {

    // Criando um bloco
    public ReactorCoreBlock() {
        // Definindo a propriedade do como como Metal
        super(AbstractBlock.Properties.of(Material.METAL)
            // Quão difícil é pra minerar e o quão resistente é à explosões
            .strength(5.0f, 6.0f)
            // o nível que é necessário a ferramente ter para minerar (0=madeira, 1=pedra, 2=ferro, 3=diamante)
            .harvestLevel(2)
            // Tipo de ferramenta necessária pra minerar
            .harvestTool(ToolType.PICKAXE)
            // O som que toca ao colocar e ao quebrar
            .sound(SoundType.METAL)

        );
    }
}
