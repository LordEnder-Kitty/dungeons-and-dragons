package net.enderkitty.item.items;

import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SignItem;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModSignItem extends SignItem {
    public ModSignItem(Settings settings, Block standingBlock, Block wallBlock) {
        super(settings, standingBlock, wallBlock);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.literal("Work In Progress").formatted(Formatting.DARK_RED));


        super.appendTooltip(stack, world, tooltip, context);
    }
}
