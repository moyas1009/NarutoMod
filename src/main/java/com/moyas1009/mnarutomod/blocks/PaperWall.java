package com.moyas1009.mnarutomod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class PaperWall extends Block {
    public PaperWall() {
        super(Block.Properties.create(Material.BAMBOO)
                .hardnessAndResistance(0.3F, 0f)
                .sound(SoundType.BAMBOO)
                .harvestLevel(0)
                .harvestTool(ToolType.AXE)

        );
    }
}
