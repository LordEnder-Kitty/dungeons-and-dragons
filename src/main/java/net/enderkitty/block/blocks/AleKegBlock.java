package net.enderkitty.block.blocks;

import net.enderkitty.entity.blocks.KegBlockEntity;
import net.enderkitty.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.FacingBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class AleKegBlock extends FacingBlock implements BlockEntityProvider {
    public AleKegBlock(Settings settings) {
        super(settings);
        this.stateManager.getDefaultState().with(Properties.FACING, Direction.UP);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {return new KegBlockEntity(pos, state);}


    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        KegBlockEntity kegBlockEntity = (KegBlockEntity) world.getBlockEntity(pos);
        if (player.getStackInHand(hand).getItem() == ModItems.MUG && kegBlockEntity != null && kegBlockEntity.getAleAmount() != 0) {
            itemStack.decrement(1);
            world.playSound(player, pos, SoundEvents.ENTITY_GENERIC_SPLASH, SoundCategory.BLOCKS, 0.5f, 1.5f);
            if (kegBlockEntity.getAleAmount() > 0) {
                kegBlockEntity.setAleAmount(kegBlockEntity.getAleAmount() - 1);
                player.giveItemStack(new ItemStack(ModItems.MUG_OF_ALE));
                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.PASS;
    }


    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getSide());
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(Properties.FACING);
    }


    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        KegBlockEntity kegBlockEntity = (KegBlockEntity) world.getBlockEntity(pos);
        ItemStack itemStack = new ItemStack(this);
        NbtCompound nbtCompound = new NbtCompound();
        assert kegBlockEntity != null;
        nbtCompound.putInt("aleAmount", kegBlockEntity.getAleAmount());
        itemStack.setSubNbt("BlockEntityTag", nbtCompound);
        ItemEntity itemEntity = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), itemStack);
        world.spawnEntity(itemEntity);
        super.onBreak(world, pos, state, player);
    }
    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);
        if (itemStack.hasNbt() && itemStack.getNbt().contains("BlockEntityTag")) {
            KegBlockEntity kegBlockEntity = (KegBlockEntity) world.getBlockEntity(pos);
            if (kegBlockEntity != null) {
                kegBlockEntity.setAleAmount(itemStack.getNbt().getInt("aleAmount"));
            }
        }
    }
}
