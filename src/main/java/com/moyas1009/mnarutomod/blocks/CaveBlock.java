package com.moyas1009.mnarutomod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class CaveBlock extends Block
{

    public CaveBlock() {
        super(Block.Properties.create(Material.ROCK)
                .hardnessAndResistance(100f, 2000f)
                .sound(SoundType.STONE)
                .harvestLevel(3)
                .harvestTool(ToolType.PICKAXE)
        );
    }
}
