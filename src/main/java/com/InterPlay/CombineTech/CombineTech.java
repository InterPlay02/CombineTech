package com.InterPlay.CombineTech;

import com.InterPlay.CombineTech.util.RegistryHandler;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("combinetech")
public class CombineTech
{
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "combinetech"; // Aqui eu determinei que o meu MOD_ID será "combinetech"

    public CombineTech() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Aqui estou chamando o "init", localizado na classe "RegistryHandler", para que ele inicie-se.
        RegistryHandler.init();

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) { }

    private void doClientStuff(final FMLClientSetupEvent event) { }

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
