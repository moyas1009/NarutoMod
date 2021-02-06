package com.moyas1009.mnarutomod.capabilities;

import com.moyas1009.mnarutomod.NarutoMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod.EventBusSubscriber(modid = NarutoMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CapabilityHandler {
    public static final ResourceLocation PLAYER_CHAKRA = new ResourceLocation(NarutoMod.MOD_ID, "chakra");

    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent<Entity> event)
    {
        if (event.getObject() instanceof PlayerEntity)
            event.addCapability(PLAYER_CHAKRA, new ChakraCapability());

        Logger logger = LogManager.getLogger();
        logger.log(Level.DEBUG, "It fires");
    }
}
