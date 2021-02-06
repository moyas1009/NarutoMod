package com.moyas1009.mnarutomod;

import com.moyas1009.mnarutomod.capabilities.CapabilityHandler;
import com.moyas1009.mnarutomod.capabilities.ChakraCapability;
import com.moyas1009.mnarutomod.util.RegistryHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod("mnarutomod")
@Mod.EventBusSubscriber(modid = NarutoMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class NarutoMod
{

    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "mnarutomod";

    public NarutoMod() {

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        RegistryHandler.init();


        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(CapabilityHandler.class);
    }

    @SubscribeEvent
    public static void onRegisterBiome(final RegistryEvent.Register<Biome> event)
    {
        RegistryHandler.registerBiomes();
        System.out.println("It works!");
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        ChakraCapability.register();
    }

    private void doClientStuff(final FMLClientSetupEvent event)
    {

    }

    public static final ItemGroup TAB = new ItemGroup("nmodtab") {
        @Override
        public ItemStack createIcon(){
            return new ItemStack(RegistryHandler.BRONZE_RYO.get());
        }
    };
}
