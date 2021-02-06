package com.moyas1009.mnarutomod.capabilities;

import net.minecraft.nbt.FloatNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ChakraCapability implements ICapabilitySerializable<FloatNBT>
{
    @CapabilityInject(IChakra.class)
    public static final Capability<Chakra> CHAKRA_CAPABILITY = null;
    private LazyOptional<Chakra> instance = LazyOptional.of(CHAKRA_CAPABILITY::getDefaultInstance);

    public static void register()
    {
        CapabilityManager.INSTANCE.register(IChakra.class, new ChakraStorage(), Chakra::new);
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side)
    {
        return CHAKRA_CAPABILITY.orEmpty(cap, instance);
    }

    @Override
    public FloatNBT serializeNBT()
    {
        return (FloatNBT) CHAKRA_CAPABILITY.getStorage().writeNBT(CHAKRA_CAPABILITY, instance.orElseThrow(() -> new IllegalArgumentException("LazyOptional cannot be empty")), null);
    }

    @Override
    public void deserializeNBT(FloatNBT nbt)
    {
        CHAKRA_CAPABILITY.getStorage().readNBT(CHAKRA_CAPABILITY, instance.orElseThrow(() -> new IllegalArgumentException("LazyOptional cannot be empty")), null, nbt);
    }
}
