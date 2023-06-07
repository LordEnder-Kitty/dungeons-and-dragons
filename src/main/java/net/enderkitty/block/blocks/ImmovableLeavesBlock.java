package net.enderkitty.block.blocks;

import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;

public class ImmovableLeavesBlock extends LeavesBlock {
    public ImmovableLeavesBlock(Settings settings) {
        super(settings);
    }

    @Override
    public PistonBehavior getPistonBehavior(BlockState state) {
        return PistonBehavior.BLOCK;
    }
}
