package com.InterPlay.CombineTech.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class ReactorCoreBlock extends Block {

    // Aqui eu criei uma variável de propriedades com nome de "ROTATION" e associei ela com a classe HorizontalBlock
    // e já conectei ela à propriedade "FACING" que está presente nesta classe.
    private static final DirectionProperty ROTATION = HorizontalBlock.FACING;

    // Aqui importei o formato voxel que exportei usando o Blockbench.
    // Está basicamente dizendo ao jogo qual é o formato real do bloco em 3D quando colocado no mundo.
    private static final VoxelShape ALL_SHAPES = Stream.of(
            Block.box(6, 2, 6, 10, 6, 10),
            Block.box(6, 2.00366, 6.00884, 10, 6.00366, 10.00884),
            Block.box(6.00884, 2.00366, 6, 10.00884, 6.00366, 10),
            Block.box(5.9, 2, 5.9, 10.1, 6.1, 10.1)
    ).reduce((v1, v2) -> {return VoxelShapes.join(v1, v2, IBooleanFunction.OR);}).get();

    // Criando um bloco
    public ReactorCoreBlock() {
        // Definindo a propriedade do como como Metal
        super(AbstractBlock.Properties.of(Material.METAL)
            // Quão difícil é pra minerar e o quão resistente é à explosões
            .strength(4.0f, 6.0f)
            // o nível que é necessário a ferramente ter para minerar (0=madeira, 1=pedra, 2=ferro, 3=diamante)
            .harvestLevel(2)
            .requiresCorrectToolForDrops()
            // Tipo de ferramenta necessária pra minerar
            .harvestTool(ToolType.PICKAXE)
            // O som que toca ao colocar e ao quebrar
            .sound(SoundType.METAL)

        );
    }

    // Aqui estou definindo que, ao colocar um bloco no mundo, o formato do voxel será o que está na variável ALL_SHAPES.
    // Eu poderia usar mais de um, para o caso de blocos com formatos únicos que precisam ser griados conforme o
    // a rotação do player na hora de colocá-lo.
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context){
        return ALL_SHAPES;
        //switch
    }

    // Aqui euestou basicamente dizendo que, quando o bloco for colocado no mundo, deverá rotacionar de acordo
    // com a direção que o player estiver olhando e colocará o bloco virado na direção oposta.
    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context){
        return this.defaultBlockState().setValue(ROTATION, context.getHorizontalDirection().getOpposite());
    }

    // Aparentemente, esta parte lida com dados NBT usados para rotacionar o bloco na direção correta, de
    // acordo com o que for decidido em ROTATION.
    @Override
    public BlockState rotate(BlockState direction, Rotation rot){
        return direction.setValue(ROTATION, rot.rotate(direction.getValue(ROTATION)));
    }

    // Aqui acontece algo.
    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn){
        return state.rotate(mirrorIn.getRotation(state.getValue(ROTATION)));
    }

    // Aqui preenchemos o container de estado com o que foi passado nos três metodos acima.
    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder){
        builder.add(ROTATION);
    }

    // Aqui estou definindo a escuridão da sombra do bloco quando colocado no mundo.
    // Quanto mais próximo de 1, mas clara a sombra é. Quanto mais prómixo de 0, mais escura é.
    @Override
    public float getShadeBrightness(BlockState state, IBlockReader worldIn, BlockPos pos){
        return 0.8f;
    }
}
