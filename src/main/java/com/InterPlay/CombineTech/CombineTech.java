package com.InterPlay.CombineTech;

import com.InterPlay.CombineTech.tileentities.renderer.ShieldInjectorRenderer;
import com.InterPlay.CombineTech.util.RegistryHandler;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

@Mod("combinetech")
public class CombineTech
{
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "combinetech"; // Aqui eu determinei que o meu MOD_ID será "combinetech"

    // Esse método é o que faz o mod realmente iniciar.
    public CombineTech() {
        // Aqui estou apenas dizendo que o
        // IEventBus, chamado "bus", se refere ao Forge mod loading context e que ele está buscando
        // pelo Event bus que tem lá.
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Aqui estou chamando o "init", localizado na classe "RegistryHandler", para que ele inicie-se.
        RegistryHandler.init();
        // Aqui estou iniciando todas as tile entities que foram registradas e que fizeram referência ao
        // DeferredRegister chamado TILE_ENTITY_TYPE, presente da classe que lida com registros.
        RegistryHandler.TILE_ENTITY_TYPE.register(bus);
        GeckoLib.initialize();

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) { }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public void doClientStuff(final FMLClientSetupEvent event) {
        ClientRegistry.bindTileEntityRenderer(RegistryHandler.TILE_ENTITY_SHIELD_INJECTOR.get(), ShieldInjectorRenderer::new);
    }

    // Aqui foi criada a aba personalizada para o meu mod. Se chama combineTechTab.
    // Após o sinal de = estou basicamente criando um novo objeto chamado "itemGroup.combineTechTab"
    // que deve ser nomeado no arquivo lang. Será o nome da aba mostrado dentro do jogo.
    public static final ItemGroup TAB = new ItemGroup("combineTechTab") {
        // Aqui ficou definido qual será o ícone da aba personalizada.
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(RegistryHandler.MOD_ICON.get());
        }
    };
}
