package com.ore.oreplant.render;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public interface IColorProvider {

    int getColor(IBlockAccess world, IBlockState state, BlockPos pos, ItemStack stack);
}
