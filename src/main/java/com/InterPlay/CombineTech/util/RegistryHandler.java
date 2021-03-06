package com.InterPlay.CombineTech.util;

import com.InterPlay.CombineTech.CombineTech;
import com.InterPlay.CombineTech.blocks.BlockTab;
import com.InterPlay.CombineTech.blocks.ReactorCoreBlock;
import com.InterPlay.CombineTech.items.ItemTab;
import com.InterPlay.CombineTech.machines.ShieldInjectorBlock;
import com.InterPlay.CombineTech.tileentities.ShieldInjectorTE;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
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
    // Neste caso aqui, estou adicionando ao registro de objeto o "MOD_ICON", depois estou mandando registrá-lo com o nome verde
    // e
    public static final RegistryObject<Item> MOD_ICON = ITEMS.register("mod_icon", ItemTab::new);

    // Blocos
    // Dentro do <> deve-se colocar a classe da qual esta está extendendo as funcionalidades.
    // Aqui estou adicionando meu bloco ao registro de objetos e depois digo para registrar com o seguinte nome "em verde"
                                                                // a classe do bloco que está sendo referenciado aqui \/.
    public static final RegistryObject<Block> REACTOR_CORE_BLOCK = BLOCKS.register("reactor_core_block", ReactorCoreBlock::new);
    // Aqui estou registrando o injetor de escudo para o reator. Requer um nome de registro e um suplier (fornecedor).
    // Colocar "() ->" transformou a classe "ShieldInjectorBlock" num fornecedor. O new criou este fornecedor.
    public static final RegistryObject<Block> SHIELD_INJECTOR = BLOCKS.register("shield_injector", ShieldInjectorBlock::new);

    // Bloco-Item
    // Registra os blocos quando estão em sua mão, no formato de item.
    // Neste caso, ele está dizendo que o que deve aparecer na mão do player deverá ser o próprio bloco, em forma de item.
    // Porém, no arquivo "models/item/reactor_core_block.json" estou dizendo para usar a textura 2D padrão de item.
    // Isso significa que, na mão, o que será visto será o item, porém, no chão, o será visto será o bloco 3D.
    public static final RegistryObject<Item> REACTOR_CORE_ITEM = ITEMS.register("reactor_core_block", () -> new BlockTab(REACTOR_CORE_BLOCK.get()));
    public static final RegistryObject<Item> SHIELD_INJECTOR_ITEM = ITEMS.register("shield_injector", () -> new BlockTab(SHIELD_INJECTOR.get()));

    // Tile Entities
    // Para registrar uma tile entity eu só preciso citar este DeferredRegister um única vez.
    // Todas as outras tile entities devem fazer referência a ele no futuro, ao serem criadas.
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPE = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, CombineTech.MOD_ID);

    // Aqui estou adicionando ao registro de objeto um tipo de tile entity "injetor de escudo", com o nome TILE_ENTITY_SHIELD_INJECTOR
    // Depois estou dizendo para registrá-la na lista de tipos de tile entity com o nome "em verde" e acionei o
    // construtor de tipos de tile entities. Após isso mostrei pra ele uma referência à classe que corresponde à ese tipo de tile entity que estou criando,
    // mostrei pra ele o registro da classe e falei pra ele construir.
    // É necessário já ter criado a classe que extende TileEntity \/     nome da variável \/              \/  referência ao DeferredRegister
    public static final RegistryObject<TileEntityType<ShieldInjectorTE>> TILE_ENTITY_SHIELD_INJECTOR = TILE_ENTITY_TYPE
            // Nome de registro \/ que aparece no arquivo lang.    Isso aqui /\ é necessário ser colocado na classe do bloco
            .register("shield_injector", () -> TileEntityType.Builder.of(ShieldInjectorTE::new, RegistryHandler.SHIELD_INJECTOR.get()).build(null));
}
