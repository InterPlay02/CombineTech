package com.InterPlay.CombineTech.blocks;

import com.InterPlay.CombineTech.CombineTech;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

// Esse constructor extende as funcionalidade da classe chamada "BlockItem", que é padrão do Minecraft
// Essa classe padrão pede que os blocos tenham um tipo e uma propriedade
public class BlockTab extends BlockItem {

    // Mantive o tipo
    // Esse tipo é o que vai ser usado para definir o nome do bloco no arquivo lang "tipo.modid.name".
   public BlockTab(Block block) {
        // Porém adicionei minha própria propriedade ao bloco, além de dizer que ele ficará na aba do meu mod
        // As abas padrão do Minecraft são ItemGroup.TAB
        super(block, new Item.Properties().tab(CombineTech.TAB));
   }
}
