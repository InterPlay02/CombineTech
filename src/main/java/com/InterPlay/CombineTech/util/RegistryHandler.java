package com.InterPlay.CombineTech.util;

import com.InterPlay.CombineTech.CombineTech;
import com.InterPlay.CombineTech.blocks.BlockItems;
import com.InterPlay.CombineTech.blocks.ReactorCoreBlock;
import com.InterPlay.CombineTech.items.ItemMain;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {
    // Acionando o registrador adiado de itens e blocos e depois criando um novo registro de itens e blocos aqui.
    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CombineTech.MOD_ID);
    public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CombineTech.MOD_ID);

    // Inicializa nossos itens, blocos e outros no jogo.
    // O init aqui pode ser chamado de outra classe para iniciar o registro dos items e blocos.
    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // Itens
    // Itens listados aqui estão registrados como parte do jogo.
    // Para adicionar novos itens, basta copiar esta linha abaixo e alterar o nome em maiúsculo e o nome entre aspas.
    // Depois, basta copiar o arquivo json dentro de "models/blocks" ou de "models/items" e alterar o nome dentro e fora.
    // E, por último, adicionar a textura dentro de "textures/blocks" ou de "textures/items" com o nome igual ao que está nestas aspas aqui.
    public static final RegistryObject<Item> MOD_ICON = ITEMS.register("mod_icon", ItemMain::new);

    // Blocos
    // Dentro do <> deve-se colocar a classe da qual esta está extendendo as funcionalidades.
    public static final RegistryObject<Block> RECTOR_CORE_BLOCK = BLOCKS.register("reactor_core_block", ReactorCoreBlock::new);

    // Bloco Item
    // Registra os blocos quando estão em sua mão, no formato de item.
    // Neste caso, ele está dizendo que o que deve aparecer na mão do player deverá ser o próprio bloco, em forma de item.
    // Porém, no arquivo "models/item/reactor_core_block.json" estou dizendo para usar a textura 2D padrão de item.
    // Isso significa que, na mão, o que será visto será o item, porém, no chão, o será visto será o bloco 3D.
    public static final RegistryObject<Item> REACTOR_CORE_ITEM = ITEMS.register("reactor_core_block", () -> new BlockItems(RECTOR_CORE_BLOCK.get()));

}
