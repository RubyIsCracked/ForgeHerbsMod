package com.moosy.herbs.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class OosBlock extends Block {

    public OosBlock() {
        super(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(7.0f, 10.0f)
                .sound(SoundType.METAL)
                .harvestLevel(3)
                .lightValue((int) 2.0)
                .harvestTool(ToolType.PICKAXE)

        );
    }
}
