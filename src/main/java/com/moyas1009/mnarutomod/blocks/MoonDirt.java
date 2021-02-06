package com.moyas1009.mnarutomod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class MoonDirt extends Block
{
    public MoonDirt() {
        super(Block.Properties.create(Material.EARTH)
                .hardnessAndResistance(0.5f, 0.5f)
                .sound(SoundType.SAND)
                .harvestLevel(0)
                .harvestTool(ToolType.SHOVEL)
        );
    }
}
