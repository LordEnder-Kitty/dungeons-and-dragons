package net.enderkitty.block.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FacingBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

public class KegBlock extends FacingBlock {
    public KegBlock(Settings settings) {super(settings); this.stateManager.getDefaultState().with(Properties.FACING, Direction.UP);}

    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {return this.getDefaultState().with(FACING, ctx.getSide());}
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {stateManager.add(Properties.FACING);}
}
