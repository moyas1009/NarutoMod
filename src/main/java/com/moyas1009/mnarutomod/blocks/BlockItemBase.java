package com.moyas1009.mnarutomod.blocks;

import com.moyas1009.mnarutomod.NarutoMod;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class BlockItemBase extends BlockItem
{

    public BlockItemBase(Block blockIn) {
        super(blockIn, new Item.Properties().group(NarutoMod.TAB));
    }
}
