package net.enderkitty.block.blocks;

import net.enderkitty.block.ModBlocks;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.block.pattern.BlockPatternBuilder;
import net.minecraft.block.pattern.CachedBlockPosition;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.predicate.block.BlockStatePredicate;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.function.MaterialPredicate;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import org.jetbrains.annotations.Nullable;

public class CustomBlock extends Block {
    public CustomBlock(Settings settings) {
        super(settings);
    }

    @Nullable
    private BlockPattern entityPattern;


    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (oldState.isOf(state.getBlock())) {
            return;
        }
        this.trySpawnEntity(world, pos);
    }

    private void trySpawnEntity(World world, BlockPos pos) {
        block9: {
            BlockPattern.Result result;
            result = this.getSummonPattern().searchAround(world, pos);
            if (result == null) break block9;
            for (int i = 0; i < this.getSummonPattern().getWidth(); ++i) {
                for (int k = 0; k < this.getSummonPattern().getHeight(); ++k) {
                    CachedBlockPosition cachedBlockPosition3 = result.translate(i, k, 0);
                    world.setBlockState(cachedBlockPosition3.getBlockPos(), Blocks.AIR.getDefaultState(), Block.NOTIFY_LISTENERS);
                    world.syncWorldEvent(WorldEvents.BLOCK_BROKEN, cachedBlockPosition3.getBlockPos(), Block.getRawIdFromState(cachedBlockPosition3.getBlockState()));
                }
            }
            BlockPos blockPos2 = result.translate(1, 1, 0).getBlockPos();
            ZombieEntity zombieEntity = EntityType.ZOMBIE.create(world);
            assert zombieEntity != null;
            zombieEntity.refreshPositionAndAngles((double)blockPos2.getX() + 0.5, (double)blockPos2.getY() + 0.05, (double)blockPos2.getZ() + 0.5, 0.0f, 0.0f);
            world.spawnEntity(zombieEntity);
            for (ServerPlayerEntity serverPlayerEntity : world.getNonSpectatingEntities(ServerPlayerEntity.class, zombieEntity.getBoundingBox().expand(5.0))) {
                Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, zombieEntity);
            }
            for (int j = 0; j < this.getSummonPattern().getWidth(); ++j) {
                for (int l = 0; l < this.getSummonPattern().getHeight(); ++l) {
                    CachedBlockPosition cachedBlockPosition4 = result.translate(j, l, 0);
                    world.updateNeighbors(cachedBlockPosition4.getBlockPos(), Blocks.AIR);
                }
            }
        }
    }

    private BlockPattern getSummonPattern() {
        if (this.entityPattern == null) {
            this.entityPattern = BlockPatternBuilder.start().aisle(
                    "~^~",
                    "~#~")
                    .where('^', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(ModBlocks.ENTITY_SPAWNING_BLOCK)))
                    .where('#', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(Blocks.DIAMOND_BLOCK)))
                    .where('~', CachedBlockPosition.matchesBlockState(MaterialPredicate.create(Material.AIR))).build();
        }
        return this.entityPattern;
    }
}
