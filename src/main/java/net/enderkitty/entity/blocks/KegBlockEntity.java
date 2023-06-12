package net.enderkitty.entity.blocks;

import net.enderkitty.entity.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;

public class KegBlockEntity extends BlockEntity {
    public KegBlockEntity(BlockPos pos, BlockState state) {super(ModBlockEntities.KEG_BLOCK_ENTITY, pos, state);}

    int aleAmount = 20;

    public int getAleAmount() {return aleAmount;}
    public void setAleAmount(int amount) {this.aleAmount = amount;}


    @Override
    public void writeNbt(NbtCompound nbt) {
        nbt.putInt("number", aleAmount);
        super.writeNbt(nbt);
    }
    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt); aleAmount = nbt.getInt("number");
    }
}
