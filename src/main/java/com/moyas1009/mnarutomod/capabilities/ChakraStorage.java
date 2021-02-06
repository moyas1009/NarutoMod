package com.moyas1009.mnarutomod.capabilities;

import net.minecraft.command.arguments.NBTCompoundTagArgument;
import net.minecraft.command.arguments.NBTTagArgument;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.FloatNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

public class ChakraStorage implements Capability.IStorage<IChakra>
{

    @Nullable
    @Override
    public INBT writeNBT(Capability<IChakra> capability, IChakra instance, Direction side) {
        return FloatNBT.valueOf(instance.getChakra());
    }

    @Override
    public void readNBT(Capability<IChakra> capability, IChakra instance, Direction side, INBT nbt)
    {
        if (!(instance instanceof Chakra))
            throw new IllegalArgumentException("Can not deserialize to an instance that isn't the default implementation");
        instance.set(((FloatNBT)nbt).getFloat());
    }
}
